import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorAutomoveis gerenciador = new GerenciadorAutomoveis();
        int opcao;

        do {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (opcao) {
                    case 1: // Incluir automóvel
                        System.out.println("\n--- Incluir Automóvel ---");
                        System.out.print("Placa: ");
                        String placaIncluir = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloIncluir = scanner.nextLine();
                        System.out.print("Marca: ");
                        String marcaIncluir = scanner.nextLine();
                        System.out.print("Ano: ");
                        int anoIncluir = scanner.nextInt();
                        System.out.print("Valor: ");
                        double valorIncluir = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        Automovel novoAutomovel = new Automovel(placaIncluir, modeloIncluir, marcaIncluir, anoIncluir, valorIncluir);
                        if (!gerenciador.incluirAutomovel(novoAutomovel)) {
                            System.out.println("Erro: Já existe um automóvel com esta placa.");
                        }
                        break;

                    case 2: // Remover automóvel
                        System.out.println("\n--- Remover Automóvel ---");
                        System.out.print("Digite a placa do automóvel a ser removido: ");
                        String placaRemover = scanner.nextLine();
                        if (!gerenciador.removerAutomovel(placaRemover)) {
                            System.out.println("Automóvel com a placa " + placaRemover + " não encontrado.");
                        }
                        break;

                    case 3: // Alterar dados de automóvel
                        System.out.println("\n--- Alterar Dados de Automóvel ---");
                        System.out.print("Digite a placa do automóvel a ser alterado: ");
                        String placaAlterar = scanner.nextLine();

                        Automovel autoParaAlterar = gerenciador.consultarAutomovel(placaAlterar);
                        if (autoParaAlterar != null) {
                            System.out.println("Automóvel encontrado: " + autoParaAlterar);
                            System.out.print("Novo Modelo (" + autoParaAlterar.getModelo() + "): ");
                            String novoModelo = scanner.nextLine();
                            System.out.print("Nova Marca (" + autoParaAlterar.getMarca() + "): ");
                            String novaMarca = scanner.nextLine();
                            System.out.print("Novo Ano (" + autoParaAlterar.getAno() + "): ");
                            int novoAno = scanner.nextInt();
                            System.out.print("Novo Valor (" + String.format("%.2f", autoParaAlterar.getValor()) + "): ");
                            double novoValor = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline

                            gerenciador.alterarAutomovel(placaAlterar, novoModelo, novaMarca, novoAno, novoValor);
                        } else {
                            System.out.println("Automóvel com a placa " + placaAlterar + " não encontrado.");
                        }
                        break;

                    case 4: // Consultar automóvel por placa
                        System.out.println("\n--- Consultar Automóvel por Placa ---");
                        System.out.print("Digite a placa do automóvel a ser consultado: ");
                        String placaConsultar = scanner.nextLine();
                        Automovel automovelConsultado = gerenciador.consultarAutomovel(placaConsultar);
                        if (automovelConsultado != null) {
                            System.out.println("Automóvel encontrado: " + automovelConsultado);
                        } else {
                            System.out.println("Automóvel com a placa " + placaConsultar + " não encontrado.");
                        }
                        break;

                    case 5: // Listar automóveis (ordenado)
                        System.out.println("\n--- Listar Automóveis ---");
                        System.out.println("Ordenar por: ");
                        System.out.println("1 - Placa");
                        System.out.println("2 - Modelo");
                        System.out.println("3 - Marca");
                        System.out.print("Escolha o critério de ordenação: ");
                        int criterioOpcao = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        String criterio = "";
                        switch (criterioOpcao) {
                            case 1:
                                criterio = "placa";
                                break;
                            case 2:
                                criterio = "modelo";
                                break;
                            case 3:
                                criterio = "marca";
                                break;
                            default:
                                System.out.println("Opção inválida. Listando por placa.");
                                criterio = "placa";
                                break;
                        }

                        ArrayList<Automovel> lista = gerenciador.listarAutomoveis(criterio);
                        if (lista.isEmpty()) {
                            System.out.println("Nenhum automóvel cadastrado.");
                        } else {
                            System.out.println("\n--- Lista de Automóveis (ordenada por " + criterio + ") ---");
                            for (Automovel a : lista) {
                                System.out.println(a);
                            }
                            System.out.println("----------------------------------------");
                        }
                        break;

                    case 6: // Salvar e sair
                        System.out.println("Salvando dados e saindo...");
                        gerenciador.salvarDados();
                        break;

                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Clear the invalid input from the scanner
                opcao = 0; // Set to 0 to keep the loop going
            }
            System.out.println(); // Blank line for readability
        } while (opcao != 6);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("--- Menu de Gerenciamento de Automóveis ---");
        System.out.println("1 - Incluir automóvel");
        System.out.println("2 - Remover automóvel");
        System.out.println("3 - Alterar dados de automóvel");
        System.out.println("4 - Consultar automóvel por placa");
        System.out.println("5 - Listar automóveis (ordenado)");
        System.out.println("6 - Salvar e sair");
    }
}