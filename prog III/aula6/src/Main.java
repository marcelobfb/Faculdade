import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de a: ");
        double a = scanner.nextInt();

        System.out.print("Digite o valor de b: ");
        double b = scanner.nextInt();

        try {
            double resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("ERRO: Não é possível dividir por zero.");
        } finally {
            scanner.close();
        }
    }
}
