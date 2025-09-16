package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ControleTime;
import modelo.Jogador;

public class Time extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tSigla;
	private JTextField tDescricao;
	private ControleTime controleTime = new ControleTime();
	private JTextField tNumero;
	private JTextField tNome;
	private JTextField tPosicao;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Time frame = new Time();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Time() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE JOGADOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 172, 283, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIGLA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 59, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DESCRIÇÃO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 84, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		tSigla = new JTextField();
		tSigla.setBounds(114, 58, 86, 20);
		contentPane.add(tSigla);
		tSigla.setColumns(10);
		
		tDescricao = new JTextField();
		tDescricao.setBounds(114, 84, 179, 20);
		contentPane.add(tDescricao);
		tDescricao.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR TIME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleTime.incluirTime(tSigla.getText(), tDescricao.getText());
				
				JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
				
				tSigla.setEnabled(false);
				tDescricao.setEnabled(false);
				
				tNumero.setEnabled(true);
				tNome.setEnabled(true);
				tPosicao.setEnabled(true);
			}
		});
		btnNewButton.setBounds(111, 115, 182, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 159, 290, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRO DE TIME");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 11, 283, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("NÚMERO:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(20, 219, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NOME:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(20, 248, 89, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("POSIÇÃO:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(20, 273, 89, 14);
		contentPane.add(lblNewLabel_1_3);
		
		tNumero = new JTextField();
		tNumero.setEnabled(false);
		tNumero.setBounds(114, 219, 86, 20);
		contentPane.add(tNumero);
		tNumero.setColumns(10);
		
		tNome = new JTextField();
		tNome.setEnabled(false);
		tNome.setBounds(114, 246, 179, 20);
		contentPane.add(tNome);
		tNome.setColumns(10);
		
		tPosicao = new JTextField();
		tPosicao.setEnabled(false);
		tPosicao.setBounds(114, 271, 179, 20);
		contentPane.add(tPosicao);
		tPosicao.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("CADASTRAR JOGADOR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleTime.incluirJogador(Integer.parseInt(tNumero.getText()), tNome.getText(), tPosicao.getText());
				
				JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!");
				
				tNumero.setText("");
				tNome.setText("");
				tPosicao.setText("");
			}
		});
		btnNewButton_1.setBounds(114, 310, 179, 23);
		contentPane.add(btnNewButton_1);
		
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tabela.setBounds(329, 11, 258, 280);
		contentPane.add(tabela);
		
		JButton btnNewButton_2 = new JButton("EXIBIR ELENCO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
				ArrayList<Jogador> jogadores = controleTime.exibirElenco();
				
				for(int i = 0; i < jogadores.size(); i++) {
					Object[] novaLinha = {jogadores.get(i).getNumero(), jogadores.get(i).getNome(), jogadores.get(i).getPosicao()};
					modelo.addRow(novaLinha);
				}
			}
		});
		btnNewButton_2.setBounds(339, 310, 248, 23);
		contentPane.add(btnNewButton_2);

	}
}