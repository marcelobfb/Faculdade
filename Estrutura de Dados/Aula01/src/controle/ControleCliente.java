package controle;

import dominio.Cliente;
import dominio.PessoaFisica;
import dominio.PessoaJuridica;

import java.util.Scanner;

public class ControleCliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CADASTRO DE CLIENTES");
        System.out.print("Digite o CPF/CNPJ: ");
        String id = sc.nextLine();
        System.out.print("Digite o nome/razão social: ");
        String descricao = sc.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Digite 1 para Pessoa Fisica e 2 para Pessoa Juridica: ");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                PessoaFisica pf= new PessoaFisica(endereco, telefone, id, descricao);
                System.out.println("CLIENTE CADASTRADO");
                System.out.println("CPF:"+pf.getCpf());
                System.out.println("Nome:"+pf.getNome());
                System.out.println("Endereço:"+pf.getEndereco());
                System.out.println("Telefone:"+pf.formatarTelefone());
                break;
            case 2:
                PessoaJuridica pj= new PessoaJuridica(endereco, telefone, id, descricao);
                System.out.println("CLIENTE CADASTRADO");
                System.out.println("CNPJ:"+pj.getCnpj());
                System.out.println("Razão Social:"+pj.getRazaosocial());
                System.out.println("Endereço:"+pj.getEndereco());
                System.out.println("Telefone:"+pj.formatarTelefone());
                break;
        }
    }
}
