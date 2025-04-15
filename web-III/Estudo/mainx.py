from tkinter import*

def fullscreen():
    fullscreen = tk.attributes("-fullscreen")
    tk.attributes("-fullscreen", not fullscreen)



tk=Tk()

# digite um texto
texto=Label(tk,text="Digite algo:").grid(column=0,row=0,padx=10,pady=10)

# cria um input
inp=Entry(tk)
inp.grid(column=0,row=1,padx=10,pady=10)

# 
btn=Button(tk,text="Fullscreen",command=fullscreen).grid(column=0,row=2,padx=10,pady=10)

tk.mainloop()