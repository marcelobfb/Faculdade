package controle;

import java.util.Vector;

public class Programa02 {
    public static void main(String[] args) {
        Vector<String> pessoas= new Vector<String>();

        pessoas.add("Gabriel");
        pessoas.add("Maria");
        pessoas.add("Pedro");
        pessoas.add("Antonio");
        pessoas.add("Juliana");
        pessoas.add("Antonio");
        pessoas.add("Mariana");

        System.out.println(pessoas);
        System.out.println("Tamanho da coleção: "+pessoas.size());
        System.out.println("Primeiro elemento: "+pessoas.firstElement());
        System.out.println("Último elemento: "+pessoas.lastElement());
        System.out.println("Retornando objeto da posição 3: "+pessoas.elementAt(3));
        System.out.println("Retorna a primeira posição em que o objeto foi encontrado: "+pessoas.indexOf("Antonio"));
        System.out.println("Retorna a ultima posição em que o objeto foi encontado: "+pessoas.lastIndexOf("Antonio"));
        System.out.println("Antonio existe dentro do vetor: "+pessoas.contains("Antonio"));
        System.out.println("remover Mariana"+pessoas.remove("Mariana"));
        System.out.println(pessoas);

    }
}
