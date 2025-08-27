package controle;

import java.util.Vector;
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

        System.out.println("Animais: "+animais);
    }
}
