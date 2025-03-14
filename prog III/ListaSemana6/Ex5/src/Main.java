import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Digite o primeiro número: ");
        int inicio = sc.nextInt();

        System.out.printf("Digite o segundo número: ");
        int fim = sc.nextInt();

        if (inicio < 1 || fim < 1) {
            System.out.println("Digite um número inteiro positivo.");
            return;
        }

        if (inicio > fim) {
            System.out.println("O início do intervalo deve ser menor ou igual ao fim.");
            return;
        }

        System.out.println("Números primos no intervalo de " + inicio + " a " + fim + ":");

        for (int num = inicio; num <= fim; num++) {
            boolean isPrimo = true;

            if (num < 2) {
                isPrimo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrimo = false;
                        break;
                    }
                }
            }

            if (isPrimo) {
                System.out.println(num);
            }
        }

        sc.close();
    }
}