package confederacao.controle;

import java.util.ArrayList;

import modelo.Jogador;
import modelo.Time;

public class ControleTime {
	private Time time = new Time();
	
	public void incluirTime(String sigla, String descricao) {
		time.setSigla(sigla);
		time.setDescricao(descricao);
	}
	
	public void incluirJogador(int numero, String nome, String posicao) {
		Jogador jogador = new Jogador();
		jogador.setNumero(numero);
		jogador.setNome(nome);
		jogador.setPosicao(posicao);
		time.adJogador(jogador);
	}
	
	public ArrayList<Jogador> exibirElenco() {
		return time.getJogadores();
	}
}