package controller;

import dao.CartaDAO;
import model.Carta;

import java.sql.SQLException;
import java.util.*;

/**
 * CONTROLLER — Toda a lógica de negócio / regras do Super Trunfo.
 *
 * A VIEW nunca acessa o DAO diretamente; tudo passa por aqui.
 */
public class GameController {

    // ──────────── dependências ────────────
    private final CartaDAO dao = new CartaDAO();

    // ──────────── estado da partida ────────────
    private List<Carta>  todasCartas     = new ArrayList<>();
    private Set<Integer> cartasUsadas    = new HashSet<>();
    private int          pontosJogador   = 0;
    private int          pontosMaquina   = 0;

    // ──────────── enum resultado ────────────
    public enum Resultado { JOGADOR, MAQUINA, EMPATE }

    // ─────────────────────────────────────────────
    //  Inicialização
    // ─────────────────────────────────────────────

    /**
     * Carrega as cartas do banco e zera a partida.
     * Deve ser chamado uma vez, no início do programa.
     */
    public void inicializar() throws SQLException {
        todasCartas  = dao.listarTodas();
        cartasUsadas = new HashSet<>();
        pontosJogador = 0;
        pontosMaquina = 0;
    }

    // ─────────────────────────────────────────────
    //  Leitura de estado
    // ─────────────────────────────────────────────

    public List<Carta> getTodasCartas() {
        return Collections.unmodifiableList(todasCartas);
    }

    public boolean cartaJaUsada(int idCarta) {
        return cartasUsadas.contains(idCarta);
    }

    public int getPontosJogador() { return pontosJogador; }
    public int getPontosMaquina() { return pontosMaquina; }

    /**
     * Retorna true quando não restam mais pares de cartas disponíveis
     * para uma nova rodada (jogo encerrado).
     */
    public boolean jogoEncerrado() {
        long disponiveis = todasCartas.stream()
            .filter(c -> !cartasUsadas.contains(c.getId()))
            .count();
        return disponiveis < 2;
    }

    /**
     * Vencedor final baseado na pontuação geral.
     * Chamado apenas após jogoEncerrado() == true.
     */
    public Resultado vencedorFinal() {
        if (pontosJogador > pontosMaquina) return Resultado.JOGADOR;
        if (pontosMaquina > pontosJogador) return Resultado.MAQUINA;
        return Resultado.EMPATE;
    }

    // ─────────────────────────────────────────────
    //  Lógica da rodada
    // ─────────────────────────────────────────────

    /**
     * Sorteia uma carta para a máquina — diferente da escolhida pelo
     * jogador e diferente de todas as cartas já usadas.
     *
     * @param cartaJogador carta escolhida pelo jogador
     * @return carta sorteada ou {@code null} se não houver carta disponível
     */
    public Carta sortearCartaMaquina(Carta cartaJogador) {
        List<Carta> disponiveis = new ArrayList<>();
        for (Carta c : todasCartas) {
            if (c.getId() != cartaJogador.getId()
                    && !cartasUsadas.contains(c.getId())) {
                disponiveis.add(c);
            }
        }
        if (disponiveis.isEmpty()) return null;
        return disponiveis.get(new Random().nextInt(disponiveis.size()));
    }

    /**
     * Compara a carta do jogador com a da máquina em todos os atributos,
     * atualiza a pontuação e marca as cartas como usadas.
     *
     * @return array de 7 posições:<br>
     *   [0] velocidade · [1] potência · [2] peso · [3] tanque ·
     *   [4] popularidade · [5] vitórias · [6] resultado geral da rodada
     */
    public Resultado[] compararCartas(Carta cJ, Carta cM) {
        Resultado[] r = new Resultado[7];

        r[0] = comparar(cJ.getVelocidade(),   cM.getVelocidade(),   true);   // maior vence
        r[1] = comparar(cJ.getPotencia(),      cM.getPotencia(),     true);   // maior vence
        r[2] = comparar(cJ.getPeso(),          cM.getPeso(),         false);  // MENOR vence
        r[3] = comparar(cJ.getTanque(),        cM.getTanque(),       true);   // maior vence
        r[4] = comparar(cJ.getPopularidade(),  cM.getPopularidade(), true);   // maior vence
        r[5] = comparar(cJ.getVitorias(),      cM.getVitorias(),     true);   // maior vence

        // ── Super Trunfo prevalece sobre tudo ──
        if (cJ.isSuperTrunfo() && !cM.isSuperTrunfo()) {
            r[6] = Resultado.JOGADOR;
        } else if (cM.isSuperTrunfo() && !cJ.isSuperTrunfo()) {
            r[6] = Resultado.MAQUINA;
        } else {
            int ptJ = 0, ptM = 0;
            for (int i = 0; i < 6; i++) {
                if (r[i] == Resultado.JOGADOR) ptJ++;
                else if (r[i] == Resultado.MAQUINA) ptM++;
            }
            if      (ptJ > ptM) r[6] = Resultado.JOGADOR;
            else if (ptM > ptJ) r[6] = Resultado.MAQUINA;
            else                r[6] = Resultado.EMPATE;
        }

        // ── atualiza placar ──
        if      (r[6] == Resultado.JOGADOR) pontosJogador++;
        else if (r[6] == Resultado.MAQUINA) pontosMaquina++;

        // ── marca cartas como usadas ──
        cartasUsadas.add(cJ.getId());
        cartasUsadas.add(cM.getId());

        return r;
    }

    // ──────────── helper ────────────

    private Resultado comparar(double valJ, double valM, boolean maiorVence) {
        if (valJ == valM) return Resultado.EMPATE;
        boolean jogadorVence = maiorVence ? (valJ > valM) : (valJ < valM);
        return jogadorVence ? Resultado.JOGADOR : Resultado.MAQUINA;
    }
}
