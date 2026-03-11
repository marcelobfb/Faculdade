package controle;

import dao.DaoCriacaoTabela;
import view.CadastroAnimal;

public class Programa {
	public static void main(String[] args) {
		CadastroAnimal cadastroAnimal = new CadastroAnimal();
		
		cadastroAnimal.setVisible(true);
		
		DaoCriacaoTabela daoCriacaoTabela = new DaoCriacaoTabela();
	}
}