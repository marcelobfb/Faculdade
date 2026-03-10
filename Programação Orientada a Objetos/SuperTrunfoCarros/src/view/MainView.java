 package view;

import controller.GameController;
import controller.GameController.Resultado;
import model.Carta;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.sql.SQLException;
import java.util.List;

/**
 * VIEW — Interface gráfica principal do Super Trunfo Carros Pixar.
 * Construída com Java Swing. Segue o padrão MVC: esta classe apenas
 * delega ações ao GameController e exibe os resultados retornados.
 */
public class MainView extends JFrame {

    // ──────────── Paleta de cores Pixar Cars ────────────
    private static final Color C_BG         = new Color(15, 20, 35);       // fundo escuro pista
    private static final Color C_ASPHALT    = new Color(35, 38, 50);       // cinza asfalto
    private static final Color C_RED        = new Color(220, 38, 38);      // vermelho McQueen
    private static final Color C_GOLD       = new Color(255, 193, 7);      // dourado troféu
    private static final Color C_BLUE_LIGHT = new Color(96, 165, 250);     // azul claro
    private static final Color C_GREEN      = new Color(34, 197, 94);      // verde vitória
    private static final Color C_PANEL      = new Color(25, 30, 50);       // painel card
    private static final Color C_BORDER     = new Color(60, 70, 100);      // borda card
    private static final Color C_TEXT_DIM   = new Color(140, 150, 180);    // texto apagado

    // ──────────── Controller ────────────
    private final GameController controller = new GameController();

    // ──────────── Componentes de layout principal ────────────
    private JPanel      pnlCartas;          // grid de miniaturas das cartas
    private JPanel      pnlCartaJogador;    // detalhe carta jogador
    private JPanel      pnlCartaMaquina;    // detalhe carta máquina
    private JButton     btnJogar;
    private JLabel      lblTitulo;

    // ──────────── Campos de atributos (jogador / máquina) ────────────
    private JLabel lblJ_vel, lblM_vel, lblR_vel;
    private JLabel lblJ_pot, lblM_pot, lblR_pot;
    private JLabel lblJ_pes, lblM_pes, lblR_pes;
    private JLabel lblJ_tan, lblM_tan, lblR_tan;
    private JLabel lblJ_pop, lblM_pop, lblR_pop;
    private JLabel lblJ_vit, lblM_vit, lblR_vit;

    // ──────────── Placar ────────────
    private JLabel lblPtRodJ, lblPtRodM;
    private JLabel lblPtGerJ, lblPtGerM;
    private JLabel lblVencedor;

    // ──────────── Estado da UI ────────────
    private Carta    cartaSelecionada = null;
    private JButton  btnSelecionado   = null;

    // ══════════════════════════════════════════════════════════════
    //  Construtor
    // ══════════════════════════════════════════════════════════════
    public MainView() {
        configurarJanela();
        carregarDados();
    }

    // ─────────────────────────────────────────────────────────────
    //  Janela
    // ─────────────────────────────────────────────────────────────
    private void configurarJanela() {
        setTitle("⚡ Super Trunfo — Carros Pixar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 820);
        setMinimumSize(new Dimension(1100, 700));
        setLocationRelativeTo(null);
        setBackground(C_BG);

        // Painel raiz
        JPanel root = new JPanel(new BorderLayout(0, 0));
        root.setBackground(C_BG);
        root.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));

        root.add(criarHeader(),        BorderLayout.NORTH);
        root.add(criarAreaPrincipal(), BorderLayout.CENTER);
        root.add(criarRodape(),        BorderLayout.SOUTH);

