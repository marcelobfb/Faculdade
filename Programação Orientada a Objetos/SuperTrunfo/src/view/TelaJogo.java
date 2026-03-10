package view;

import control.JogoController;
import modelo.Carta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogo extends JFrame {
    private JogoController controller;
    private JLabel lblSuaCarta, lblInfoComputador, lblResultado;
    private JButton btnVelocidade, btnAceleracao, btnPotencia;
    private JTextArea txtLog;
    private JLabel lblNumCartasJogador, lblNumCartasComputador;

    public TelaJogo(String nomeJogador) {
        controller = new JogoController();
        controller.iniciarPartida(nomeJogador);
        initComponents();
        atualizarInterface();
    }

    private void initComponents() {
        setTitle("Super Trunfo - Jogador vs Computador");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel superior: informações dos jogadores e cartas
        JPanel painelTopo = new JPanel(new GridLayout(1, 2));

        // Painel do jogador
        JPanel painelJogador = new JPanel(new BorderLayout());
        painelJogador.setBorder(BorderFactory.createTitledBorder("Sua carta"));
        lblSuaCarta = new JLabel("", SwingConstants.CENTER);
        lblSuaCarta.setFont(new Font("Arial", Font.PLAIN, 14));
        painelJogador.add(lblSuaCarta, BorderLayout.CENTER);
        lblNumCartasJogador = new JLabel("Cartas: 0", SwingConstants.CENTER);
        painelJogador.add(lblNumCartasJogador, BorderLayout.SOUTH);

        // Painel do computador
        JPanel painelComputador = new JPanel(new BorderLayout());
        painelComputador.setBorder(BorderFactory.createTitledBorder("Computador"));
        lblInfoComputador = new JLabel("???", SwingConstants.CENTER);
        lblInfoComputador.setFont(new Font("Arial", Font.PLAIN, 14));
        painelComputador.add(lblInfoComputador, BorderLayout.CENTER);
        lblNumCartasComputador = new JLabel("Cartas: 0", SwingConstants.CENTER);
        painelComputador.add(lblNumCartasComputador, BorderLayout.SOUTH);

        painelTopo.add(painelJogador);
        painelTopo.add(painelComputador);
        add(painelTopo, BorderLayout.NORTH);

        // Painel central: log e resultado
        JPanel painelCentral = new JPanel(new BorderLayout());
        lblResultado = new JLabel(" ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        painelCentral.add(lblResultado, BorderLayout.NORTH);

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtLog);
        scroll.setBorder(BorderFactory.createTitledBorder("Histórico"));
        painelCentral.add(scroll, BorderLayout.CENTER);
        add(painelCentral, BorderLayout.CENTER);

        // Painel inferior: botões de atributos
        JPanel painelBotoes = new JPanel();
        btnVelocidade = new JButton("Velocidade (km/h)");
        btnAceleracao = new JButton("Aceleração (0-10)");
        btnPotencia = new JButton("Potência (cv)");

        ActionListener atributoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.verificarFimDeJogo()) {
                    JOptionPane.showMessageDialog(null, "O jogo já terminou!");
                    return;
                }

                int atributo = 0;
                if (e.getSource() == btnVelocidade) atributo = 1;
                else if (e.getSource() == btnAceleracao) atributo = 2;
                else if (e.getSource() == btnPotencia) atributo = 3;

                // Desabilitar botões enquanto processa
                setBotoesEnabled(false);

                // Processa a jogada
                String resultado = controller.jogarRodada(atributo);
                txtLog.append("Rodada " + controller.getPartida().getRodada() + ": " + resultado + "\n");
                lblResultado.setText(resultado);
                atualizarInterface();

                if (controller.verificarFimDeJogo()) {
                    String vencedor = controller.getVencedor();
                    JOptionPane.showMessageDialog(null, "Fim de jogo! Vencedor: " + vencedor);
                    setBotoesEnabled(false);
                } else {
                    setBotoesEnabled(true);
                }
            }
        };

        btnVelocidade.addActionListener(atributoListener);
        btnAceleracao.addActionListener(atributoListener);
        btnPotencia.addActionListener(atributoListener);

        painelBotoes.add(btnVelocidade);
        painelBotoes.add(btnAceleracao);
        painelBotoes.add(btnPotencia);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void setBotoesEnabled(boolean enabled) {
        btnVelocidade.setEnabled(enabled);
        btnAceleracao.setEnabled(enabled);
        btnPotencia.setEnabled(enabled);
    }

    private void atualizarInterface() {
        // Atualiza carta do jogador
        Carta cartaJogador = controller.getPartida().getJogador().getCartaDoTopo();
        if (cartaJogador != null) {
            String texto = "<html>" + cartaJogador.getNome() +
                    "<br>Velocidade: " + cartaJogador.getVelocidade() +
                    "<br>Aceleração: " + cartaJogador.getAceleracao() +
                    "<br>Potência: " + cartaJogador.getPotencia();
            if (cartaJogador.isSuperTrunfo()) {
                texto += "<br><b>SUPER TRUNFO!</b>";
            }
            texto += "</html>";
            lblSuaCarta.setText(texto);
        } else {
            lblSuaCarta.setText("Sem cartas");
        }

        // Atualiza informação do computador (sempre oculta)
        Carta cartaComputador = controller.getPartida().getComputador().getCartaDoTopo();
        if (cartaComputador != null) {
            lblInfoComputador.setText("??? (1 carta)");
        } else {
            lblInfoComputador.setText("Sem cartas");
        }

        // Atualiza contadores
        lblNumCartasJogador.setText("Cartas: " + controller.getPartida().getJogador().getNumCartas());
        lblNumCartasComputador.setText("Cartas: " + controller.getPartida().getComputador().getNumCartas());
    }
}