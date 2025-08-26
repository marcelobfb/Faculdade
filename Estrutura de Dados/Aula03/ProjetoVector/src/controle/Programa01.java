package controle;

import java.util.Vector;

public class Programa01 {
    public static void main(String[] args) {
        Vector colecao = new Vector();

        String nome= "Gabriel";
        Integer idade=23;
        Float altura=1.3f;

        colecao.add(nome);
        colecao.add(idade);
        colecao.add(altura);

        System.out.println(colecao);
    }
}
