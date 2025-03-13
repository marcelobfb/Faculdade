import random
# 1
# dados=(1,0.2,"Marcelo",True)
# print(f'{dados[1]}')
# print(f'{dados[3]}')
# ocorreu um erro, pois tupla nao pode ser modificada

#2
# tupla=(1,1,3,4,5)
# x=int(input("Digite o numero para saber quantas vezes ele repete: "))
# print(f'repete {tupla.count(x)} vezes') 

# 3
# inteiros=[1,2,3,4,5]
# inteiros.append(100)
# inteiros.pop(2)
# inteiros[0]=500
# print(inteiros)

# 4
# notas=[8.7,6.7,5.2,9.8,5.7]
# media=sum(notas)/len(notas)
# print(f"media = {media:.2f}")

# 5
# inteiros=[1,2,5,4,3,11]
# inteiros.sort()
# inteiros.sort(reverse=True)
# print(inteiros)
# for i in range(len(inteiros)):
#     if inteiros[i]>10:
#         print(f"{inteiros[i]} é maior que 10")

# 6
# notas=[[7,8,9,6],[6,5,8,7],[10,9,8,9]]
# print(f"nota do segundo aluno na terceira disciplina: {notas[1][2]}")
# aluno1=sum(notas[0])/len(notas[0])
# aluno2=sum(notas[1])/len(notas[1])
# aluno3=sum(notas[2])/len(notas[2])
# if aluno1>aluno2 and aluno1>aluno3:
#     print(f"Aluno 1 tem a maior media {aluno1:.2f}")
# if aluno2>aluno1 and aluno2>aluno3:
#     print(f"Aluno 2 tem a maior media {aluno2:.2f}")
# if aluno3>aluno2 and aluno3>aluno1:
#     print(f"Aluno 3 tem a maior media {aluno3:.2f}")

# 7
# valores=[]
# count=0
# posicao=0
# countpar=0
# for i in range(0,4):
#     x=valores.append(int(input('Digite um numero: ')))
#     if x==9:
#         count+=1
#     if x==3:
#         posicao=i
#     if x%2==0:
#         countpar+=1
# print(f"Apareceu {count} noves, o primeiro 3 apareceu na posicao {i}, foram {countpar} numeros pares")

# 8
import random

dado = []

for i in range(0, 50):
    dado.append(random.randint(1, 6))

print("Lançamentos do dado:", dado)
face6 = dado.count(6)
percentual = (face6 / len(dado)) * 100
print(f"Face 6 apareceu {face6} vezes.")
print(f"Percentual de ocorrências da face 6: {percentual:.2f}%")