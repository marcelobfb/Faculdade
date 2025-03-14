import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite um numero: ");
        int n = sc.nextInt();
        System.out.println("Contagem regressiva: "+(n));
        do {
            System.out.println("Contagem regressiva: "+(n-1));
            n--;
        }while(n!=0);
    }
}