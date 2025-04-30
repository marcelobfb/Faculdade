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

# mostrar todas as tabelas
cursor.execute('show tables')
for i in cursor:
    print(i)