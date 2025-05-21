import tkinter as tk
from tkinter import messagebox


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


    # def menu():
    #     aluno = None
        
    #     while True:
    #         print('\n===== Menu =====')
    #         print('1- Cadastrar Aluno')
    #         print('2- Adicionar nota do aluno')
    #         print('3- Média/aprovação')
    #         print('4- Mostrar dados do aluno')
    #         print('5- Sair')

    #         opcao = input('Escolha a opção desejada (1-5): ').strip()

    #         if not opcao:
    #             print('Entrada vazia. Digite uma opção.')
    #             continue

    #         if opcao == '1':
    #             nome = input('Digite o nome do aluno: ')
    #             idade = int(input('Digite a idade do aluno: '))
    #             curso = input('Digite o curso do aluno: ')
    #             aluno = Aluno(nome, idade, curso)
    #             print('Aluno cadastrado com sucesso.')

    #         elif opcao == '2':
    #             if aluno:
    #                 try:
    #                     nota = float(input('Digite a nota do aluno: '))
    #                     aluno.add_nota(nota)
    #                 except ValueError:
    #                     print('Nota inválida. Insira uma nota entre 0 a 10.')
    #             else:
    #                 print('Cadastre um aluno primeiro (opção 1).')

    #         elif opcao == '3': 
    #             if aluno:
    #                 aluno.verificar_aprovacao()
    #             else:
    #                 print('Nenhum aluno cadastrado.')

    #         elif opcao == '4': 
    #             if aluno:
    #                 aluno.apresentar()
    #                 print(f'Média atual: {aluno.calcular_media():.2f}')
    #             else:
    #                 print('Nenhum aluno cadastrado.')

    #         elif opcao == '5':  
    #             print('Saindo...')
    #             break
    #         else:
    #             print('Opção inválida. Tente novamente.')

# aluno1 = Aluno('Thereza', 21, 'Python')
# aluno1.apresentar()
# aluno1.add_nota(4.6)
# aluno1.add_nota(6.4)
# aluno1.add_nota(9.6)
# aluno1.calcular_media()
# aluno1.verificar_aprovacao()
# aluno1.maior_idade()

# Aluno.menu()
class App:
    def __init__(self,root):
        self.root = root
        self.root.title('Gerenciador de Aluno')
        self.aluno = None
        self.create__widgets()
        
    def create_widgets(self):
        tk.Label(self.root, text='Aluno').grid(row=0,column=0)
        self.nome_entry=tk.Entry(self.root)
        self.nome_entry.grid(row=0,column=1)
        
        tk.Label(self.root, text='Idade').grid(row=1,column=0)
        self.idade_entry=tk.Entry(self.root)
        self.idade_entry.grid(row=1,column=1)
        
        tk.Label(self.root, text='Curso').grid(row=2,column=0)
        self.curso_entry=tk.Entry(self.root)
        self.curso_entry.grid(row=2,column=1)
        
        tk.Button(self.root,text='Cadastrar Aluno',command=self.cadastrar_aluno).grid(row=3,colspan=2,pady=10)
        
        tk.Label(self.root, text='Nota').grid(row=4,column=0)
        self.nota_entry=tk.Entry(self.root)
        self.nota_entry.grid(row=4,column=1)
        
        tk.Button(self.root,text='Adicionar Nota',command=self.adicionar_nota).grid(row=5,colspan=2,pady=10)
        tk.Button(self.root,text='Media/Situação',command=self.mostrar_media).grid(row=6,colspan=2,pady=10)
        tk.Button(self.root,text='Mostrar Dados',command=self.mostrar_dados).grid(row=7,colspan=2,pady=10)
        
    def cadastrar_aluno(self):
        nome=self.nome_entry.get().strip()
        idade=self.idade_entry.get().strip()
        curso=self.curso_entry.get().strip()
        
        if nome and idade.isdigit() and curso:
            self.aluno=Aluno(nome,idade,curso)
            messagebox.showinfo('Cadastro Aluno','Aluno cadastrado com sucesso.')
        else:
            messagebox.showwarning('Erro','Erro! Preencha todos os campos.')
            
    def adicionar_nota(self):
        if not self.aluno:
            messagebox.showwarning('Erro','Erro! Cadastre um aluno primeiro')
            return
        
        nota=self.nota_entry.get().strip()
        try:
            nota=float(nota)
            if self.aluno.adicionar_nota(nota):
                messagebox.showinfo('Nota','Nota cadastrada com sucesso.')
            else:
                messagebox.showwarning('Erro','Nota entre 0 e 10')
        except ValueError:
            messagebox.showwarning('Erro','Digite um numero valido')
            