package Visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.LivroDAO;
import Modelo.Livro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TelaCadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtVolume;
	private JLabel lblVolume;
	private JTextField txtGenero;
	private JLabel lblGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLivro frame = new TelaCadastroLivro();
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
	public TelaCadastroLivro() {
		setTitle("Cadastrar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 128));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Gênero");
		lblMarca.setBounds(106, 74, 46, 14);
		contentPane.add(lblGenero);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(253, 71, 86, 20);
		contentPane.add(txtGenero);
		txtMarca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(0, 128, 128));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca = txtGenero.getText();
				String especie = txtVolume.getText();
				
				Livro a = new Livro();
				String genero = null;
				a.setGenero(genero);
				String volume = null;
				a.setVolume(volume);
				LivroDAO dao = new LivroDAO();
				dao.inserir(a);
			}
		});
		btnCadastrar.setBounds(174, 172, 99, 23);
		contentPane.add(btnCadastrar);
		
		txtVolume = new JTextField();
		txtVolume.setBackground(new Color(248, 248, 255));
		txtVolume.setColumns(10);
		txtVolume.setBounds(199, 118, 123, 20);
		contentPane.add(txtVolume);
		
		lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVolume.setBounds(143, 121, 46, 14);
		contentPane.add(lblVolume);
		
		txtGenero = new JTextField();
		txtGenero.setBackground(new Color(248, 248, 255));
		txtGenero.setBounds(199, 77, 123, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGenero.setBounds(143, 80, 46, 14);
		contentPane.add(lblGenero);
	}
}