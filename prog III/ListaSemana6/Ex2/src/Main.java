import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite um número: ");
        int n = sc.nextInt();
        int count=0;
        while (count!=10){
            count++;
            System.out.println(n+"*"+count+"="+(n*count));
        }
    }
}