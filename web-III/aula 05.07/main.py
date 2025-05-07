from mysql import connector
import mysql
from tkinter import*

conexao = mysql.connector.connect(host='LocalHost', user='root', password='', database='loja')
cursor = conexao.cursor()
cursor.execute('create database if not exists loja')
cursor.execute('use loja')

# cursor.execute('''create table produto(
#     cod int primary key,
#     nome varchar(30) not null,
#     preco decimal(10,2) not null,
#     qtd int not null)''')

root=Tk()
root.geometry('500x300')
root.title('Loja')
Label(root,text='Código:').grid(row=0,column=0,padx=5,pady=5)
e_codigo=Entry(root)
e_codigo.grid(row=0,column=1,padx=5,pady=5)
Label(root,text='Nome:').grid(row=1,column=0,padx=5,pady=5)
e_nome=Entry(root)
e_nome.grid(row=1,column=1,padx=5,pady=5)
Label(root,text='Preço:').grid(row=2,column=0,padx=5,pady=5)
e_preco=Entry(root)
e_preco.grid(row=2,column=1,padx=5,pady=5)
Label(root,text='Quantidade:').grid(row=3,column=0,padx=5,pady=5)
e_qtd=Entry(root)
e_qtd.grid(row=3,column=1,padx=5,pady=5)

Button(root,text='Inserir').grid(row=4,column=0,padx=5,pady=5)
Button(root,text='Excluir').grid(row=4,column=1,padx=5,pady=5)
Button(root,text='Alterar').grid(row=4,column=2,padx=5,pady=5)
Button(root,text='Consultar').grid(row=4,column=3,padx=5,pady=5)

root.mainloop()