package controle;

import java.util.TreeSet;

public class Programa03 {

	public static void main(String[] args) {
		TreeSet<Integer> numeros = new TreeSet<Integer>();
		
		numeros.add(17);
		numeros.add(26);
		numeros.add(3);
		numeros.add(38);
		numeros.add(23);
		
		System.out.println(numeros);
		
		numeros.add(83);
		numeros.add(27);
		numeros.add(79);
		numeros.add(70);
		numeros.add(42);
		
		System.out.println(numeros);

	}

}
