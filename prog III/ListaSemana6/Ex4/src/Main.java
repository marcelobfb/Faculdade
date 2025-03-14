import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Quantos alunos tem na turma: ");
        int qtdAlunos = sc.nextInt();
        double somaNota=0;
        double nota=0;
        for (int i=0;i<qtdAlunos;i++){
            System.out.printf("Qual a nota do "+(i+1)+"aluno: ");
            nota= sc.nextDouble();
            somaNota+=nota;
        }
        double media=somaNota/qtdAlunos;
        System.out.println("A média da turma é "+media);
    }
}