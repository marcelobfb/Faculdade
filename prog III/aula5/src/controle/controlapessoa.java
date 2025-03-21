package controle;
import dominio.*;
import  java.util.Scanner;

public class controlapessoa {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Digite a id: ");
        int id=scanner.nextInt();
        System.out.printf("Digite o nome: ");
        String nome = scanner.next();
        System.out.printf("Digite a idade: ");
        int idade = scanner.nextInt();
        System.out.printf("Digite o peso: ");
        double peso=scanner.nextDouble();
        System.out.printf("Digite a altura: ");
        double altura=scanner.nextDouble();
        pessoa pessoa=new pessoa(id,nome,idade,peso,altura);
        pessoa.listarPessoa();
        System.out.printf("IMC: "+pessoa.calcularimc());
        scanner.close();
    }
}