        setContentPane(root);
    }

    // ─────────────────────────────────────────────────────────────
    //  Header
    // ─────────────────────────────────────────────────────────────
    private JPanel criarHeader() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(C_BG);
        p.setBorder(BorderFactory.createEmptyBorder(4, 0, 10, 0));

        // Título estilizado
        lblTitulo = new JLabel("⚡  SUPER TRUNFO — CARROS PIXAR", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Impact", Font.BOLD, 32));
        lblTitulo.setForeground(C_GOLD);

        JLabel sub = new JLabel("Escolha um carro e clique em JOGAR para desafiar a Máquina!", SwingConstants.CENTER);
        sub.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        sub.setForeground(C_TEXT_DIM);

        JPanel texts = new JPanel(new GridLayout(2, 1, 0, 2));
        texts.setBackground(C_BG);
        texts.add(lblTitulo);
        texts.add(sub);
        p.add(texts, BorderLayout.CENTER);

        // Botão JOGAR
        btnJogar = criarBotaoJogar();
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBackground(C_BG);
        btnPanel.add(btnJogar);
        p.add(btnPanel, BorderLayout.EAST);

        return p;
    }

    private JButton criarBotaoJogar() {
        JButton btn = new JButton("  JOGAR  ") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed())
                    g2.setColor(C_RED.darker());
                else if (getModel().isRollover())
                    g2.setColor(new Color(239, 68, 68));
                else
                    g2.setColor(C_RED);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Impact", Font.BOLD, 22));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 28, 10, 28));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addActionListener(e -> aoClicarJogar());
        return btn;
    }

    // ─────────────────────────────────────────────────────────────
    //  Área Principal (cartas + comparação)
    // ─────────────────────────────────────────────────────────────
    private JPanel criarAreaPrincipal() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBackground(C_BG);

        // Grid de miniaturas
        pnlCartas = new JPanel();
        pnlCartas.setBackground(C_BG);
        pnlCartas.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(C_BORDER, 1),
            "  Cartas disponíveis  ",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 12), C_TEXT_DIM));
        JScrollPane scroll = new JScrollPane(pnlCartas,
            JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBackground(C_BG);
        scroll.getViewport().setBackground(C_BG);
        scroll.setBorder(null);
        p.add(scroll, BorderLayout.NORTH);

        // Área de comparação
        p.add(criarAreaComparacao(), BorderLayout.CENTER);
        return p;
    }

    private JPanel criarAreaComparacao() {
        JPanel p = new JPanel(new BorderLayout(8, 0));
        p.setBackground(C_BG);

        pnlCartaJogador = criarPainelCartaDetalhe("VOCÊ");
        pnlCartaMaquina = criarPainelCartaDetalhe("MÁQUINA");

        p.add(pnlCartaJogador, BorderLayout.WEST);
        p.add(criarTabelaAtributos(), BorderLayout.CENTER);
        p.add(pnlCartaMaquina, BorderLayout.EAST);
        return p;
    }

    // ─────────────────────────────────────────────────────────────
    //  Painel de detalhe de uma carta (jogador ou máquina)
    // ─────────────────────────────────────────────────────────────
    private JPanel criarPainelCartaDetalhe(String titulo) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(C_PANEL);
        p.setBorder(new CompoundBorder(
            new LineBorder(C_BORDER, 1, true),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)));
        p.setPreferredSize(new Dimension(210, 320));

        JLabel lbl = new JLabel(titulo, SwingConstants.CENTER);
        lbl.setFont(new Font("Impact", Font.BOLD, 18));
        lbl.setForeground(titulo.equals("VOCÊ") ? C_BLUE_LIGHT : C_RED);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Emoji carro como placeholder visual
        JLabel ico = new JLabel(titulo.equals("VOCÊ") ? "🔵" : "🔴", SwingConstants.CENTER);
        ico.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 52));
        ico.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nomeCarta = new JLabel("—", SwingConstants.CENTER);
        nomeCarta.setFont(new Font("Segoe UI", Font.BOLD, 13));
        nomeCarta.setForeground(Color.WHITE);
        nomeCarta.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (titulo.equals("VOCÊ")) nomeCarta.setName("nomeJogador");
        else nomeCarta.setName("nomeMaquina");

        JLabel tipoCarta = new JLabel(" ", SwingConstants.CENTER);
        tipoCarta.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        tipoCarta.setForeground(C_TEXT_DIM);
        tipoCarta.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (titulo.equals("VOCÊ")) tipoCarta.setName("tipoJogador");
        else tipoCarta.setName("tipoMaquina");

        JLabel codigoCarta = new JLabel(" ", SwingConstants.CENTER);
        codigoCarta.setFont(new Font("Courier New", Font.BOLD, 14));
        codigoCarta.setForeground(C_GOLD);
        codigoCarta.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (titulo.equals("VOCÊ")) codigoCarta.setName("codJogador");
        else codigoCarta.setName("codMaquina");

        p.add(Box.createVerticalStrut(4));
        p.add(lbl);
        p.add(Box.createVerticalStrut(8));
        p.add(ico);
        p.add(Box.createVerticalStrut(6));
        p.add(codigoCarta);
        p.add(Box.createVerticalStrut(4));
        p.add(nomeCarta);
        p.add(Box.createVerticalStrut(2));
        p.add(tipoCarta);
        return p;
    }

    // ─────────────────────────────────────────────────────────────
    //  Tabela de atributos no centro
    // ─────────────────────────────────────────────────────────────
    private JPanel criarTabelaAtributos() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(C_ASPHALT);
        p.setBorder(new CompoundBorder(
            new LineBorder(C_BORDER, 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 8, 4, 8);
        g.fill = GridBagConstraints.HORIZONTAL;

        // cabeçalho
        adicionarCabecalho(p, g, "VOCÊ", "ATRIBUTO", "MÁQUINA");

        // linhas de atributos
        lblJ_vel = lblVal(); lblM_vel = lblVal(); lblR_vel = lblRes();
        lblJ_pot = lblVal(); lblM_pot = lblVal(); lblR_pot = lblRes();
        lblJ_pes = lblVal(); lblM_pes = lblVal(); lblR_pes = lblRes();
        lblJ_tan = lblVal(); lblM_tan = lblVal(); lblR_tan = lblRes();
        lblJ_pop = lblVal(); lblM_pop = lblVal(); lblR_pop = lblRes();
        lblJ_vit = lblVal(); lblM_vit = lblVal(); lblR_vit = lblRes();

        String[] attrs = {"Velocidade (km/h)", "Potência (cv)",
                          "Peso (kg) ↓menor", "Tanque (L)",
                          "Popularidade", "Vitórias"};
        JLabel[][] pares = {
            {lblJ_vel, lblM_vel, lblR_vel},
            {lblJ_pot, lblM_pot, lblR_pot},
            {lblJ_pes, lblM_pes, lblR_pes},
            {lblJ_tan, lblM_tan, lblR_tan},
            {lblJ_pop, lblM_pop, lblR_pop},
            {lblJ_vit, lblM_vit, lblR_vit}
        };

        for (int i = 0; i < attrs.length; i++) {
            adicionarLinhaAtributo(p, g, i + 1, pares[i][0], attrs[i], pares[i][1], pares[i][2]);
        }

        return p;
    }

    private void adicionarCabecalho(JPanel p, GridBagConstraints g,
                                     String t1, String t2, String t3) {
        g.gridy = 0;
        JLabel[] hs = {cab(t1, C_BLUE_LIGHT), cab(t2, C_GOLD), cab(t3, C_RED)};
        int[] cols = {0, 2, 4};
        for (int i = 0; i < 3; i++) {
            g.gridx = cols[i]; p.add(hs[i], g);
        }
        // separador
        g.gridx = 0; g.gridwidth = 5; g.gridy = 1;
        JSeparator sep = new JSeparator();
        sep.setForeground(C_BORDER);
        p.add(sep, g);
        g.gridwidth = 1;
    }

    private void adicionarLinhaAtributo(JPanel p, GridBagConstraints g, int row,
                                         JLabel valJ, String attr, JLabel valM, JLabel res) {
        g.gridy = row + 1;

        g.gridx = 0; p.add(valJ, g);

        g.gridx = 1; p.add(res, g);

        JLabel lAttr = new JLabel(attr, SwingConstants.CENTER);
        lAttr.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lAttr.setForeground(Color.WHITE);
        g.gridx = 2; p.add(lAttr, g);

        // coluna 3 = resultado lado máquina (reutilizar res com espelhamento)
        JLabel resM = lblRes(); resM.setName(res.getName() + "_M");
        g.gridx = 3; p.add(resM, g);

        g.gridx = 4; p.add(valM, g);
    }

    // ─────────────────────────────────────────────────────────────
    //  Rodapé (placar + vencedor)
    // ─────────────────────────────────────────────────────────────
    private JPanel criarRodape() {
        JPanel p = new JPanel(new GridLayout(1, 3, 10, 0));
        p.setBackground(C_BG);
        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(criarPainelPlacar("Pontuação da Rodada",
            lblPtRodJ = lblPlacar("—"), lblPtRodM = lblPlacar("—")));
        p.add(criarPainelPlacar("Pontuação Geral",
            lblPtGerJ = lblPlacar("0"), lblPtGerM = lblPlacar("0")));

        // Vencedor final
        JPanel pv = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        pv.setBackground(C_PANEL);
        pv.setBorder(new CompoundBorder(
            new LineBorder(C_BORDER, 1, true),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        JLabel lv = new JLabel("Vencedor Final:");
        lv.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lv.setForeground(C_TEXT_DIM);
        lblVencedor = new JLabel("—");
        lblVencedor.setFont(new Font("Impact", Font.BOLD, 22));
        lblVencedor.setForeground(C_GOLD);
        pv.add(lv); pv.add(lblVencedor);
        p.add(pv);

        return p;
    }

    private JPanel criarPainelPlacar(String titulo, JLabel valJ, JLabel valM) {
        JPanel p = new JPanel(new BorderLayout(0, 4));
        p.setBackground(C_PANEL);
        p.setBorder(new CompoundBorder(
            new LineBorder(C_BORDER, 1, true),
            BorderFactory.createEmptyBorder(6, 10, 6, 10)));

        JLabel tit = new JLabel(titulo, SwingConstants.CENTER);
        tit.setFont(new Font("Segoe UI", Font.BOLD, 12));
        tit.setForeground(C_TEXT_DIM);

        JPanel vals = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        vals.setBackground(C_PANEL);

        JLabel lblVoce = new JLabel("VOCÊ");
        lblVoce.setFont(new Font("Impact", Font.BOLD, 14));
        lblVoce.setForeground(C_BLUE_LIGHT);

        JLabel lblMaq = new JLabel("MÁQUINA");
        lblMaq.setFont(new Font("Impact", Font.BOLD, 14));
        lblMaq.setForeground(C_RED);

        vals.add(lblVoce); vals.add(valJ);
        vals.add(new JLabel("×") {{ setForeground(C_TEXT_DIM); }});
        vals.add(valM); vals.add(lblMaq);

        p.add(tit, BorderLayout.NORTH);
        p.add(vals, BorderLayout.CENTER);
        return p;
    }

    // ──────────── helpers de labels ────────────

    private JLabel lblVal() {
        JLabel l = new JLabel("—", SwingConstants.CENTER);
        l.setFont(new Font("Courier New", Font.BOLD, 14));
        l.setForeground(Color.WHITE);
        l.setPreferredSize(new Dimension(80, 24));
        return l;
    }

    private JLabel lblRes() {
        JLabel l = new JLabel("", SwingConstants.CENTER);
        l.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l.setPreferredSize(new Dimension(30, 24));
        return l;
    }

    private JLabel lblPlacar(String v) {
        JLabel l = new JLabel(v, SwingConstants.CENTER);
        l.setFont(new Font("Impact", Font.BOLD, 28));
        l.setForeground(Color.WHITE);
        l.setPreferredSize(new Dimension(50, 36));
        return l;
    }

    private JLabel cab(String txt, Color cor) {
        JLabel l = new JLabel(txt, SwingConstants.CENTER);
        l.setFont(new Font("Impact", Font.BOLD, 14));
        l.setForeground(cor);
        l.setPreferredSize(new Dimension(90, 28));
        return l;
    }

    // ═════════════════════════════════════════════════════════════
    //  Carregamento de dados (chama o Controller)
    // ═════════════════════════════════════════════════════════════

    private void carregarDados() {
        try {
            controller.inicializar();
            preencherGridCartas(controller.getTodasCartas());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao conectar ao banco de dados MySQL!\n\n" +
                ex.getMessage() + "\n\n" +
                "Verifique a URL/senha em util/ConexaoMySQL.java\ne execute o script sql/supertrunfo_carros.sql.",
                "Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void preencherGridCartas(List<Carta> cartas) {
        pnlCartas.removeAll();
        pnlCartas.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));

        for (Carta c : cartas) {
            JButton btn = criarBotaoCarta(c);
            pnlCartas.add(btn);
        }
        pnlCartas.revalidate();
        pnlCartas.repaint();
    }

    // ─────────────────────────────────────────────────────────────
    //  Botão miniatura de carta
    // ─────────────────────────────────────────────────────────────
    private JButton criarBotaoCarta(Carta carta) {
        JButton btn = new JButton() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                boolean usado = controller.cartaJaUsada(carta.getId());
                boolean selecionado = cartaSelecionada != null && cartaSelecionada.getId() == carta.getId();

                if (usado) {
                    g2.setColor(new Color(40, 40, 55));
                } else if (selecionado) {
                    g2.setColor(new Color(30, 80, 150));
                } else if (getModel().isRollover()) {
                    g2.setColor(new Color(50, 60, 90));
                } else {
                    g2.setColor(C_PANEL);
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

                // borda
                if (selecionado)
                    g2.setColor(C_BLUE_LIGHT);
                else if (carta.isSuperTrunfo())
                    g2.setColor(C_GOLD);
                else
                    g2.setColor(C_BORDER);
                g2.setStroke(new BasicStroke(selecionado ? 2.5f : 1f));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        // Conteúdo
        btn.setLayout(new BorderLayout(0, 2));
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        btn.setPreferredSize(new Dimension(110, 90));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // emoji icone
        String emoji = carta.isSuperTrunfo() ? "⭐" :
                       emojiCarro(carta.getCodigo());
        JLabel ico = new JLabel(emoji, SwingConstants.CENTER);
        ico.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 22));

        JLabel lCod = new JLabel(carta.getCodigo(), SwingConstants.CENTER);
        lCod.setFont(new Font("Courier New", Font.BOLD, 11));
        lCod.setForeground(carta.isSuperTrunfo() ? C_GOLD : C_TEXT_DIM);

        JLabel lNome = new JLabel("<html><center>" + carta.getNome() + "</center></html>", SwingConstants.CENTER);
        lNome.setFont(new Font("Segoe UI", Font.BOLD, 9));
        lNome.setForeground(Color.WHITE);

        JPanel info = new JPanel(new GridLayout(2, 1, 0, 1));
        info.setOpaque(false);
        info.add(lCod);
        info.add(lNome);

        btn.add(ico, BorderLayout.NORTH);
        btn.add(info, BorderLayout.CENTER);

        btn.addActionListener(e -> selecionarCarta(carta, btn));
        return btn;
    }

    private String emojiCarro(String cod) {
        return switch (cod) {
            case "1A" -> "🏎️";
            case "1B" -> "🚚";
            case "1C" -> "🟢";
            case "1D" -> "🟣";
            case "2A" -> "🚐";
            case "2B" -> "🔥";
            case "2C" -> "🇮🇹";
            case "2D" -> "⚡";
            default   -> "🚗";
        };
    }

    // ─────────────────────────────────────────────────────────────
    //  Seleção de carta pelo jogador
    // ─────────────────────────────────────────────────────────────
    private void selecionarCarta(Carta carta, JButton btn) {
        if (controller.cartaJaUsada(carta.getId())) return;

        cartaSelecionada = carta;
        btnSelecionado   = btn;

        // Atualiza painel do jogador
        atualizarPainelCartaDetalhe(pnlCartaJogador, carta, "nomeJogador", "tipoJogador", "codJogador");

        // Limpa resultado
        limparResultados();

        pnlCartas.repaint();
    }

    private void atualizarPainelCartaDetalhe(JPanel painel, Carta carta,
                                              String idNome, String idTipo, String idCod) {
        for (Component c : painel.getComponents()) {
            if (c instanceof JLabel l) {
                if (idNome.equals(l.getName())) l.setText(carta.getNome());
                if (idTipo.equals(l.getName())) l.setText(carta.getTipo());
                if (idCod.equals(l.getName()))  l.setText("[" + carta.getCodigo() + "]" +
                    (carta.isSuperTrunfo() ? " ⭐ SUPER TRUNFO" : ""));
            }
        }
        painel.revalidate(); painel.repaint();
    }

    // ═════════════════════════════════════════════════════════════
    //  JOGAR — ação principal
    // ═════════════════════════════════════════════════════════════
    private void aoClicarJogar() {
        if (cartaSelecionada == null) {
            JOptionPane.showMessageDialog(this,
                "Selecione uma carta antes de jogar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (controller.jogoEncerrado()) {
            JOptionPane.showMessageDialog(this,
                "O jogo já foi encerrado!\nClique OK para reiniciar.", "Fim de jogo",
                JOptionPane.INFORMATION_MESSAGE);
            reiniciar();
            return;
        }

        // Sorteia carta da máquina
        Carta cartaMaquina = controller.sortearCartaMaquina(cartaSelecionada);
        if (cartaMaquina == null) {
            JOptionPane.showMessageDialog(this, "Sem cartas disponíveis para a máquina!", "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualiza painel da máquina
        atualizarPainelCartaDetalhe(pnlCartaMaquina, cartaMaquina, "nomeMaquina", "tipoMaquina", "codMaquina");

        // Comparação
        Resultado[] resultados = controller.compararCartas(cartaSelecionada, cartaMaquina);

        // Exibe valores e ícones de resultado
        exibirResultados(cartaSelecionada, cartaMaquina, resultados);

        // Atualiza placar
        int ptRodJ = 0, ptRodM = 0;
        for (int i = 0; i < 6; i++) {
            if (resultados[i] == Resultado.JOGADOR) ptRodJ++;
            else if (resultados[i] == Resultado.MAQUINA) ptRodM++;
        }
        lblPtRodJ.setText(String.valueOf(ptRodJ));
        lblPtRodM.setText(String.valueOf(ptRodM));
        lblPtGerJ.setText(String.valueOf(controller.getPontosJogador()));
        lblPtGerM.setText(String.valueOf(controller.getPontosMaquina()));

        // Destaca vencedor da rodada
        String rodVenc;
        if (resultados[6] == Resultado.JOGADOR) {
            rodVenc = "⚡ VOCÊ venceu a rodada!";
            lblPtRodJ.setForeground(C_GREEN);
            lblPtRodM.setForeground(C_TEXT_DIM);
        } else if (resultados[6] == Resultado.MAQUINA) {
            rodVenc = "🤖 A MÁQUINA venceu a rodada!";
            lblPtRodM.setForeground(C_RED);
            lblPtRodJ.setForeground(C_TEXT_DIM);
        } else {
            rodVenc = "🤝 Empate na rodada!";
            lblPtRodJ.setForeground(C_GOLD);
            lblPtRodM.setForeground(C_GOLD);
        }

        // Atualiza grid (desabilita usadas)
        preencherGridCartas(controller.getTodasCartas());
        cartaSelecionada = null;

        // Jogo encerrado?
        if (controller.jogoEncerrado()) {
            Resultado vf = controller.vencedorFinal();
            String vencFinal;
            if (vf == Resultado.JOGADOR) {
                vencFinal = "⚡ VOCÊ";
                lblVencedor.setForeground(C_GREEN);
            } else if (vf == Resultado.MAQUINA) {
                vencFinal = "🤖 MÁQUINA";
                lblVencedor.setForeground(C_RED);
            } else {
                vencFinal = "🤝 EMPATE";
                lblVencedor.setForeground(C_GOLD);
            }
            lblVencedor.setText(vencFinal);

            JOptionPane.showMessageDialog(this,
                rodVenc + "\n\n══ FIM DE JOGO ══\n" +
                "Placar Final — VOCÊ: " + controller.getPontosJogador() +
                " × MÁQUINA: " + controller.getPontosMaquina() +
                "\n\nVENCEDOR: " + vencFinal,
                "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Apenas exibe resultado da rodada como toast temporário no título
            setTitle("⚡ Super Trunfo — " + rodVenc);
            Timer t = new Timer(3000,
                ae -> setTitle("⚡ Super Trunfo — Carros Pixar"));
            t.setRepeats(false);
            t.start();
        }
    }

    // ─────────────────────────────────────────────────────────────
    //  Exibe valores e ícones na tabela de atributos
    // ─────────────────────────────────────────────────────────────
    private void exibirResultados(Carta cJ, Carta cM, Resultado[] res) {
        // Valores
        lblJ_vel.setText(String.valueOf(cJ.getVelocidade()));
        lblJ_pot.setText(String.valueOf(cJ.getPotencia()));
        lblJ_pes.setText(String.valueOf(cJ.getPeso()));
        lblJ_tan.setText(String.valueOf(cJ.getTanque()));
        lblJ_pop.setText(String.valueOf(cJ.getPopularidade()));
        lblJ_vit.setText(String.valueOf(cJ.getVitorias()));

        lblM_vel.setText(String.valueOf(cM.getVelocidade()));
        lblM_pot.setText(String.valueOf(cM.getPotencia()));
        lblM_pes.setText(String.valueOf(cM.getPeso()));
        lblM_tan.setText(String.valueOf(cM.getTanque()));
        lblM_pop.setText(String.valueOf(cM.getPopularidade()));
        lblM_vit.setText(String.valueOf(cM.getVitorias()));

        // Ícones de resultado
        JLabel[] resJ = {lblR_vel, lblR_pot, lblR_pes, lblR_tan, lblR_pop, lblR_vit};
        for (int i = 0; i < 6; i++) {
            aplicarIconeResultado(resJ[i], res[i], true);
        }
    }

    private void aplicarIconeResultado(JLabel lbl, Resultado r, boolean isJogador) {
        if (r == Resultado.JOGADOR) {
            lbl.setText(isJogador ? "✅" : "❌");
        } else if (r == Resultado.MAQUINA) {
            lbl.setText(isJogador ? "❌" : "✅");
        } else {
            lbl.setText("➖");
        }
    }

    private void limparResultados() {
        for (JLabel l : new JLabel[]{
            lblJ_vel, lblJ_pot, lblJ_pes, lblJ_tan, lblJ_pop, lblJ_vit,
            lblM_vel, lblM_pot, lblM_pes, lblM_tan, lblM_pop, lblM_vit}) {
            l.setText("—");
        }
        for (JLabel l : new JLabel[]{
            lblR_vel, lblR_pot, lblR_pes, lblR_tan, lblR_pop, lblR_vit}) {
            l.setText("");
        }
        lblPtRodJ.setText("—"); lblPtRodM.setText("—");
        lblPtRodJ.setForeground(Color.WHITE); lblPtRodM.setForeground(Color.WHITE);
    }

    // ─────────────────────────────────────────────────────────────
    //  Reiniciar
    // ─────────────────────────────────────────────────────────────
    private void reiniciar() {
        cartaSelecionada = null;
        lblVencedor.setText("—");
        lblVencedor.setForeground(C_GOLD);
        limparResultados();
        lblPtGerJ.setText("0"); lblPtGerM.setText("0");

        // Limpa painéis de carta
        for (Component c : pnlCartaJogador.getComponents())
            if (c instanceof JLabel l && (
                "nomeJogador".equals(l.getName()) ||
                "tipoJogador".equals(l.getName()) ||
                "codJogador".equals(l.getName())))
                l.setText(l.getName().startsWith("cod") ? " " : "—");
        for (Component c : pnlCartaMaquina.getComponents())
            if (c instanceof JLabel l && (
                "nomeMaquina".equals(l.getName()) ||
                "tipoMaquina".equals(l.getName()) ||
                "codMaquina".equals(l.getName())))
                l.setText(l.getName().startsWith("cod") ? " " : "—");

        carregarDados();
        setTitle("⚡ Super Trunfo — Carros Pixar");
    }

    // ═════════════════════════════════════════════════════════════
    //  main
    // ═════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        // Look and feel do sistema para melhor aparência
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}
