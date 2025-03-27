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

'''def mostrar_selecionados():
    selecionados=[]
    if futebol_var.get():
        selecionados.append("Futebol")
    if volei_var.get():
        selecionados.append("Volei")
    if basquete_var.get():
        selecionados.append("Basquete")
    if surf_var.get():
        selecionados.append("Surf")
    r_label.config(text='Esporte selecionado: '+'♥'.join(selecionados))

futebol_var=IntVar()
volei_var=IntVar()
basquete_var=IntVar()
surf_var=IntVar()

t=Label(i,text='Qual o seu esporte: ')
t.place(x=10,y=0)
a1=Checkbutton(i,text='Futebol',variable=futebol_var)
a2=Checkbutton(i,text='Volei',variable=volei_var)
a3=Checkbutton(i,text='Basquete',variable=basquete_var)
a4=Checkbutton(i,text='Surf',variable=surf_var)

t.place(x=10,y=10)
a1.place(x=10,y=40)
a2.place(x=10,y=80)
a3.place(x=10,y=120)
a4.place(x=10,y=160)

btn = Button(i, text="Clique aq", command=mostrar_selecionados)
btn.place(x=10, y=200)

r_label = Label(i,text='Esportes selecinados:Nenhum')
r_label.place(x=10,y=300)'''


# Radiobutton() - selecao simpels

'''valor=IntVar()
r1=Radiobutton(i,text='opcao 1',variable=valor,value=1)
r2=Radiobutton(i,text='opcao 2',variable=valor,value=2)
r3=Radiobutton(i,text='opcao 3',variable=valor,value=3)
r1.place(x=10,y=10)
r2.place(x=10,y=50)
r3.place(x=10,y=90)'''

# Listbox() - cria uma lista
lista=Listbox(i)
lista.insert(0,'AC')
lista.insert(1,'AM')
lista.insert(2,'RJ')
lista.insert(3,'SP')
lista.insert(4,'MG')
lista.insert(END,'PR')

estado=['a','b','c']
for d in estado:
    lista.insert(END,d)



lista.pack()








i.mainloop()

