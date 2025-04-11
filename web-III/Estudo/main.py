from tkinter import*

def numero():
    inteiro=int(input1.get())
    binario=bin(inteiro)[2:]
    resp_label.config(text=f"O número transformado em binario é {binario}")
    
tk=Tk()
header=Label(tk,text="Digite um numero para virar binario: ",padx=10,pady=10).pack()
input1=Entry(tk)
input1.pack(padx=10,pady=10)
btn=Button(tk,text="Converter",command=numero)
btn.pack(padx=10,pady=10)
resp_label=Label(tk,text=" ",padx=10,pady=10)
resp_label.pack()
tk.mainloop()

