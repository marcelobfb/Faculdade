package controle;
import java.util.Scanner;

public class ConversaoTemperatura {
    public static  void main(String[ ]arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a temperatura em Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        double celsius=(5.0/9.0)*(fahrenheit-32);
        System.out.printf("A temperatura em Celsius é: %.2f",celsius);
    }
}
