import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[8];
        int contadorPares = 0;

        System.out.println("Digite 8 números inteiros:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) { 
                contadorPares++;
            }
        }

        System.out.println("\nQuantidade de números pares: " + contadorPares);

        scanner.close();
    }
}