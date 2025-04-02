from tkinter import*

tk=Tk()
tk.geometry("500x300")

visor=Entry(tk)
visor.pack(padx=20,pady=10,fill="both",expand=2)
btn=Button(tk,text="Clique aqui",font="Arial 12 bold").pack()

tk.mainloop()