import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite nota(0-10): ");
        int nota = sc.nextInt();
        switch (nota){
            case 0,1,2:
                System.out.printf("Nota E");
                break;
            case 3,4:
                System.out.printf("Nota D");
                break;
            case 5,6:
                System.out.printf("Nota C");
                break;
            case 7,8:
                System.out.printf("Nota B");
                break;
            case 9,10:
                System.out.printf("Nota A");
                break;
            default:
                System.out.printf("Nota Invalida");
                break;
        }
    }
}