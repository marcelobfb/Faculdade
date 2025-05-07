from mysql import connector
import mysql
from tkinter import*
import tkinter.messagebox as MessageBox

def inserir():
    codigo=e_codigo.get()
    nome=e_nome.get()
    preco=e_preco.get()
    quantidade=e_qtd.get()
    
    if(codigo=='' or nome== '' or preco=='' or quantidade==''):
        MessageBox.showerror('Inserir','Todos os campos são obrigatórios.')
    else:
        cursor.execute('INSERT INTO produto(codigo, nome, preco, quantidade) VALUES (%s, %s, %s, %s)',
                    (codigo, nome, preco, quantidade))
        conexao.commit()
        MessageBox.showinfo('Inserir', 'Produto inserido com sucesso!')
    
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
root.geometry('237x170')
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

frame_botoes = Frame(root)
frame_botoes.grid(row=4, column=0, columnspan=2, pady=10)

Button(frame_botoes, text='Consultar').pack(side=LEFT, padx=5)
Button(frame_botoes, text='Inserir',command=inserir).pack(side=LEFT, padx=5)
Button(frame_botoes, text='Alterar').pack(side=LEFT, padx=5)
Button(frame_botoes, text='Excluir').pack(side=LEFT, padx=5)

root.mainloop()