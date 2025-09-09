package controle;

import modelo.Jogador;
import modelo.Time;

import java.util.ArrayList;

public class ControleTime {
    private Jogador jogador = new Jogador();
    private Time time = new Time();

    public void incluirTime(String sigla, String descricao){
        time.setSigla(sigla);
        time.setDescricao(descricao);
    }

    public void incluirJogador(int numero, String nome, String posicao){
        jogador.setNumero(numero);
        jogador.setNome(nome);
        jogador.setPosicao(posicao);
        time.addJogador(jogador);
    }

    public ArrayList<Jogador> exibirElenco(){
        return time.getJogadores();
    }
}
