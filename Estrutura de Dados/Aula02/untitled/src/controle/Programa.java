package controle;

import modelo.Animal;
import modelo.Cliente;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("CADASTRO DE CLIENTE");
        System.out.print("Cpf: ");
        String cpf = input.nextLine();
        System.out.print("Nome: ");
        String nome = input.nextLine();

        Cliente cliente = new Cliente(cpf, nome);

        System.out.println("CADASTRO DE ANIMAIS");
        for (int i=0;i<3;i++){
            System.out.print("Nome: ");
            nome = input.nextLine();
            System.out.print("Especie: ");
            String especie = input.nextLine();
            System.out.print("Raça: ");
            String raca = input.nextLine();
            System.out.println("----------------");

            Animal animal = new Animal(nome, especie, raca);
            cliente.addAnimal(animal);
        }
        System.out.println("Animais do Cliente "+ cliente.getNome());
//        System.out.println(cliente.getAnimais());
        for(Animal animal : cliente.getAnimais()){
            System.out.println("Nome: " + animal.getNome());
        }
    }
}
