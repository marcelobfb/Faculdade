package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JTextField txtJogador;
    private JButton btnIniciar;

    public TelaPrincipal() {
        setTitle("Super Trunfo - Carros Esportivos");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Digite seu nome:"));
        txtJogador = new JTextField(20);
        panel.add(txtJogador);

        btnIniciar = new JButton("Iniciar Partida vs Computador");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtJogador.getText().trim();
                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite seu nome!");
                } else {
                    new TelaJogo(nome).setVisible(true);
                    dispose();
                }
            }
        });
        panel.add(btnIniciar);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}