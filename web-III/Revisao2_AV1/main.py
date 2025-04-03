from tkinter import*

# Questão 1 (0,5 ponto): Qual comando é usado para iniciar a interface gráfica de um aplicativo Tkinter?
# a) tkinter.show()
# b) tkinter.mainloop()
# c) tkinter.run()
# d) tkinter.start()
# Resposta:b
 
# Questão 2 (1,0 ponto): O que acontece quando ocorre uma exceção em Python, mas não é capturada por
# um bloco try-except?
# a) O programa continua normalmente
# b) O programa entra em um loop infinito
# c) O programa exibe um erro e para a execução
# d) O programa corrige o erro automaticamente
# Resposta:c

# Questão 3 (1,0 ponto): Considere o código abaixo:
# count = 0
# while count < 5:
# count += 1
# if count == 3:
# continue
# print(count)
# else:
# print("Laço concluído.")
# Qual será a saída desse programa?
# a) 1 2 4 5 Laço concluído.
# b) 1 2 3 4 5 Laço concluído.
# c) 1 2 4 5
# d) 1 2 3 4 5
# Resposta: a

# Questão 4 (0,5 ponto): Qual será a saída do seguinte código?
# numeros = [1, 2, 3, 4, 5]
# resultado = [x**2 for x in numeros if x % 2 == 0]
# print(resultado)
# a) [4, 16]
# b) [1, 9, 25]
# c) [4, 9, 16]
# d) [4, 8]
# Resposta: a

# Questão 5 (1,0 ponto): Analise o script Python exibido a seguir.
# x = 1
# y = 1
# while x < 100:
# x, y = y, x + y
# if x % 3 == 0:
# print(x)

# O código acima utiliza um loop while para calcular e imprimir os primeiros números
# da sequência de Fibonacci que são múltiplos de 3. Qual é a sequência correta de
# valores impressos pelo código?
# a)
# 3
# 21
# 144

# b)
# 3
# 5
# 21
# 55

# c)
# 3
# 8
# 21
# 55.
# d)
# 3
# 13
# 55
# 233

# e)Nenhuma das alternativas
# Resposta: a

# Questão 6 (1,0 ponto): O que o método pack() faz em Tkinter?
# a) Adiciona um widget ao layout da janela, organizando-o automaticamente.
# b) Cria um botão.
# c) Define a cor de fundo de um widget.
# d) Exibe uma caixa de diálogo de erro.
# Resposta:a

# Questão 7 (1,0 ponto): Em Tkinter, qual o efeito de usar o método grid() ao invés de pack() para organizar
# widgets?
# a) grid() organiza widgets em colunas e linhas, enquanto pack() organiza em relação aos lados da janela.
# b) grid() sobrepõe widgets, enquanto pack() os empilha verticalmente.
# c) grid() organiza widgets em uma grade fixa, enquanto pack() usa tamanhos dinâmicos.
# d) grid() só pode ser usado com o widget Frame, enquanto pack() pode ser usado com qualquer widget.
# Resposta: a

# Questão 8 (1,0 ponto): Considere o seguinte código:
# import tkinter as tk
# def verificar():
#     if var.get() == 1:
#         print("Selecionado")
#     else:
#         print("Desmarcado")
# janela = Tk()
# var = IntVar()
# checkbox = Checkbutton(janela, text="Aceito", variable=var, command=verificar)
# checkbox.pack()
# janela.mainloop()
# O que será impresso ao clicar repetidamente na caixa de seleção?
# a) "Selecionado" será impresso sempre que o botão for clicado.
# b) "Desmarcado" será impresso sempre que o botão for clicado.
# c) Alternará entre "Selecionado" e "Desmarcado".
# d) Nada será impresso.
# Resposta: c

# Questão 9 (1,0 ponto): Como você adiciona um elemento à lista minha_lista?
# a) minha_lista.add("novo_elemento")
# b) minha_lista.append("novo_elemento")
# c) minha_lista.insert("novo_elemento")
# d) minha_lista.update("novo_elemento")
# Resposta: b

# Questão 10 (2,0 pontos): Desenvolver uma aplicação em Python utilizando Tkinter para criar uma interface
# gráfica que receba um dicionário, onde as chaves são nomes de produtos e os valores são os preços
# correspondentes. A função deve:
# ● Solicitar que o usuário insira o nome de um produto.
# ● Se o produto estiver no dicionário, exibir o preço.
# ● Se não estiver, permitir que o usuário insira o preço e adicionar o novo produto ao dicionário.
# ● O programa deve continuar até que o usuário digite "sair".


def buscarOuAdicionarProduto():
    produto = entry_produto.get()
    if produto == "sair":
        tk.quit()
    elif produto in precos:
        label_resultado.config(text=f"O preço de {produto} é R${precos[produto]:.2f}")
    else:
        entry_produto.delete(0, tk.END)
        label_resultado.config(text=f"Produto '{produto}' não encontrado. Insira o preço:")

def adicionarPreco():
    produto = entry_produto.get()
    try:
        preco = float(entry_preco.get())
        precos[produto] = preco
        label_resultado.config(text=f"Produto '{produto}' adicionado com preço R${preco:.2f}")
        entry_produto.delete(0, END)
        entry_preco.delete(0, END)
    except ValueError:
        label_resultado.config(text="Por favor, insira um preço válido.")

tk = Tk()
tk.title("Catálogo de Produtos")

precos = {
    "Tomate": 10.0,
    "Ovo": 20.0,
    "Tesoura": 30.0
}

label_instrucoes = Label(tk, text="Digite o nome do produto:")
label_instrucoes.pack(pady=5)

entry_produto = Entry(tk)
entry_produto.pack(pady=5)

button_buscar = Button(tk, text="Buscar", command=buscarOuAdicionarProduto)
button_buscar.pack(pady=5)

label_preco = Label(tk, text="Insira o preço do produto:")
label_preco.pack(pady=5)

entry_preco = Entry(tk)
entry_preco.pack(pady=5)

button_adicionar = Button(tk, text="Adicionar Preço", command=adicionarPreco)
button_adicionar.pack(pady=5)

label_resultado = Label(tk, text="")
label_resultado.pack(pady=10)

tk.mainloop()
