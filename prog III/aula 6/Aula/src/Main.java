import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[] idades= new int[3];
        ArrayList <String> nome = new ArrayList<>();

        for (int i=0;i<3;i++){
            System.out.print("Digite Nome: ");
            String nom = sc.nextLine();
            nome.add(nom);
        }
        for (int i=0;i<3;i++){
            System.out.print("Digite idade: ");
            idades[i]=sc.nextInt();
        }
//        for (int idade : idades){
//            System.out.println("Idades: "+idade);
//        }
//        for (String no:nome){
//            System.out.println("Nome: "+no);
//        }
        for (int i=0;i<3;i++){
            System.out.println("Nome: "+nome.get(i).substring(0,1).toUpperCase() + nome.get(i).substring(1)+" e Idades: "+idades[i]);
        }






    }

}
