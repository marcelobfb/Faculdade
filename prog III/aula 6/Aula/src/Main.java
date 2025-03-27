import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] idades= new int[3];
        for (int i=0;i<3;i++){
            System.out.print("Digite idade: ");
            idades[i]=sc.nextInt();
        }
        for (int idade : idades){
            System.out.println("Idades: "+idade);
        }
//        for (int i=0;i<3;i++){
//            System.out.println("Idades: "+idades[i]);
//        }
    }
}
