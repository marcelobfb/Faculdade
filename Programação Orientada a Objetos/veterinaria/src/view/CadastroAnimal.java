package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.ControleAnimal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroAnimal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEspecie;
	private JTextField textRaca;
	private ControleAnimal controleAnimal = new ControleAnimal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAnimal frame = new CadastroAnimal();
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
	public CadastroAnimal() {
		setTitle("SysVet 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE ANIMAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 62, 138, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ESPÉCIE:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(20, 105, 138, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("RAÇA:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(20, 148, 138, 32);
		contentPane.add(lblNewLabel_1_2);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Arial", Font.PLAIN, 18));
		textNome.setBounds(127, 62, 245, 32);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textEspecie = new JTextField();
		textEspecie.setFont(new Font("Arial", Font.PLAIN, 18));
		textEspecie.setColumns(10);
		textEspecie.setBounds(127, 105, 245, 32);
		contentPane.add(textEspecie);
		
		textRaca = new JTextField();
		textRaca.setFont(new Font("Arial", Font.PLAIN, 18));
		textRaca.setColumns(10);
		textRaca.setBounds(127, 148, 245, 32);
		contentPane.add(textRaca);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String especie = textEspecie.getText();
				String raca = textRaca.getText();
				
				controleAnimal.cadastrarAnimal(nome, especie, raca);
				
				JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
				
				textNome.setText("");
				textEspecie.setText("");
				textRaca.setText("");
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(127, 201, 197, 40);
		contentPane.add(btnNewButton);

	}
}
