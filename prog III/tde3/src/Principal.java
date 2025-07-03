import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecaController controller = new BibliotecaController();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Itens");
            System.out.println("3. Buscar Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o gênero: ");
                    String genero = scanner.nextLine();
                    controller.adicionarItem(new Livro(titulo, autor, ano, genero));
                    break;
                case 2:
                    controller.listarItens();
                    break;
                case 3:
                    System.out.print("Digite o título para buscar: ");
                    String buscaTitulo = scanner.nextLine();
                    try {
                        ItemBiblioteca item = controller.buscarItem(buscaTitulo);
                        item.exibirDados();
                    } catch (ItemNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Digite o título para remover: ");
                    String removerTitulo = scanner.nextLine();
                    controller.removerItem(removerTitulo);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
