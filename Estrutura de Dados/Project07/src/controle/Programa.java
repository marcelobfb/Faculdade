package controle;

import java.util.HashSet;

public class Programa {
	public static void main (String[] args) {
		HashSet colecao = new HashSet();
		
		String nome = "Fernanda";
		Integer idade = 12;
		Float altura = 1.47f;
		
		colecao.add(nome);
		colecao.add(idade);
		colecao.add(altura);
		
		System.out.println(colecao);
	}
}
