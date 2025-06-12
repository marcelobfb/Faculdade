import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaVeiculos {

    private static ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
            System.out.println();
        } while (opcao != 3);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("--- Sistema de Cadastro de Veículos ---");
        System.out.println("1 - Cadastrar novo veículo");
        System.out.println("2 - Listar veículos");
        System.out.println("3 - Sair");
        System.out.print(">> ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private static void cadastrarVeiculo() {
        System.out.println("\n--- Cadastro de Veículo ---");
        System.out.print("Tipo (1-Carro, 2-Moto, 3-Caminhão): ");
        int tipoVeiculo = lerOpcao();

        if (tipoVeiculo == -1) {
            return;
        }

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = -1;
        try {
            ano = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ano inválido. Por favor, digite um número.");
            scanner.next();
            return;
        } finally {
            scanner.nextLine();
        }


        switch (tipoVeiculo) {
            case 1: // Carro
                System.out.print("Quantidade de Portas: ");
                int qtdPortas = -1;
                try {
                    qtdPortas = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Quantidade de portas inválida. Por favor, digite um número.");
                    scanner.next();
                    return;
                } finally {
                    scanner.nextLine();
                }
                listaVeiculos.add(new Carro(placa, modelo, ano, qtdPortas));
                System.out.println("Carro cadastrado com sucesso!");
                break;
            case 2: // Moto
                System.out.print("Cilindrada: ");
                int cilindrada = -1;
                try {
                    cilindrada = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Cilindrada inválida. Por favor, digite um número.");
                    scanner.next();
                    return;
                } finally {
                    scanner.nextLine();
                }
                listaVeiculos.add(new Moto(placa, modelo, ano, cilindrada));
                System.out.println("Moto cadastrada com sucesso!");
                break;
            case 3: // Caminhão
                System.out.print("Capacidade de Carga (toneladas): ");
                double capacidadeCarga = -1;
                try {
                    capacidadeCarga = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Capacidade de carga inválida. Por favor, digite um número.");
                    scanner.next();
                    return;
                } finally {
                    scanner.nextLine();
                }
                listaVeiculos.add(new Caminhao(placa, modelo, ano, capacidadeCarga));
                System.out.println("Caminhão cadastrado com sucesso!");
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
                break;
        }
    }

    private static void listarVeiculos() {
        System.out.println("\n--- Veículos Cadastrados ---");
        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado ainda.");
        } else {
            for (Veiculo veiculo : listaVeiculos) {
                veiculo.exibirDados();
            }
        }
    }
}