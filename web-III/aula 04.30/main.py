from mysql import connector
import mysql

conexao = mysql.connector.connect(host='LocalHost', user='root', password='<PASSWORD>')
cursor = conexao.cursor()


