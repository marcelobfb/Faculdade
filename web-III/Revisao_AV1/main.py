from tkinter import*
# 1. Escreva uma função verificar_numero que recebe um número inserido pelo
# usuário como parâmetro e imprime em uma caixa de mensagem do Tkinter
# se o número é positivo ou negativo.

# def verificar_numero():
#     n=int(e.get())

#     if n>0:
#         resultado="O número é positivo"
#     elif n<0:
#         resultado="O número é negativo"
#     else:
#         resultado="O número é 0"
#     resp_label.config(text=resultado)

# tk=Tk()
# tk.geometry('300x300')

# e=Entry(tk)
# e.pack()

# btn=Button(tk,text="Clique aqui",font="Arial 12 bold",command=verificar_numero).pack()

# resp_label=Label(tk)
# resp_label.pack()

# tk.mainloop()


# 2. Criar uma interface Tkinter que permita ao usuário inserir uma lista ordenada
# de números e um limite desejado. Em seguida, ao pressionar um botão, a
# função verificará se há algum elemento na lista maior que o limite desejado e
# retornará o índice do primeiro elemento que atenda a essa condição, ou
# retornará -1 se nenhum elemento for maior que o limite desejado.

# def verificar_indice():
#     entrada_lista = input1.get()
#     limite = float(input2.get())  
#     lista = [float(x) for x in entrada_lista.split(',')] 

#     if lista != sorted(lista):  
#         resultado_label.config(text="Erro")  
#         return

#     for i, num in enumerate(lista):
#         if num > limite:
#             resultado_label.config(text=f"Índice do primeiro número maior que o limite: {i}") 
#             return

#     resultado_label.config(text="Nenhum número maior que o limite encontrado.")
    
# tk=Tk()
# tk.geometry("500x300")

# Label(tk,text="Digite uma lista (ordenada, separada com (,)",font="Arial 12 bold").pack()

# input1=Entry(tk)
# input1.pack()

# Label(tk,text="Digite o limite:",font="Arial 12 bold").pack()

# input2=Entry(tk)
# input2.pack()

# btn=Button(tk,text="Clique aqui",font="Arial 12 bold",command=verificar_indice).pack()

# resultado_label = Label(tk, text="", font="Arial 12 bold")
# resultado_label.pack(pady=10)

# tk.mainloop()

# 3. Criar uma interface Tkinter que permita ao usuário inserir um ano e, ao
# pressionar um botão, a função verificará se o ano é bissexto ou não. Em
# seguida, exibirá uma mensagem indicando o resultado.

# def verificar_ano():
#     ano=int(num.get())
#     if ano%4==0 and ano%100!=0 or ano%400==0:
#         resultado="Ano bissexto"
#     else:
#         resultado="Não é ano bissexto"
#     resp_label.config(text=resultado)

# tk=Tk()
# tk.geometry("500x300")
# num=Entry(tk)
# num.pack()

# btn=Button(tk,text="Clique aqui",font="Arial 12 bold",command=verificar_ano).pack()

# resp_label=Label(tk)
# resp_label.pack()

# tk.mainloop()

# 4. Criar uma calculadora básica em Tkinter que permita ao usuário inserir dois
# números e, ao pressionar um botão, exibirá o resultado da
# adição,subtração,multiplicação e divisão desses dois números.

# def calculadora():
#     numero1=int(num1.get())
#     numero2=int(num2.get())
#     soma=numero1+numero2
#     subtracao=numero1-numero2
#     multiplicacao=numero1*numero2
#     divisao=numero1/numero2
#     resp_label.config(text=f"{numero1}+{numero2}={soma}\n{numero1}-{numero2}={subtracao}\n{numero1}*{numero2}={multiplicacao}\n{numero1}/{numero2}={divisao}\n")

# tk=Tk()
# tk.geometry("500x300")
# num1=Entry(tk)
# num1.pack()
# num2=Entry(tk)
# num2.pack()
# btn=Button(tk,text="Clique aqui",font="Arial 12 bold",command=calculadora).pack()

# resp_label=Label(tk)
# resp_label.pack()


# tk.mainloop()

# 5)Criar uma interface Tkinter que permita ler quatro valores pelo teclado e
# guarde-os em uma lista.
# No final mostre:
# a)Quantas vezes apareceu o valor 9.
# b)Em que posição foi digitado o primeiro valor 3.
# c)Quais foram os números pares. enunciado para tkinter

def infoLista():
    n1=int(num1.get())
    n2=int(num2.get())
    n3=int(num3.get())
    n4=int(num4.get())
    lista=[n1,n2,n3,n4]
    nove=lista.count(9)
    resp_label1.config(text=f"o 9 apareceu {nove} vezes")
    tres=lista.index(3)
    resp_label2.config(text=f"o 3 apareceu pela primeira vez na posição {tres}")
    pares = [str(lista[i]) for i in range(4) if lista[i] % 2 == 0]
    if pares:
        resp_label3.config(text=f"Números pares: {', '.join(pares)}")
    else:
        resp_label3.config(text="Não há números pares na lista.")
tk=Tk()
tk.geometry("500x300")
num1=Entry(tk)
num1.pack()

num2=Entry(tk)
num2.pack()

num3=Entry(tk)
num3.pack()

num4=Entry(tk)
num4.pack()
btn=Button(tk,text="Clique aqui",font="Arial 12 bold",command=infoLista).pack()

resp_label1=Label(tk)
resp_label1.pack()
resp_label2=Label(tk)
resp_label2.pack()
resp_label3=Label(tk)
resp_label3.pack()


tk.mainloop()