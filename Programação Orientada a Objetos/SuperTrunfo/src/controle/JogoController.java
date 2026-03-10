package control;

import modelo.*;
import dao.CartaDAO;
import java.util.List;

public class JogoController {
    private Partida partida;
    private CartaDAO cartaDAO;

    public JogoController() {
        cartaDAO = new CartaDAO();
    }

    public void iniciarPartida(String nomeJogador) {
        List<Carta> baralho = cartaDAO.listarTodas();
        if (baralho.isEmpty()) {
            System.err.println("Nenhuma carta carregada. Verifique o arquivo CSV.");
            return;
        }
        Jogador jogador = new Jogador(nomeJogador, true);
        Jogador computador = new Jogador("Computador", false);
        partida = new Partida(jogador, computador, baralho);
    }

    public Partida getPartida() {
        return partida;
    }

    /**
     * Processa a rodada com o atributo escolhido pelo jogador.
     * @param atributo 1=velocidade, 2=aceleracao, 3=potencia
     * @return mensagem com o resultado
     */
    public String jogarRodada(int atributo) {
        Carta cartaJogador = partida.getJogador().getCartaDoTopo();
        Carta cartaComputador = partida.getComputador().getCartaDoTopo();

        if (cartaJogador == null || cartaComputador == null) {
            return "Erro: jogador sem cartas!";
        }

        int valorJogador = getValorAtributo(cartaJogador, atributo);
        int valorComputador = getValorAtributo(cartaComputador, atributo);

        String resultado;

        // Verifica Super Trunfo
        if (cartaJogador.isSuperTrunfo() && !cartaComputador.isSuperTrunfo()) {
            resultado = "SUPER TRUNFO! Você venceu a rodada!";
            transferirCartas(partida.getJogador(), partida.getComputador());
        } else if (!cartaJogador.isSuperTrunfo() && cartaComputador.isSuperTrunfo()) {
            resultado = "O computador usou o SUPER TRUNFO! Você perdeu a rodada.";
            transferirCartas(partida.getComputador(), partida.getJogador());
        } else if (valorJogador > valorComputador) {
            resultado = "Você venceu a rodada!";
            transferirCartas(partida.getJogador(), partida.getComputador());
        } else if (valorComputador > valorJogador) {
            resultado = "Computador venceu a rodada!";
            transferirCartas(partida.getComputador(), partida.getJogador());
        } else {
            resultado = "Empate! As cartas são descartadas.";
            descartarCartas();
        }

        partida.incrementarRodada();
        return resultado;
    }

    private int getValorAtributo(Carta c, int atributo) {
        switch (atributo) {
            case 1: return c.getVelocidade();
            case 2: return c.getAceleracao();
            case 3: return c.getPotencia();
            default: return 0;
        }
    }

    private void transferirCartas(Jogador vencedor, Jogador perdedor) {
        // Pega a carta do topo de cada um
        Carta cartaVencedor = vencedor.jogarCarta(0);
        Carta cartaPerdedor = perdedor.jogarCarta(0);
        // Vencedor recebe as duas
        vencedor.adicionarCarta(cartaVencedor);
        vencedor.adicionarCarta(cartaPerdedor);
    }

    private void descartarCartas() {
        // Remove as cartas do topo de ambos (descartadas)
        partida.getJogador().jogarCarta(0);
        partida.getComputador().jogarCarta(0);
    }

    public boolean verificarFimDeJogo() {
        return partida.fimDeJogo();
    }

    public String getVencedor() {
        return partida.getVencedor();
    }
}