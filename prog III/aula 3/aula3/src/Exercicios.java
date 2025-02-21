package controle;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

import static java.lang.Math.sqrt;

public class Exercicios {
    public static void main(String[] args)
    {
//        ?1
//        Scanner sc = new Scanner(System.in);
//
//        System.out.printf("Digite o valor de A: ");
//        int n1=sc.nextInt();
//
//        System.out.printf("Digite o valor de B: ");
//        int n2=sc.nextInt();
//
//        int soma=n1+n2;
//
//        System.out.printf("A soma de %d + %d = %d",n1,n2,soma);
//        ?2
//        Scanner sc = new Scanner(System.in);
//
//        System.out.printf("Digite o raio de um circulo: ");
//        float raio=sc.nextFloat();
//        Double pi=3.14;
//
//        System.out.printf("A area do circulo de raio %.2f é %.2f",raio,pi*raio*raio);
//
//        ?3
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Digite temperatura em graus celcius: ");
//        float c= sc.nextFloat();
//        float f=(c*9/5)+32;
//        System.out.printf("A temperatura %.2fº graus celcius equivale a %.2fº graus fahrenheit",c,f);
//        ?4
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Digite o valor da nota 1: ");
//        float n1=sc.nextInt();
//        System.out.printf("Digite o valor da nota 2: ");
//        float n2=sc.nextInt();
//        System.out.printf("Digite o valor da nota 3: ");
//        float n3=sc.nextInt();
//        float media=(n1+n2+n3)/3;
//        System.out.printf("A media das notas e %.2f",media);
//        ?5
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Quantos anos vc tem?");
//        int anos=sc.nextInt();
//        int dias=anos*365;
//        System.out.printf("Uma pessoa com %d anos tem %d dias de vida",anos,dias);
//        ?6
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Digite seu salario: ");
//        float salario=sc.nextFloat();
//        float inss=100;
//        System.out.printf("O salario com o desconto do inss vai de %.2f para %.2f",salario,salario-inss);
//        ?7
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Qual a base: ");
//        float base=sc.nextFloat();
//        System.out.printf("Qual a altura: ");
//        float altura=sc.nextFloat();
//        float area=base*altura;
//        float perimetro=2*(base+altura);
//        System.out.printf("A area é %.2f e o perimetro é %.2f",area,perimetro);
//        ?8
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Qual raio da esfera? ");
//        float raio=sc.nextFloat();
//        Double pi=3.14159;
//        Double volume=((double)4/3)*pi*(raio*raio*raio);
//        System.out.printf("O volume da esfera é %.2f",volume);
//        ?9
//        Scanner sc=new Scanner(System.in);
//        System.out.printf("Reais: ");
//        Double reais= sc.nextDouble();
//        System.out.printf("Qual a cotacao do dolar do dia: ");
//        Double dolar=sc.nextDouble();
//        System.out.printf("R$%.2f são $%.2f em dolar",reais,dolar/reais);
//        ?10
        Scanner sc=new Scanner(System.in);
        System.out.printf("Cordenada x1: ");
        Double x1= sc.nextDouble();
        System.out.printf("Cordenada x2: ");
        Double x2= sc.nextDouble();
        System.out.printf("Cordenada y1: ");
        Double y1= sc.nextDouble();
        System.out.printf("Cordenada y2: ");
        Double y2= sc.nextDouble();
        Double D = sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        System.out.printf("A distancia entre eles é %.2f",D);
    }
}
