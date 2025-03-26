import random
from collections import Counter
import string

# 1
# tupla = (
#     "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", 
#     "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", 
#     "dezoito", "dezenove", "vinte"
# )
# x=int(input("Digite um número entre 0 a 20: "))
# print(f"{tupla[x]}")

# 2
# lista=[]

# for i in range (10):
#     x=int(input("Digite um valor: "))
#     lista.append(x)
# diferentes=len(set(lista))
# print(f"Existem {diferentes} valores diferentes")
# print(f'{lista}')

# 3
# lista=[]
# contadordenove=0
# listapar=[]
# for i in range(4):
#     x=int(input("Digite um valor: "))
#     lista.append(x)
#     if x==9:
#         contadordenove+=1
#     if x%2==0:
#         listapar.append(x)
# print(f"a) Quantas vezes aparece o valor 9: {contadordenove}")
# print(f"b) Em que posição foi digitado o primeiro valor 3: {lista.index(3)}")
# print(f"c) Quais foram os números pares: {listapar}")

# 4
# lancamentos = [random.randint(1, 6) for _ in range(50)]
# ocorrencias_face_6 = lancamentos.count(6)
# percentual_face_6 = (ocorrencias_face_6 / 50) * 100

# print(f"Percentual de ocorrências da face 6: {percentual_face_6:.2f}%")

# 5
# tradutor = {
#     "casa": "house",
#     "gato": "cat",
#     "cachorro": "dog",
#     "livro": "book",
#     "carro": "car",
#     "arvore": "tree",
#     "agua": "water",
#     "fogo": "fire",
#     "terra": "earth",
#     "sol": "sun"
# }
# palavra = input("Digite uma palavra para traduzir (português para inglês): ").strip().lower()
# if palavra in tradutor:
#     print(f"A tradução de '{palavra}' é '{tradutor[palavra]}'.")
# else:
#     print(f"Desculpe, a palavra '{palavra}' não está no dicionário.")

# 6
# estoque = {}

# while True:
#     print("\nControle de Estoque")
#     print("1. Adicionar novo produto")
#     print("2. Atualizar quantidade de produto existente")
#     print("3. Exibir estoque")
#     print("4. Sair")
#     opcao = input("Escolha uma opção: ")

#     if opcao == "1":
#         produto = input("Digite o nome do produto: ").strip()
#         if produto in estoque:
#             print("Produto já existe no estoque.")
#         else:
#             quantidade = int(input("Digite a quantidade inicial: "))
#             estoque[produto] = quantidade
#             print(f"Produto '{produto}' adicionado com sucesso.")
#     elif opcao == "2":
#         produto = input("Digite o nome do produto: ").strip()
#         if produto in estoque:
#             quantidade = int(input("Digite a quantidade a ser adicionada: "))
#             estoque[produto] += quantidade
#             print(f"Quantidade do produto '{produto}' atualizada para {estoque[produto]}.")
#         else:
#             print("Produto não encontrado no estoque.")
#     elif opcao == "3":
#         if estoque:
#             print("\nEstoque Atual:")
#             for produto, quantidade in estoque.items():
#                 print(f"{produto}: {quantidade}")
#         else:
#             print("O estoque está vazio.")
#     elif opcao == "4":
#         print("Saindo do programa...")
#         break
#     else:
#         print("Opção inválida. Tente novamente.")

# 7
# idades = []
# alturas = []

# for i in range(5):
#     idade = int(input(f"Digite a idade da pessoa {i + 1}: "))
#     altura = float(input(f"Digite a altura da pessoa {i + 1} (em metros): "))
#     idades.append(idade)
#     alturas.append(altura)
# print("\nIdades e alturas na ordem inversa:")
# for i in range(4, -1, -1):
#     print(f"Pessoa {i + 1}: Idade = {idades[i]}, Altura = {alturas[i]:.2f}m")

# 8
# entrada = input("Digite uma string: ").lower()
# contador = Counter(c for c in entrada if c in string.ascii_lowercase)
# print("Ocorrências de cada letra:")
# print(dict(contador))

# 9
# def calcular_media_notas(alunos_notas):
#     if not alunos_notas:
#         return {"média": 0}
#     media = sum(alunos_notas.values()) / len(alunos_notas)
#     return {"média": media}
# alunos = {"João": 7.5, "Maria": 8.0, "Pedro": 6.5, "Ana": 9.0}
# resultado = calcular_media_notas(alunos)
# print(resultado)

# 10
# entrada = input("Digite uma string: ").lower()
# palavras = entrada.split()
# contador = Counter(palavras)
# print("Ocorrências de cada palavra:")
# print(dict(contador))

# 11
# def verificar_numero(n):
#     if n > 0:
#         print("O número é positivo.")
#     elif n < 0:
#         print("O número é negativo.")
#     else:
#         print("O número é zero.")
# numero = int(input("Digite um número: "))
# verificar_numero(numero)

# 12
# def imprimir_valor_absoluto(numero):
#     print(f"O valor absoluto de {numero} é {abs(numero)}.")
# numero = float(input("Digite um número: "))
# imprimir_valor_absoluto(numero)

# 13
# def soma_maior_que_limite(a, b, limite):
#     return (a + b) > limite
# print(soma_maior_que_limite(5, 10, 12))

# 14
# def somaImposto(taxaImposto, custo):
#     custo_com_imposto = custo + (custo * taxaImposto / 100)
#     return custo_com_imposto

# taxa = float(input("Digite a taxa de imposto (%): "))
# custo_inicial = float(input("Digite o custo do item: "))
# custo_final = somaImposto(taxa, custo_inicial)
# print(f"O custo do item com imposto é: {custo_final:.2f}")

# 15
def contar_digitos(numero):
    return len(str(abs(numero)))

numero = int(input("Digite um número inteiro: "))
quantidade_digitos = contar_digitos(numero)
print(f"O número {numero} possui {quantidade_digitos} dígitos.")