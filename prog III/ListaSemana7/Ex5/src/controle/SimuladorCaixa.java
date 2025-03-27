package controle;
import dominio.CaixaEletronico;
import java.util.Scanner;

public class SimuladorCaixa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializa o caixa com um saldo fictício
        CaixaEletronico caixa = new CaixaEletronico(1000.00);

        int opcao;
        do {
            System.out.println("\n=== CAIXA ELETRÔNICO ===");
            System.out.println("1 - Realizar saque");
            System.out.println("2 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do saque (múltiplo de 10): R$");
                    double valorSaque = scanner.nextDouble();

                    int resultado = caixa.sacar(valorSaque);

                    if (resultado == 1) {
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Retire seu dinheiro.");
                    } else if (resultado == -1) {
                        System.out.println("Erro: O valor deve ser múltiplo de R$10,00");
                    } else if (resultado == -2) {
                        System.out.println("Erro: Saldo insuficiente");
                    }
                    break;

                case 2:
                    caixa.exibirSaldo();
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar nosso caixa eletrônico!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}