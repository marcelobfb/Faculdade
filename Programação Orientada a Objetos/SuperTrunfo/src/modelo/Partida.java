package modelo;

import java.util.Collections;
import java.util.List;

public class Partida {
    private Jogador jogador;
    private Jogador computador;
    private List<Carta> baralho;
    private int rodada;

    public Partida(Jogador jogador, Jogador computador, List<Carta> baralho) {
        this.jogador = jogador;
        this.computador = computador;
        this.baralho = baralho;
        this.rodada = 0;
        distribuirCartas();
    }

    private void distribuirCartas() {
        // Embaralhar as cartas
        Collections.shuffle(baralho);
        // Distribuir alternadamente (jogador começa)
        for (int i = 0; i < baralho.size(); i++) {
            if (i % 2 == 0) {
                jogador.adicionarCarta(baralho.get(i));
            } else {
                computador.adicionarCarta(baralho.get(i));
            }
        }
    }

    public Jogador getJogador() { return jogador; }
    public Jogador getComputador() { return computador; }
    public int getRodada() { return rodada; }
    public void incrementarRodada() { rodada++; }

    public boolean fimDeJogo() {
        return jogador.getNumCartas() == 0 || computador.getNumCartas() == 0;
    }

    public String getVencedor() {
        if (jogador.getNumCartas() > computador.getNumCartas())
            return jogador.getNome();
        else
            return computador.getNome();
    }
}