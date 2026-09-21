import os

import pandas as pd
from sqlalchemy import (
    Column,
    Float,
    ForeignKey,
    Integer,
    MetaData,
    String,
    Table,
    create_engine,
    func,
    insert,
    select,
    text,
    update,
)
from sqlalchemy.orm import declarative_base, mapped_column, relationship, sessionmaker

DB_ARQUIVO = "sistema_rh.db"


if os.path.exists(DB_ARQUIVO):
    os.remove(DB_ARQUIVO)


print("=" * 60, "\nNÍVEL 1 — SQL puro\n", "=" * 60, sep="")


engine = create_engine(f"sqlite:///{DB_ARQUIVO}")


with engine.begin() as conn:
    conn.execute(
        text(
            """
            CREATE TABLE IF NOT EXISTS funcionarios (
                id      INTEGER PRIMARY KEY AUTOINCREMENT,
                nome    TEXT    NOT NULL,
                cargo   TEXT    NOT NULL,
                salario REAL    NOT NULL
            )
            """
        )
    )


entrada_maliciosa = "Robert'); DROP TABLE funcionarios;--"
consulta_vulneravel = (
    f"INSERT INTO funcionarios (nome) VALUES ('{entrada_maliciosa}')"
)
print("Como ficaria concatenando strings (NÃO execute isto):")
print("  ", consulta_vulneravel, "\n")

novo_funcionario = {"nome": "Ana Souza", "cargo": "Desenvolvedor Júnior", "salario": 4200.00}

with engine.begin() as conn:
    conn.execute(
        text(
            "INSERT INTO funcionarios (nome, cargo, salario) "
            "VALUES (:nome, :cargo, :salario)"
        ),
        novo_funcionario,
    )
    
    conn.execute(
        text(
            "INSERT INTO funcionarios (nome, cargo, salario) "
            "VALUES (:nome, :cargo, :salario)"
        ),
        [
            {"nome": "Bruno Lima", "cargo": "Desenvolvedor Júnior", "salario": 4000.00},
            {"nome": "Carla Mendes", "cargo": "Desenvolvedor Pleno", "salario": 7500.00},
            {"nome": "Diego Rocha", "cargo": "Analista de Dados", "salario": 6200.00},
            {"nome": "Elisa Prado", "cargo": "Analista de Dados", "salario": 6800.00},
            {"nome": "Fábio Nunes", "cargo": "Gerente de TI", "salario": 12000.00},
            {"nome": entrada_maliciosa, "cargo": "Estagiário", "salario": 1800.00},
        ],
    )


df = pd.read_sql_query("SELECT * FROM funcionarios", engine)
print(df.to_string(index=False))
print("\nA tabela 'funcionarios' continua existindo: o ataque não funcionou.\n")


print("=" * 60, "\nNÍVEL 2 — SQLAlchemy Core\n", "=" * 60, sep="")

metadata = MetaData()


funcionarios = Table(
    "funcionarios",
    metadata,
    Column("id", Integer, primary_key=True),
    Column("nome", String, nullable=False),
    Column("cargo", String, nullable=False),
    Column("salario", Float, nullable=False),
)

projetos = Table(
    "projetos",
    metadata,
    Column("id", Integer, primary_key=True),
    Column("nome", String(100), nullable=False),
    Column("orcamento", Float),
    Column("status", String(30)),
)
metadata.create_all(engine)


lista_de_dicts = [
    {"nome": "Portal do Colaborador", "orcamento": 85000.0, "status": "Em andamento"},
    {"nome": "Migração para Nuvem", "orcamento": 240000.0, "status": "Planejado"},
    {"nome": "Dashboard de RH", "orcamento": 40000.0, "status": "Concluído"},
]
with engine.begin() as conn:
    conn.execute(insert(projetos), lista_de_dicts)

print("Projetos cadastrados:")
print(pd.read_sql_query(select(projetos), engine).to_string(index=False), "\n")


reajuste = (
    update(funcionarios)
    .where(funcionarios.c.cargo == "Desenvolvedor Júnior")
    .values(salario=func.round(funcionarios.c.salario * 1.10, 2))
)
with engine.begin() as conn:
    resultado = conn.execute(reajuste)
    print(f"Reajuste aplicado a {resultado.rowcount} funcionário(s).\n")


media_salarial = func.avg(funcionarios.c.salario).label("media_salarial")
relatorio = (
    select(
        funcionarios.c.cargo,
        func.count().label("qtd_funcionarios"),
        media_salarial,
    )
    .group_by(funcionarios.c.cargo)
    .order_by(media_salarial.desc())
)
df_relatorio = pd.read_sql_query(relatorio, engine)
df_relatorio["media_salarial"] = df_relatorio["media_salarial"].round(2)
print("Relatório salarial por cargo:")
print(df_relatorio.to_string(index=False), "\n")


print("=" * 60, "\nNÍVEL 3 — ORM\n", "=" * 60, sep="")

Base = declarative_base()



class Departamento(Base):
    __tablename__ = "departamentos"

    id = mapped_column(Integer, primary_key=True)
    nome = mapped_column(String(80), nullable=False, unique=True)

    funcionarios = relationship(
        "FuncionarioORM",
        back_populates="departamento",
        cascade="all, delete-orphan",
    )

    def __repr__(self):
        return f"Departamento(id={self.id}, nome={self.nome!r})"


class FuncionarioORM(Base):
    __tablename__ = "funcionarios_orm"

    id = mapped_column(Integer, primary_key=True)
    nome = mapped_column(String(100), nullable=False)
    cargo = mapped_column(String(80), nullable=False)
    salario = mapped_column(Float, nullable=False)
    departamento_id = mapped_column(ForeignKey("departamentos.id"), nullable=False)

    departamento = relationship("Departamento", back_populates="funcionarios")

    def __repr__(self):
        return f"FuncionarioORM(id={self.id}, nome={self.nome!r}, cargo={self.cargo!r})"


Base.metadata.create_all(engine)

SessaoLocal = sessionmaker(bind=engine)
sessao = SessaoLocal()

try:
    ti = Departamento(nome="TI")
    ti.funcionarios.append(FuncionarioORM(nome="Carla Mendes", cargo="Desenvolvedor Pleno", salario=7500.0))
    ti.funcionarios.append(FuncionarioORM(nome="Ana Souza", cargo="Desenvolvedor Júnior", salario=4620.0))
    ti.funcionarios.append(FuncionarioORM(nome="Fábio Nunes", cargo="Gerente de TI", salario=12000.0))

    rh = Departamento(nome="Recursos Humanos")
    rh.funcionarios.append(FuncionarioORM(nome="Helena Costa", cargo="Analista de RH", salario=5400.0))

    
    sessao.add(ti)
    sessao.add(rh)
    sessao.commit()

    
    consulta = (
        select(FuncionarioORM)
        .join(FuncionarioORM.departamento)
        .where(Departamento.nome == "TI")
        .order_by(FuncionarioORM.nome)
    )
    funcionarios_ti = sessao.execute(consulta).scalars().all()

    print("Funcionários do departamento de TI:")
    for f in funcionarios_ti:
        
        print(f"  {f.nome:<15} {f.cargo:<22} R$ {f.salario:>9,.2f}  ({f.departamento.nome})")

    
    print(f"\n{ti.nome} tem {len(ti.funcionarios)} funcionário(s).")
finally:
    sessao.close()  
