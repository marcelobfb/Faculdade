package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    private boolean humano; // true se for jogador humano, false se for computador

    public Jogador(String nome, boolean humano) {
        this.nome = nome;
        this.humano = humano;
        this.mao = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public List<Carta> getMao() { return mao; }
    public boolean isHumano() { return humano; }

    public void adicionarCarta(Carta c) {
        mao.add(c);
    }

    public Carta jogarCarta(int index) {
        return mao.remove(index);
    }

    public Carta getCartaDoTopo() {
        if (mao.isEmpty()) return null;
        return mao.get(0);
    }

    public int getNumCartas() {
        return mao.size();
    }
}