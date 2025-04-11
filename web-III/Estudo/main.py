from tkinter import*

def binarioConv():
    inteiro=int(input1.get())
    binario=bin(inteiro)[2:]
    resp_label.config(text=f"O número transformado em binario é {binario}")
def hexadecimalConv():
    inteiro=int(input1.get())
    hexadecimal=hex(inteiro)[2:]
    resp_label.config(text=f"O número transformado em hexadecimal é {hexadecimal}")
def binarioInv():
    binario=bin(input1.get())
    inteiro = int(binario, 2)
    resp_label.config(text=f"O número transformado em hexadecimal é {binarioInv}")
    
tk=Tk()
header=Label(tk,text="Digite um numero para virar binario: ",padx=10,pady=10).pack()

input1=Entry(tk)
input1.pack(padx=10,pady=10)

btn=Button(tk,text="Binario",command=binarioConv)
btn.pack(padx=10,pady=10)

btn1=Button(tk,text="Hexadecimal",command=hexadecimalConv)
btn1.pack(padx=10,pady=10)

btn2=Button(tk,text="Binario-->Inteiro",command=binarioInv)
btn2.pack(padx=10,pady=10)

resp_label=Label(tk,text=" ",padx=10,pady=10)
resp_label.pack()

tk.mainloop()

