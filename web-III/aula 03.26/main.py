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
x1=Label(i,text='Teste1',bg="orange",font="Arial 12 bold")
x2=Label(i,text='Teste1',bg="red",font="Arial 12 bold")
x3=Label(i,text='Teste1',bg="purple",font="Arial 12 bold")
x1.grid(row=0,column=0)
x2.grid(row=0,column=1)
x3.grid(row=0,column=2)
i.mainloop()