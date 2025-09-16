package modelo;

public class Campeao {
	private int ano;
	private String selecao;
	
	public Campeao(int ano, String selecao) {
		this.ano = ano;
		this.selecao = selecao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}
}
