from mysql import connector
import mysql
from tkinter import*
import tkinter.messagebox as MessageBox

def inserir_turmas():
    id=e_id.get()
    codigo=e_codigo.get()
    professor=e_professor.get()
    ano=e_ano.get()
    
    if(id=='' or codigo== '' or professor=='' or ano==''):
        MessageBox.showerror('Inserir','Todos os campos são obrigatórios.')
    else:
        cursor.execute('INSERT INTO turmas(id, codigo, professor, ano_letivo) VALUES (%s, %s, %s, %s)',
                    (id, codigo, professor, ano))
        conexao.commit()
        MessageBox.showinfo('Inserir', 'Turma inserida com sucesso!')
        
        e_id.delete(0,END)
        e_codigo.delete(0,END)
        e_professor.delete(0,END)
        e_ano.delete(0,END)

def inserir_alunos():
    id=e_id_aluno.get()
    nome=e_nome.get()
    idade=e_idade.get()
    email=e_email.get()
    turma_id=e_turma_id.get()
    
    if(id=='' or nome== '' or idade=='' or email=='' or turma_id==''):
        MessageBox.showerror('Inserir','Todos os campos são obrigatórios.')
    else:
        cursor.execute('INSERT INTO alunos(id, nome, idade, email, turma_id) VALUES (%s, %s, %s, %s, %s)',
                    (id, nome, idade, email, turma_id))
        conexao.commit()
        MessageBox.showinfo('Inserir', 'Aluno inserida com sucesso!')
        
        e_id_aluno.delete(0,END)
        e_nome.delete(0,END)
        e_idade.delete(0,END)
        e_email.delete(0,END)
        e_turma_id.delete(0,END)

def excluir_turmas():
    id=e_id.get()
    
    if(id==''):
        MessageBox.showerror('Excluir','Informe o id da turma.')
    else:
        cursor.execute('delete from turmas where id = %s',(id,))
        conexao.commit()
        MessageBox.showinfo('Excluir', 'Turma excluida com sucesso!')
        
        e_id.delete(0,END)

def excluir_alunos():
    id=e_id_aluno.get()
    
    if(id==''):
        MessageBox.showerror('Excluir','Informe o id do aluno.')
    else:
        cursor.execute('delete from alunos where id = %s',(id,))
        conexao.commit()
        MessageBox.showinfo('Excluir', 'Aluno excluido com sucesso!')

        e_id_aluno.delete(0,END)

def alterar_turmas():
    id=e_id.get()
    codigo=e_codigo.get()
    professor=e_professor.get()
    ano=e_ano.get()
    
    if(id=='' or codigo== '' or professor=='' or ano==''):
        MessageBox.showerror('Alterar','Todos os campos são obrigatórios.')
    else:
        cursor.execute('update turmas set codigo=%s,professor=%s,ano_letivo=%s where id=%s',(codigo,professor,ano,id))
        conexao.commit()
        MessageBox.showinfo('Alterar', 'Turma atualizar com sucesso!')
        e_id.delete(0,END)
        e_codigo.delete(0,END)
        e_professor.delete(0,END)
        e_ano.delete(0,END)

def alterar_alunos():
    id=e_id_aluno.get()
    nome=e_nome.get()
    idade=e_idade.get()
    email=e_email.get()
    turma_id=e_turma_id.get()

    if(id=='' or nome== '' or idade=='' or email=='' or turma_id==''):
        MessageBox.showerror('Alterar','Todos os campos são obrigatórios.')
    else:
        cursor.execute('UPDATE alunos SET nome=%s, idade=%s, email=%s, turma_id=%s WHERE id=%s', (nome, idade, email, turma_id, id))
        conexao.commit()
        MessageBox.showinfo('Alterar', 'Aluno atualizar com sucesso!')
        
        e_id_aluno.delete(0,END)
        e_nome.delete(0,END)
        e_idade.delete(0,END)
        e_email.delete(0,END)
        e_turma_id.delete(0,END)

def selecionar_turmas():
    id=e_id.get()
    if id=="":
        MessageBox.showerror('Selecionar','Todos os campos são obrigatórios.')
    else:
        cursor.execute('select * from turmas where id=%s',(id,))
        r=cursor.fetchall()
        if r:
            for r1 in r:
                            e_codigo.delete(0, END)
                            e_professor.delete(0, END)
                            e_ano.delete(0, END)
                            
                            e_codigo.insert(0, r1[1])
                            e_professor.insert(0, r1[2])
                            e_ano.insert(0, r1[3])
                            
                            MessageBox.showinfo('Selecionar', f'Selecionado com sucesso!\n\nID: {r1[0]}\nCodigo: {r1[1]}\nProfessor: {r1[2]}\nAno Letivo: {r1[3]}')
        else:
            MessageBox.showerror('Selecionar', 'Turma nao encontrado!')

