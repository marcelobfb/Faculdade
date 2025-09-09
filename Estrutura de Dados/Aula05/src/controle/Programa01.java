package controle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Programa01 {
    public static void main(String[] args) {
        ArrayList colecao = new ArrayList();
        String nome = "Fernanda";
        Integer idade = 12;
        Float peso=39.3f;

        colecao.add(nome);
        colecao.add(idade);
        colecao.add(peso);
        System.out.println(colecao);
    }
}
