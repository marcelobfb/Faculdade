from mysql import connector
import mysql

conexao = mysql.connector.connect(host='LocalHost', user='root', password='', database='livraria')
cursor = conexao.cursor()

cursor.execute('create database if not exists livraria')

cursor.execute('''
CREATE TABLE IF NOT EXISTS Clientes (
    codigo_cliente INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    endereco TEXT,
    telefone TEXT,
    cpf TEXT,
    cnpj TEXT,
    tipo_cliente TEXT CHECK(tipo_cliente IN ('Física', 'Jurídica'))
);
''')

cursor.execute('''
CREATE TABLE IF NOT EXISTS Editoras (
    codigo_editora INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    endereco TEXT,
    telefone TEXT,
    gerente TEXT
);
''')

cursor.execute('''
CREATE TABLE IF NOT EXISTS Livros (
    codigo_livro INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    autor TEXT,
    assunto TEXT,
    codigo_editora INTEGER,
    isbn TEXT,
    quantidade_estoque INTEGER,
    FOREIGN KEY(codigo_editora) REFERENCES Editoras(codigo_editora)
);
''')

cursor.execute('''
CREATE TABLE IF NOT EXISTS Compras (
    codigo_compra INTEGER PRIMARY KEY,
    codigo_cliente INTEGER,
    codigo_livro INTEGER,
    data_compra DATE,
    FOREIGN KEY(codigo_cliente) REFERENCES Clientes(codigo_cliente),
    FOREIGN KEY(codigo_livro) REFERENCES Livros(codigo_livro)
);
''')

