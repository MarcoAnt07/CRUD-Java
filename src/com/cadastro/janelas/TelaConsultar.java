//Classe para a Criação da Janela para Consultar os Dados dos usuários
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cadastro.metodos.Banco;

public class TelaConsultar extends JFrame {

	private JPanel contentPane;
	private JTextField entradaUserConsulta;
	
	//Variável para armazenar o nome do usuário consultado
	static String nome = null;
	
	//Variável para armazenar o sobrenome do usuário consultado
	static String sobrenome = null;
	
	//Variável para armazenar a idade do usuário consultado
	static String idade = null;

	//Declaração do Método para iniciar a Janela de Consulta de Dados
	public TelaConsultar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 763, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String user = null;
		String pass = null;
		
		//Declaração do objeto para Realizar a Conexão com o Banco de Dados
		Banco bd = new Banco();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelConsultaDeDados = new JLabel("Digite o Usuário que deseja consultar:");
		labelConsultaDeDados.setFont(new Font("Arial", Font.BOLD, 22));
		labelConsultaDeDados.setBounds(10, 40, 401, 30);
		contentPane.add(labelConsultaDeDados);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Arial", Font.BOLD, 22));
		labelNome.setBounds(10, 146, 294, 30);
		contentPane.add(labelNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Arial", Font.BOLD, 22));
		lblSobrenome.setBounds(10, 228, 294, 30);
		contentPane.add(lblSobrenome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Arial", Font.BOLD, 22));
		lblIdade.setBounds(10, 310, 294, 30);
		contentPane.add(lblIdade);
		
		//Entrada do Username do usuário para Realizar a Consulta de Dados
		entradaUserConsulta = new JTextField();
		entradaUserConsulta.setToolTipText("");
		entradaUserConsulta.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaUserConsulta.setColumns(10);
		entradaUserConsulta.setBounds(10, 79, 385, 30);
		contentPane.add(entradaUserConsulta);
		
		//Label para printar o nome do usuário consultado
		JLabel labelPrintarNome = new JLabel();
		labelPrintarNome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarNome.setBounds(10, 187, 401, 30);
		contentPane.add(labelPrintarNome);
		
		//Label para printar o sobrenome do usuário consultado
		JLabel labelPrintarSobrenome = new JLabel();
		labelPrintarSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarSobrenome.setBounds(10, 269, 401, 30);
		contentPane.add(labelPrintarSobrenome);
		
		//Label para printar a idade do usuário consultado
		JLabel labelPrintarIdade = new JLabel();
		labelPrintarIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarIdade.setBounds(10, 351, 401, 30);
		contentPane.add(labelPrintarIdade);
		
		//Criação do Botão para executar o Método para Realizar a Consulta dos Dados do usuário
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			
			//Método para executar a ação
			public void actionPerformed(ActionEvent e) {
				
				//Função para tentar realizar a consulta dentro do Bando de Dados
				try {
					//Variável para realizar a Conexão com o Banco de Dados
					Connection con = bd.conectar();
					
					//Variável para realizar a Consulta dentro do Banco de Dados
					Statement declaracao;
					
					//Variável para armazenar os resultados da Consulta realizada
					ResultSet resultado;
					
					declaracao = con.createStatement();
					
					//Consulta que será realizada no Banco de Dados
					resultado = declaracao.executeQuery("select * from usuarios where username = '" + entradaUserConsulta.getText() + "'");
					
					//Função para buscar os dados dentro do Banco de Dados
					if(resultado.next()) {
						
						//Função para armazenar o nome do usuário dentro da variável "nome"
						nome = resultado.getString("nome");
						
						//Função para armazenar o sobrenome do usuário dentro da variável "sobrenome"
						sobrenome = resultado.getString("sobrenome");
						
						//Função para armazenar a idade do usuário dentro da variável "idade"
						idade = resultado.getString("idade");
						
						//Função para o Label pritar o dado que está armazenado na variável "nome"
						labelPrintarNome.setText(nome);
						
						//Função para o Label pritar o dado que está armazenado na variável "sobrenome"
						labelPrintarSobrenome.setText(sobrenome);
						
						//Função para o Label pritar o dado que está armazenado na variável "idade"
						labelPrintarIdade.setText(idade);
						
					}
				}
				//Caso não seja possível realizar a consulta será exibida a mensagem de usuário não encontrado
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "USUÁRIO NÃO ENCONTRADO");
				}
			}
		});
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 20));
		btnConsultar.setBounds(440, 80, 164, 28);
		contentPane.add(btnConsultar);
		
		getRootPane().setDefaultButton(btnConsultar);

		//Criação do Botão para retornar a Janela do Administrador
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.addActionListener(new ActionListener() {

			//Método para retonar para a Janela do Administrador
			public void actionPerformed(ActionEvent e) {

				//Função para fechar a Janela Atual
				dispose();

				//Método para retonar para a Janela do Administrador
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaADM window = new TelaADM();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}