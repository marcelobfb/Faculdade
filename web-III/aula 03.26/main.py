from tkinter import*
from PIL import Image, ImageTk
i=Tk()
'''
i.title('Primeira janera')
# abrir fullscreen:
i.state('zoomed')

# abrir em baixo:
# i.state("iconic")

# i.maxsize(900,500)
# i.minsize(300,150)

i['bg']='black'

image_path = r'C:/Users/aluno.unilasalle.ACAD/Documents/GitHub/Faculdade/web-III/aula 03.26/github.ico'  
image = Image.open(image_path)
i.iconphoto(True, ImageTk.PhotoImage(image))

e=Entry(i)
e.pack()

btn=Button(i,text="Clique aqui",font="Arial 12 bold").pack()

def botao_clicado():
    label.config(text="Você clicou no botão")

btn1=Button(i,
            text="Clique aqui",
            font="Arial 12 bold",
            fg='white',
            bg='#4CAF50',
            relief='raised',
            bd=5,
            padx=20,
            pady=10,
            activebackground='#45A049',
            activeforeground='yellow',
            command=botao_clicado)
btn1.pack(pady=20)

label = Label(i, bg='black', fg='white', font="Arial 12 bold")
label.pack()'''

# sistema grid(linha e coluna)
'''x1=Label(i,text='Teste1',bg="orange",font="Arial 12 bold")
x2=Label(i,text='Teste1',bg="red",font="Arial 12 bold")
x3=Label(i,text='Teste1',bg="purple",font="Arial 12 bold")
x1.grid(row=0,column=0,padx=10)
x2.grid(row=0,column=1,padx=10)
x3.grid(row=0,column=2,padx=10)'''

'''label_nome=Label(i,text='Nome: ', font='Arial 10 bold')
label_nome.grid(row=0,column=0,padx=10,pady=10)

Entry_nome=Entry(i)
Entry_nome.grid(row=0,column=1,padx=10,pady=10)

label_idade=Label(i,text='Idade: ', font='Arial 10 bold')
label_idade.grid(row=1,column=0,padx=10,pady=10)

Entry_idade=Entry(i)
Entry_idade.grid(row=1,column=1,padx=10,pady=10)

def informacoes():
    nome=Entry_nome.get()
    idade=Entry_idade.get()
    r_label.config(text=f'Nome: {nome}\nIdade: {idade}')


btn2=Button(i,
            text="Cadastrar",command=informacoes)
btn2.grid(row=2,column=0,padx=10,pady=20,columnspan=2)

r_label = Label(i, fg='black', font="Arial 12")
r_label.grid(row=3,column=0,padx=10,pady=10,columnspan=2)'''

# Checkbutton() - selecao multipla

t=Label(i,text='Qual o seu esporte: ')
t.grid(row=0,column=0,padx=10,pady=10)
a1=Checkbutton(i,text='Futebol')
a2=Checkbutton(i,text='Volei')
a3=Checkbutton(i,text='Basquete')
a4=Checkbutton(i,text='Surf')
t.place(x=10,y=10)
a1.place(x=10,y=40)
a2.place(x=10,y=80)
a3.place(x=10,y=120)
a4.place(x=10,y=160)
i.mainloop()

