package controle;
import dominio.Aluno;

import java.util.Scanner;


public class GerenciadorAluno {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Validação de Nota");

        System.out.printf("Qual o nome do aluno: ");
        String nome=scanner.nextLine();

        double nota;
        do {
            System.out.print("Qual a nota do aluno: ");
            nota=scanner.nextDouble();
            Aluno alunoTemp= new Aluno(nome,nota);
            if(alunoTemp.validarNota()==1){
                Aluno aluno = new Aluno(nome,nota);
                aluno.classificarAluno();
                break;
            }
            else {
                System.out.println("Nota invalida, Digite um valor entre 0 e 10.");
            }
        }while (true);
        scanner.close();
    }
}
