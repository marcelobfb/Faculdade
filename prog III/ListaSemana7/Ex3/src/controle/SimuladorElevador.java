package controle;
import dominio.Elevador;
import java.util.Scanner;

public class SimuladorElevador {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Elevador");
        System.out.print("Quantos andares tem o predio: ");
        int totalAndares=scanner.nextInt();
        int andarAtual=0;
        Elevador elevador=new Elevador(andarAtual,totalAndares);
        int opcao;
        do{
            System.out.println("Elevador");
            System.out.println("1- Subir");
            System.out.println("2- Descer");
            System.out.println("3- Sair");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    elevador.subir();
                    elevador.exibirAndar();
                    break;
                case 2:
                    elevador.descer();
                    elevador.exibirAndar();
                    break;
                default:
                    System.out.println("Digite uma opção valida");
            }
        }while(opcao!=3);
        scanner.close();
    }
}
