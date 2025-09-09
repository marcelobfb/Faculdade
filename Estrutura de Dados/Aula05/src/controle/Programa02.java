package controle;

import javax.swing.*;
import java.util.ArrayList;

public class Programa02 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Pedro");
        nomes.add("Maria");
        nomes.add("Rodrigo");
        nomes.add("Antonio");
        nomes.add("Juanito");
        System.out.println(nomes);
        nomes.add(2,"Mariana");
        System.out.println(nomes);
        nomes.set(3,"Gabriel");
        System.out.println(nomes);

        System.out.println("Primeiro nome: " + nomes.get(0));
        System.out.println("Ultimo nome: " + nomes.get(nomes.size()-1));

        if(nomes.contains("Mariana")){
            System.out.println("Mariana existente");
        }
        else{
            System.out.println("Mariana nao existente");
        }
    }
}
