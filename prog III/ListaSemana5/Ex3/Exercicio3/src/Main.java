import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        {
            Scanner sc = new Scanner(System.in);
            int x,n1,n2;

            do {
                System.out.println();
                System.out.println("-Calculadora-");
                System.out.println("Soma - 1");
                System.out.println("Subtração - 2");
                System.out.println("Divisão - 3");
                System.out.println("Multiplicação - 4");
                System.out.println("Sair - 5");
                System.out.printf("Digite o código: ");
                x = sc.nextInt();
                switch (x){
                    case 1:
                        System.out.println();
                        System.out.println("+Soma+");
                        System.out.printf("Digite o valor do primeiro número: ");
                        n1=sc.nextInt();
                        System.out.printf("Digite o valor do Segundo número: ");
                        n2=sc.nextInt();
                        System.out.printf(" "+n1+"+"+n2+"="+(n1+n2));
                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("-Subtração-");
                        System.out.printf("Digite o valor do primeiro número: ");
                        n1=sc.nextInt();
                        System.out.printf("Digite o valor do Segundo número: ");
                        n2=sc.nextInt();
                        System.out.printf(" "+n1+"-"+n2+"="+(n1-n2));
                        System.out.println();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("/Divisão/");
                        System.out.printf("Digite o valor do primeiro número: ");
                        n1=sc.nextInt();
                        System.out.printf("Digite o valor do Segundo número: ");
                        n2=sc.nextInt();
                        if (n2==0){
                            System.out.println("O segundo número é Zero");
                        }
                        System.out.printf(" "+n1+"/"+n2+"="+(n1/n2));
                        System.out.println();
                        break;

                    case 4:
                        System.out.println();
                        System.out.println("*Multiplicação*");
                        System.out.printf("Digite o valor do primeiro número: ");
                        n1=sc.nextInt();
                        System.out.printf("Digite o valor do Segundo número: ");
                        n2=sc.nextInt();
                        System.out.printf(" "+n1+"*"+n2+"="+(n1*n2));
                        System.out.println();
                        break;

                    default:
                        System.out.println();
                        System.out.println("Operção Invalida");
                        System.out.println();
                }
            }while (x!=5);
            System.out.println("Obrigado por usar a calculadora!");
        }
    }
}