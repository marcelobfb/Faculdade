import java.util.Vector;

// 1. Classe Cliente: precisa do método equals() para o contains() funcionar
class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // É crucial sobrescrever equals() para que this.clientes.contains(novoCli)
    // saiba como comparar dois objetos Cliente.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        // Dois clientes são considerados iguais se tiverem o mesmo nome
        return nome.equals(cliente.nome);
    }

    // Boa prática: se sobrescreve equals(), deve-se sobrescrever hashCode()
    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}

// 2. Classe que contém o Vector e o método addCli
class GerenciadorClientes {
    // Usamos Vector, conforme mencionado no contexto do exercício
    private Vector<Cliente> clientes;

    public GerenciadorClientes() {
        this.clientes = new Vector<>();
    }

    /**
     * Adiciona um objeto Cliente à coleção, somente se ele ainda não existir.
     * Esta é a lógica que está sendo testada.
     */
    public void addCli(Cliente novoCli) {
        // Verifica se o objeto de cliente existe na coleção Vector
        if (this.clientes.contains(novoCli)) {
            // Se existir, apenas retorna (não insere)
            System.out.println("-> " + novoCli.getNome() + ": JÁ EXISTE. Não adicionado.");
            return;
        } else {
            // Caso não exista, insira esse objeto no final da coleção
            this.clientes.add(novoCli);
            System.out.println("-> " + novoCli.getNome() + ": Adicionado com sucesso!");
        }
    }

    public void listarClientes() {
        System.out.println("\n--- Clientes na Coleção (" + clientes.size() + ") ---");
        for (Cliente c : clientes) {
            System.out.println("- " + c.getNome());
        }
        System.out.println("----------------------------------------");
    }
}

// 3. Classe principal para execução do teste
public class Main {
    public static void main(String[] args) {
        GerenciadorClientes gerenciador = new GerenciadorClientes();

        Cliente cli1 = new Cliente("Alice");
        Cliente cli2 = new Cliente("Bob");
        Cliente cli1Duplicata = new Cliente("Alice"); // Mesmo nome, deve ser considerado duplicata

        System.out.println("--- Teste de Adição Inicial ---");
        gerenciador.addCli(cli1); // Deve adicionar
        gerenciador.addCli(cli2); // Deve adicionar

        gerenciador.listarClientes();

        System.out.println("--- Tentativa de Adicionar Duplicata ---");
        gerenciador.addCli(cli1Duplicata); // Não deve adicionar (mesmo nome)

        gerenciador.listarClientes(); // A contagem de clientes deve permanecer a mesma

        System.out.println("--- Tentativa de Adicionar um Novo Cliente ---");
        Cliente cli3 = new Cliente("Carlos");
        gerenciador.addCli(cli3); // Deve adicionar

        gerenciador.listarClientes();
    }
}