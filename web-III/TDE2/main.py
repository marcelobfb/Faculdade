#!1
# num=int(input("Digite um número: "))
# if num%2==0:
#     print("O número é par")
# else:
#     print("O número é ímpar")
#!2
# n1=float(input("Digite a primeira nota: "))
# n2=float(input("Digite a segunda nota: ")) 
# n3=float(input("Digite a terceira nota: "))
# media=(n1+n2+n3)/3
# if media>=7:
#     print(f"Sua media foi {media:.2f}, Aprovado!")
# elif media<5:
#     print(f"Sua media foi {media:.2f}, Reprovado!")
# else:
#     print(f"Sua media foi {media:.2f}, Recuperação!")
#!3
# n1=int(input("Digite o primeiro numero: "))
# n2=int(input("Digite o segundo numero: "))
# if n1%n2==0:
#     print(f"{n1} é multiplo de {n2}")
# else:
#     print(f"{n1} não é multiplo de {n2}")
#!4
# n1=int(input("Numero 1: "))
# n2=int(input("Numero 2: "))
# n3=int(input("Numero 3: "))
# if n1<n2<n3:
#     print(f"{n1}>{n2}>{n3}")
# else:
#     print("A ordem esta errada, digite ordem crescente.")
#!5
# n1=int(input("Digite Numero inteiro positivo: "))
# n0=0
# impar=0
# while n0!=n1:
#     n0+=1
#     if n0%2!=0:
#         impar+=1
# print(f"Existem {impar} numeros impar do numero 1 ao numero {n1}")
#!6
# n1=int(input("Digite um numero: "))
# x=n1
# fatorial=1
# while n1>1:
#     fatorial*=n1
#     n1-=1
# print(f"O fatorial de {x} é {fatorial}")
# !7
# n1=input("Digite um numero inteiro: ")
# n2=len(n1)
# print(f"{n2}")
# !8
# n1 = int(input("Digite um número: "))
# soma_divisores = 0
# for i in range(1, n1):
#     if n1 % i == 0:
#         soma_divisores += i
# if soma_divisores == n1:
#     print(f"{n1} é um número perfeito!")
# else:
#     print(f"{n1} não é um número perfeito.")
# !9
# n1 = int(input("Digite a quantidade de termos da sequência de Fibonacci: "))
# fibonacci = [0, 1]
# for i in range(2, n1):
#     fibonacci.append(fibonacci[-1] + fibonacci[-2])

# print("Sequência de Fibonacci:", fibonacci)
# !10
base = int(input("Digite um número base: "))
limite = int(input("Digite um limite: "))

print(f"Tabuada de {base} até {limite}:")
for i in range(1, limite + 1):
    print(f"{base} x {i} = {base * i}")