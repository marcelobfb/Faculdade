import tkinter as tk
from tkinter import messagebox

class Aluno:
    def __init__(self, nome, idade, curso):
        self.nome = nome
        self.idade = int(idade)
        self.curso = curso
        self.notas = []

    def apresentar(self):
        return f"Olá boa noite, meu nome é {self.nome}, tenho {self.idade} anos e estudo {self.curso}"

    def maior_idade(self):
        if self.idade >= 18:
            return f'O(A) {self.nome} tem {self.idade} anos. É maior de idade.'
        else:
            return f'O(A) {self.nome} tem {self.idade} anos. Não é maior de idade.'

    def add_nota(self, nota):
        if 0 <= nota <= 10:
            self.notas.append(nota)
            return True
        else:
            return False

    def calcular_media(self):
        if len(self.notas) == 0:
            return 0
        else:
            return sum(self.notas) / len(self.notas)

    def verificar_aprovacao(self):
        media = self.calcular_media()
        if media >= 7:
            return f'{self.nome} foi aprovado(a) com média {media:.2f}.'
        else:
            return f'{self.nome} foi reprovado(a) com média {media:.2f}.'

class App:
    def __init__(self, root):
        self.root = root
        self.root.title('Gerenciador de Aluno')
        self.aluno = None
        self.create_widgets()

    def create_widgets(self):
        tk.Label(self.root, text='Nome').grid(row=0, column=0)
        self.nome_entry = tk.Entry(self.root)
        self.nome_entry.grid(row=0, column=1)

        tk.Label(self.root, text='Idade').grid(row=1, column=0)
        self.idade_entry = tk.Entry(self.root)
        self.idade_entry.grid(row=1, column=1)

        tk.Label(self.root, text='Curso').grid(row=2, column=0)
        self.curso_entry = tk.Entry(self.root)
        self.curso_entry.grid(row=2, column=1)

        tk.Button(self.root, text='Cadastrar Aluno', command=self.cadastrar_aluno).grid(row=3, columnspan=2, pady=10)

        tk.Label(self.root, text='Nota').grid(row=4, column=0)
        self.nota_entry = tk.Entry(self.root)
        self.nota_entry.grid(row=4, column=1)

        tk.Button(self.root, text='Adicionar Nota', command=self.adicionar_nota).grid(row=5, columnspan=2, pady=10)

        tk.Button(self.root, text='Media/Situação', command=self.mostrar_media_situacao).grid(row=6, columnspan=2, pady=10)
        tk.Button(self.root, text='Mostrar Dados', command=self.mostrar_dados).grid(row=7, columnspan=2, pady=10)

    def cadastrar_aluno(self):
        nome = self.nome_entry.get().strip()
        idade = self.idade_entry.get().strip()
        curso = self.curso_entry.get().strip()

        if nome and idade.isdigit() and curso:
            self.aluno = Aluno(nome, idade, curso)
            messagebox.showinfo('Cadastro Aluno', 'Aluno cadastrado com sucesso.')
        else:
            messagebox.showwarning('Erro', 'Erro! Preencha todos os campos corretamente.')

    def adicionar_nota(self):
        if not self.aluno:
            messagebox.showwarning('Erro', 'Erro! Cadastre um aluno primeiro.')
            return

        nota = self.nota_entry.get().strip()
        try:
            nota = float(nota)
            if self.aluno.add_nota(nota):
                messagebox.showinfo('Nota', 'Nota cadastrada com sucesso.')
            else:
                messagebox.showwarning('Erro', 'Nota deve estar entre 0 e 10.')
        except ValueError:
            messagebox.showwarning('Erro', 'Digite um número válido para a nota.')

    def mostrar_media_situacao(self):
        if not self.aluno:
            messagebox.showwarning('Erro', 'Erro! Cadastre um aluno primeiro.')
            return
        
        resultado = self.aluno.verificar_aprovacao()
        messagebox.showinfo('Situação', resultado)

    def mostrar_dados(self):
        if not self.aluno:
            messagebox.showwarning('Erro', 'Erro! Cadastre um aluno primeiro.')
            return
        
        dados = self.aluno.apresentar() + "\n" + self.aluno.maior_idade()
        messagebox.showinfo('Dados do Aluno', dados)


root = tk.Tk()
app = App(root)
root.mainloop()
