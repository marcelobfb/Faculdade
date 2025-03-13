import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite um numero: ");
        double n1=sc.nextDouble();
        if (n1%2==0)
        {
            System.out.println("O número é par.");
        }
        else
        {
            System.out.println("O número é ímpar.");
        }
    }
}