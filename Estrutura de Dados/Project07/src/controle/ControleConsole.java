package controle;

import java.util.TreeSet;

import modelo.Console;

public class ControleConsole {

	public static void main(String[] args) {
		TreeSet<Console> consoles = new TreeSet<Console>();
		
		consoles.add(new Console("Odyssey",1972));
		consoles.add(new Console("Atari 2600",1976));
		consoles.add(new Console("Intellivision",1980));
		consoles.add(new Console("Gameboy",1989));
		consoles.add(new Console("Master System",1986));
		consoles.add(new Console("Mega Drive",1988));
		
		for(Console console : consoles) {
			System.out.println(console.getAno()+":"+console.getDescricao());
		}
	}
}
