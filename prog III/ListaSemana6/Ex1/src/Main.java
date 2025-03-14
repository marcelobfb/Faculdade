import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite um numero: ");
        int n= sc.nextInt();
        int acumulador=0;
        for (int i=0;i<n;i++){
            acumulador+=i;
        }
        System.out.println("A soma dos numeros ate oque foi solicitado é "+acumulador);
    }
}