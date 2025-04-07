from tkinter import*
# def mudar_texto():
#     resp_label.config(text="Teste Alterado")

# tk=Tk()
# tk.geometry("400x300")

# resp_label=Label(tk,text="Teste")
# resp_label.pack()

# input1=Entry(tk)
# input1.pack()

# btn=Button(tk,text="Click Aqui",command=mudar_texto)
# btn.pack()

# tk.mainloop()

#! 1
def analisar_numero():
    numero=int(input1.get())
    if numero%2==0 and numero!=0:
        resultado="O número é par"
    elif numero == 0:
        resultado="O número é 0"
    else:
        resultado="O número é ímpar"
    resp_label.config(text=resultado)
    
tk=Tk()
tk.geometry("400x300")
input1=Entry(tk)
input1.pack()
btn=Button(text="Clique aqui",command=analisar_numero)
btn.pack()
resp_label=Label(tk,text="Aperto o botão para saber se é negativo ou positivo")
resp_label.pack()



tk.mainloop()