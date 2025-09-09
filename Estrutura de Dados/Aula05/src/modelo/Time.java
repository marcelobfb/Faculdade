package modelo;

import java.util.ArrayList;

public class Time {
    private String sigla, descricao;
    private ArrayList<Jogador> jogadores;

    public Time() {

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

    public void addJogador(Jogador novoJogador) {
        if(!jogadores.contains(novoJogador)) {
            jogadores.add(novoJogador);
            novoJogador.setTime(this);
        }
    }
    public void removeJogador(Jogador novoJogador) {
        if(jogadores.contains(novoJogador)) {
            jogadores.remove(novoJogador);
            novoJogador.setTime(null);
        }
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
}
