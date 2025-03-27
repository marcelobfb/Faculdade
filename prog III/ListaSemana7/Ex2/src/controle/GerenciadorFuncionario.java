package controle;
import dominio.Funcionario;
import java.util.Scanner;

public class GerenciadorFuncionario {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Sistema de Cálculo de Salário");
        System.out.print("Informe o nome do funcionario: ");
        String nome=scanner.nextLine();
        System.out.print("Informe o salario base: ");
        double salarioBase=scanner.nextDouble();
        System.out.print("Informe a categoria(A, B ou C): ");
        String categoria=scanner.next();

        Funcionario funcionario= new Funcionario(nome, salarioBase,categoria);
        double salarioFinal= funcionario.calcularSalarioFinal();
        System.out.println("Dados do funcionario");
        System.out.println("Nome: "+funcionario.getNome());
        System.out.println("Categoria: "+funcionario.getCategoria());
        System.out.println("Salario base: R$"+funcionario.getSalarioBase());
        System.out.println("Salario Final: R$"+salarioFinal);
    }
}