def selecionar_aluno():
    id=e_id_aluno.get()
    if id=="":
        MessageBox.showerror('Selecionar','Todos os campos são obrigatórios.')
    else:
        cursor.execute('select * from alunos where id=%s',(id,))
        r=cursor.fetchall()
        if r:
            for r1 in r:
                            e_nome.delete(0, END)
                            e_idade.delete(0, END)
                            e_email.delete(0, END)
                            e_turma_id.delete(0,END)
                            
                            e_nome.insert(0, r1[1])
                            e_idade.insert(0, r1[2])
                            e_email.insert(0, r1[3])
                            e_turma_id.insert(0, r1[4])

                            
                            MessageBox.showinfo('Selecionar', f'Selecionado com sucesso!\n\nID: {r1[0]}\nNome: {r1[1]}\nIdade: {r1[2]}\nEmail: {r1[3]}\nTurma ID:{r1[4]}')
        else:
            MessageBox.showerror('Selecionar', 'Aluno nao encontrado!')

conexao = mysql.connector.connect(host='LocalHost', user='root', password='',database='sistema_escolar')
cursor = conexao.cursor()
cursor.execute('create database if not exists sistema_escolar')
cursor.execute('use sistema_escolar')

cursor.execute('''CREATE TABLE IF NOT EXISTS turmas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10) NOT NULL,
    professor VARCHAR(100) NOT NULL,
    ano_letivo INT NOT NULL
)''')

cursor.execute('''CREATE TABLE IF NOT EXISTS alunos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    turma_id INT,
    FOREIGN KEY (turma_id) REFERENCES turmas(id)
)''')


root=Tk()
root.geometry('550x300')
root.title('Sistema Escola')
Label(root, text='Turmas').grid(row=0,column=0,padx=5,pady=5)
Label(root,text='ID:').grid(row=1,column=0,padx=5,pady=5)
e_id=Entry(root)
e_id.grid(row=1,column=1,padx=5,pady=5)
Label(root,text='Código:').grid(row=2,column=0,padx=5,pady=5)
e_codigo=Entry(root)
e_codigo.grid(row=2,column=1,padx=5,pady=5)
Label(root,text='Professor:').grid(row=3,column=0,padx=5,pady=5)
e_professor=Entry(root)
e_professor.grid(row=3,column=1,padx=5,pady=5)
Label(root,text='Ano letivo:').grid(row=4,column=0,padx=5,pady=5)
e_ano=Entry(root)
e_ano.grid(row=4,column=1,padx=5,pady=5)

Label(root, text='Alunos').grid(row=0,column=4,padx=5,pady=5)
Label(root,text='ID:').grid(row=1,column=4,padx=5,pady=5)
e_id_aluno=Entry(root)
e_id_aluno.grid(row=1,column=5,padx=5,pady=5)
Label(root,text='Nome:').grid(row=2,column=4,padx=5,pady=5)
e_nome=Entry(root)
e_nome.grid(row=2,column=5,padx=5,pady=5)
Label(root,text='Idade:').grid(row=3,column=4,padx=5,pady=5)
e_idade=Entry(root)
e_idade.grid(row=3,column=5,padx=5,pady=5)
Label(root,text='E-mail:').grid(row=4,column=4,padx=5,pady=5)
e_email=Entry(root)
e_email.grid(row=4,column=5,padx=5,pady=5)
Label(root,text='Turma ID: ').grid(row=5,column=4,padx=5,pady=5)
e_turma_id=Entry(root)
e_turma_id.grid(row=5,column=5,padx=5,pady=5)


frame_botoes = Frame(root)
frame_botoes.grid(row=6, column=0, columnspan=2, pady=10)

Button(frame_botoes, text='Consultar',command=selecionar_turmas).pack(side=LEFT, padx=5)
Button(frame_botoes, text='Inserir',command=inserir_turmas).pack(side=LEFT, padx=5)
Button(frame_botoes, text='Alterar',command=alterar_turmas).pack(side=LEFT, padx=5)
Button(frame_botoes, text='Excluir',command=excluir_turmas).pack(side=LEFT, padx=5)

frame_botoes_direita = Frame(root)
frame_botoes_direita.grid(row=6, column=5, columnspan=2, pady=10)

Button(frame_botoes_direita, text='Consultar',command=selecionar_aluno).pack(side=LEFT, padx=5)
Button(frame_botoes_direita, text='Inserir',command=inserir_alunos).pack(side=LEFT, padx=5)
Button(frame_botoes_direita, text='Alterar',command=alterar_alunos).pack(side=LEFT, padx=5)
Button(frame_botoes_direita, text='Excluir',command=excluir_alunos).pack(side=LEFT, padx=5)

root.mainloop()