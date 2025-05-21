class Aluno:
    def __init__(self, nome, idade, curso):
        self.nome = nome
        self.idade = idade
        self.curso = curso
        self.notas = []

    def apresentar(self):
        print(f"Olá boa noite, meu nome é {self.nome}, tenho {self.idade} anos e estudo {self.curso}")

    def maior_idade(self):
        if self.idade >= 18:
            print(f'O(A) {self.nome} tem {self.idade} anos. É maior de idade.')
        else:
            print(f'O(A) {self.nome} tem {self.idade} anos. Não é maior de idade.')

    def add_nota(self, nota):
        if 0 <= nota <= 10:
            self.notas.append(nota)
            print('Nota adicionada.')
        else:
            print('Nota inválida. (Insira nota de 0 a 10)')

    def calcular_media(self):
        if len(self.notas) == 0:
            return 0
        else:
            return sum(self.notas) / len(self.notas)

    def verificar_aprovacao(self):
        media = self.calcular_media()
        print(f'A média de {self.nome}: {media:.2f}')
        if media >= 7:
            print(f'{self.nome} foi aprovado!')
        else:
            print(f'{self.nome} foi reprovado.')

    def menu():
        aluno = None
        
        while True:
            print('\n===== Menu =====')
            print('1- Cadastrar Aluno')
            print('2- Adicionar nota do aluno')
            print('3- Média/aprovação')
            print('4- Mostrar dados do aluno')
            print('5- Sair')

            opcao = input('Escolha a opção desejada (1-5): ').strip()

            if not opcao:
                print('Entrada vazia. Digite uma opção.')
                continue
            
            if opcao == '1':
                nome = input('Digite o nome do aluno: ')
                idade = int(input('Digite a idade do aluno: '))
                curso = input('Digite o curso do aluno: ')
                aluno = Aluno(nome, idade, curso)
                print('Aluno cadastrado com sucesso.')

            elif opcao == '2':
                if aluno:
                    try:
                        nota = float(input('Digite a nota do aluno: '))
                        aluno.add_nota(nota)
                    except ValueError:
                        print('Nota inválida. Insira uma nota entre 0 a 10.')
                else:
                    print('Cadastre um aluno primeiro (opção 1).')

            elif opcao == '3': 
                if aluno:
                    aluno.verificar_aprovacao()
                else:
                    print('Nenhum aluno cadastrado.')

            elif opcao == '4': 
                if aluno:
                    aluno.apresentar()
                    print(f'Média atual: {aluno.calcular_media():.2f}')
                else:
                    print('Nenhum aluno cadastrado.')

            elif opcao == '5':  
                print('Saindo...')
                break
            else:
                print('Opção inválida. Tente novamente.')

# aluno1 = Aluno('Thereza', 21, 'Python')
# aluno1.apresentar()
# aluno1.add_nota(4.6)
# aluno1.add_nota(6.4)
# aluno1.add_nota(9.6)
# aluno1.calcular_media()
# aluno1.verificar_aprovacao()
# aluno1.maior_idade()

Aluno.menu()
