public class Main {

    // Classe base
    static class Animal {
        public void fazerSom() {
            System.out.println("O animal faz um som genérico.");
        }
    }

    // Subclasse que estende Animal e sobrescreve fazerSom()
    static class Cachorro extends Animal {
        @Override // Indicando que este método sobrescreve o da superclasse
        public void fazerSom() {
            System.out.println("O cachorro late: Au Au!");
        }
    }

    public static void main(String[] args) {
        Animal meuAnimal = new Animal();
        Animal meuCachorro = new Cachorro(); // Polimorfismo: um Cachorro é um Animal

        System.out.println("Chamando o método da classe base:");
        meuAnimal.fazerSom(); // Saída: O animal faz um som genérico.

        System.out.println("\nChamando o método sobrescrito na subclasse:");
        meuCachorro.fazerSom(); // Saída: O cachorro late: Au Au!
    }
}