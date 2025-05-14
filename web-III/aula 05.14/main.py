from tkinter import *

def abrir_janela():
    nova_janela=Toplevel(root)
    nova_janela.geometry('500x500')
    nova_janela.title('Janela Secundaria')
    l=Label(nova_janela, text='Nova janela')
    l.grid(column=1,row=1)


# root=Tk()
# root.geometry('500x500')
# root.title('Aula 10')

# menu_bar=Menu(root)

# arquivo_menu=Menu(menu_bar, tearoff=False)
# arquivo_menu.add_command(label='Novo')
# arquivo_menu.add_command(label='Salvar')
# arquivo_menu.add_command(label='Salvar Como')
# arquivo_menu.add_command(label='Imprimir')
# arquivo_menu.add_command(label='Sair')
# menu_bar.add_cascade(label='Arquivo', menu=arquivo_menu)
# root.config(menu=menu_bar)

# editar_menu=Menu(menu_bar,tearoff=False)
# editar_menu.add_command(label='Copiar')
# editar_menu.add_command(label='Colar')
# editar_menu.add_command(label='Voltar')
# editar_menu.add_command(label='Sair')
# menu_bar.add_cascade(label='Editar',menu=editar_menu)
# root.config(menu=menu_bar)


# root.mainloop()
# --------------------------------------------------------------------------------

root=Tk()
root.geometry('500x500')
root.title('Janela Principal')

menu_bar=Menu(root)
btn=Button(root,text='Nova Janela',command=abrir_janela)
btn.pack()

# abre a janela sem clicar em nd:
# nova_janela=Toplevel(root) 


arquivo_menu=Menu(menu_bar, tearoff=False)
arquivo_menu.add_command(label='Novo')
arquivo_menu.add_command(label='Salvar')
arquivo_menu.add_command(label='Salvar Como')
arquivo_menu.add_command(label='Imprimir')
arquivo_menu.add_command(label='Sair')
menu_bar.add_cascade(label='Arquivo', menu=arquivo_menu)
root.config(menu=menu_bar)

editar_menu=Menu(menu_bar,tearoff=False)
editar_menu.add_command(label='Copiar')
editar_menu.add_command(label='Colar')
editar_menu.add_command(label='Voltar')
editar_menu.add_command(label='Sair')
menu_bar.add_cascade(label='Editar',menu=editar_menu)
root.config(menu=menu_bar)


frame=Frame(root)
frame.pack()
s=IntVar()

r1=Radiobutton(frame,text='Abri janela',variable=s,value=1,command=abrir_janela).pack()
r2=Radiobutton(frame,text='Fechar janela',variable=s,value=2).pack()
r3=Radiobutton(frame,text='Aumentar janela',variable=s,value=3).pack()

div_header=Frame(root,bg='red',width=800,height=50).pack()
div_conteudo=Frame(root,bg='blue',width=800,height=50).pack()
div_rodape=Frame(root,bg='yellow',width=800,height=50).pack()


root.mainloop()

