package modelo;

import java.util.ArrayList;

public class Time {
	private String sigla, descricao;
	private ArrayList<Jogador> jogadores;

	public Time() {
		jogadores = new ArrayList<Jogador>();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void adJogador(Jogador novoJogador) {
		if(!jogadores.contains(novoJogador)) {
			jogadores.add(novoJogador);
			novoJogador.setTime(this);
		}
	}
	
	public void removeJogador(Jogador exJogador) {
		if(jogadores.contains(exJogador)) {
			jogadores.remove(exJogador);
			exJogador.setTime(null);
		}
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
}