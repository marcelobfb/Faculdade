# função - def nome ():
def linha():
    print("-"*30)

def mostrar_nome(nome):
    print(f"Boa noite {nome}")

def soma(a,b):
    return a+b

def soma(*args):
    total=0
    for numeros in args:
        total+=numeros
    return total

# valores=input("Digite os números: ").split(",")
# valores_int = ([int(valor) for valor in valores])
# print(f"{soma(*valores_int)}")

def maior(*args):
    print(args)
    print(type(args))
    for num in args:
        if num>30:
            print(num)

# maior(10,20,30,40,50,60)

# r={"max":10,"meio":5,"min":0}
# def funcao(*args):
#     for chave in args:
#         print(chave)
# funcao(*r)

# **kwargs() - empacotados dicionario ----------------------------------------------
# def exemplo(**kwargs):
#     print(kwargs)

# exemplo(a=1,b=2,c=3)

# def pessoa(nome,idade,cidade):
#     print(f"Nome: {nome}")
#     print(f"Idade: {idade}")
#     print(f"Cidade: {cidade}")

# info_pessoa={"nome":"Thereza","idade":30,"cidade":"Niteroi"}
# pessoa(**info_pessoa)



# exceção
try:
    a=int(input("Digite um numero: "))
    b=int(input("Digite outro numero: "))
    r=a/b
except:

    print("Tivemos um problema no sitema")
else:
    print(f"a divisao de {a}/{b}={r}")
