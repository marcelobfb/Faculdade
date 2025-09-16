package controle;

import java.util.TreeSet;

public class Programa04 {

	public static void main(String[] args) {
		TreeSet<String> nomes = new TreeSet<String>();
		
		nomes.add("Marcelo");
		nomes.add("Jose");
		nomes.add("Maria");
		nomes.add("Dalira");
		nomes.add("Gerson");
		
		System.out.println(nomes);

		nomes.add("Joao");
		nomes.add("Mariana");
		nomes.add("Gabriel");
		nomes.add("Fernanda");
		nomes.add("Taina");
		
		System.out.println(nomes);

	}

}
