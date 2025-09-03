package controle;

import java.util.Vector;
import java.util.Iterator;
import dominio.Animal;

public class Programa03 {
    public static void main(String[] args) {
        Vector<Animal> animais = new Vector<Animal>();
        animais.add(new Animal("Betinha","Canina","Sreet Dog"));
        animais.add(new Animal("Rex", "Canina", "Pastor Alemão"));
        animais.add(new Animal("Mia", "Felina", "Gato Siamês"));
        animais.add(new Animal("Tobi", "Canina", "Shih Tzu"));
        animais.add(new Animal("Luna", "Felina", "Persa"));
        animais.add(new Animal("Bolt", "Canina", "Labrador"));

//        System.out.println("Animais: "+animais);
        // Itera e modifica a raça de "Street Dog" para "Viralata"
        Iterator<Animal> iterator = animais.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getRaca().equals("Street Dog")) {
                animal.setRaca("Viralata");
            }
        }

        // Imprime a lista de animais com a raça modificada
        for (Animal animal : animais) {
            System.out.println(animal.getNome() + "|" + animal.getEspecie() + "|" + animal.getRaca());
        }
    }
}