# tupla é um conjunto de dados imutavel, é representada pelo ()

# a=(1,2,3,4.5,"Marcelo",True)
# print(a[:3])

# concatenar tuplas
# b=(1,2,3,4)
# c=(5,6,7,8)
# print(b+c)

# len() - qtd de elementos
# alunos=("a","b","c")
# print(f'Existem {len(alunos)} alunos')

# lista[]
# teste=["teste",1]
# print(teste)
# teste.pop(0)
# print(teste)
# teste.append("teste 2")
# print(teste)

# 
soma = []
nome = str(input("Nome: ").capitalize())

for i in range(3):
    nota = float(input("Nota: "))
    soma.append(nota)

media = sum(soma) / len(soma)

print(f"{nome}, suas notas são: {soma}")
print(f"A média das suas notas é: {media:.2f}")