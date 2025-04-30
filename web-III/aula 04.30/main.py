from mysql import connector
import mysql

conexao = mysql.connector.connect(host='LocalHost', user='root', password='', database='testemarcelo')
cursor = conexao.cursor()

# criando a base de dados--------------------------------------
# cursor.execute('create database if not exists testemarcelo')


# mostra todos os bancos de dados------------------------------
# cursor.execute('show databases')
# for i in cursor:
#     print(i)

# usando o banco de dados---------------------------------------
# cursor.execute('use testemarcelo')

# criar tabela--------------------------------------
# cursor.execute('''create table aluno(
#     matricula int primary key auto_increment,
#     nome varchar(30) not null,
#     idade int(3),
#     email varchar(50))''')

# mostrar todas as tabelas--------------------------------
# cursor.execute('show tables')
# for i in cursor:
#     print(i)

# mostrar a descrição da tabela-----------------------
# cursor.execute('describe aluno')
# for i in cursor:
#     print(i)

# inserir dados na tabela - insert into nome da tabela (atributos) values (valores) ------------------------------
# y='insert into aluno(nome,idade,email) values("Marcelo",27,"marcelobouchardet@hotmail.com")'
# cursor.execute(y)
# conexao.commit()
# print(cursor.rowcount,'Registro(s) inserido(s)')

# inserir varios dados
# v=[
#     ("Ana Silva", 22, "ana.silva@gmail.com"),
#     ("Carlos Oliveira", 30, "carlos_oliveira@yahoo.com"),
#     ("Juliana Mendes", 25, "juliana.mendes@outlook.com"),
#     ("Felipe Souza", 28, "felipe.souza@live.com"),
#     ("Larissa Costa", 21, "larissa.costa@gmail.com"),
#     ("Roberto Lima", 35, "roberto.lima@uol.com.br"),
#     ("Tatiane Rocha", 26, "tatiane.rocha@protonmail.com")
# ]

# cursor.executemany('insert into aluno(nome,idade,email) values(%s,%s,%s)',v)
# conexao.commit()
# print(cursor.rowcount,'Registro(s) inserido(s)')


# seleção simples ---------------------------------
# cursor.execute('Select * from aluno')
# r=cursor.fetchall()
# print('Dados do aluno: ')
# for i in r:
#     print(i)

# cursor.execute('Select nome, email from aluno')
# r=cursor.fetchone()
# print('Dados do aluno: ')
# for i in r:
#     print(i)

# seleção condição - where -----------------------------
cursor.execute('Select nome from aluno where idade>27')
r=cursor.fetchall()
print('Alunos maiores de 27 anos: ')
for i in r:
    print(i)