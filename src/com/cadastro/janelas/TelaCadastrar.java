//Classe para a Criação da Janela para Cadastrar Novos Usuários
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cadastro.metodos.Cadastrar;

public class TelaCadastrar {

	JFrame frame;
	private JTextField entradaNovoUser;
	private JTextField entradaCPF;
	private JTextField entradaSobrenome;
	private JTextField entradaIdade;
	private JTextField entradaNome;
	private JPasswordField entradaNovaSenha;

	//Declaração do Método para executar o método para inicializar a Janela para Cadastrar Novos Usuários
	public TelaCadastrar() {
		initialize();
	}

	//Declaração do Método para inicializar a Janela
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 763, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Entrada do username do Novo Usuário
		entradaNovoUser = new JTextField();
		entradaNovoUser.setToolTipText("");
		entradaNovoUser.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaNovoUser.setColumns(10);
		entradaNovoUser.setBounds(50, 124, 294, 30);
		frame.getContentPane().add(entradaNovoUser);
		
		//Entrada do CPF do Novo Usuário
		entradaCPF = new JTextField();
		entradaCPF.setToolTipText("");
		entradaCPF.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaCPF.setColumns(10);
		entradaCPF.setBounds(50, 291, 294, 30);
		frame.getContentPane().add(entradaCPF);
		
		//Entrada do sobrenome do Novo Usuário
		entradaSobrenome = new JTextField();
		entradaSobrenome.setToolTipText("");
		entradaSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaSobrenome.setColumns(10);
		entradaSobrenome.setBounds(417, 206, 294, 30);
		frame.getContentPane().add(entradaSobrenome);
		
		//Entrada da idade do Novo Usuário
		entradaIdade = new JTextField();
		entradaIdade.setToolTipText("");
		entradaIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaIdade.setColumns(10);
		entradaIdade.setBounds(417, 291, 294, 30);
		frame.getContentPane().add(entradaIdade);
		
		//Entrada do nome do Novo Usuário
		entradaNome = new JTextField();
		entradaNome.setToolTipText("");
		entradaNome.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaNome.setColumns(10);
		entradaNome.setBounds(417, 124, 294, 30);
		frame.getContentPane().add(entradaNome);
		
		//Entrada da senha do Novo Usuário
		entradaNovaSenha = new JPasswordField();
		entradaNovaSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaNovaSenha.setBounds(50, 206, 294, 30);
		frame.getContentPane().add(entradaNovaSenha);
		
		JLabel labelNovoUser = new JLabel("Usuário:");
		labelNovoUser.setFont(new Font("Arial", Font.BOLD, 22));
		labelNovoUser.setBounds(50, 83, 294, 30);
		frame.getContentPane().add(labelNovoUser);
		
		JLabel labelNovaSenha = new JLabel("Senha:");
		labelNovaSenha.setFont(new Font("Arial", Font.BOLD, 22));
		labelNovaSenha.setBounds(50, 165, 294, 30);
		frame.getContentPane().add(labelNovaSenha);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Arial", Font.BOLD, 22));
		labelCPF.setBounds(50, 250, 294, 30);
		frame.getContentPane().add(labelCPF);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Arial", Font.BOLD, 22));
		labelNome.setBounds(417, 83, 294, 30);
		frame.getContentPane().add(labelNome);
		
		JLabel labelSobrenome = new JLabel("Sobrenome:");
		labelSobrenome.setFont(new Font("Arial", Font.BOLD, 22));
		labelSobrenome.setBounds(417, 165, 294, 30);
		frame.getContentPane().add(labelSobrenome);
		
		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setFont(new Font("Arial", Font.BOLD, 22));
		labelIdade.setBounds(417, 250, 294, 30);
		frame.getContentPane().add(labelIdade);
		
		//Criação do Botão para Cadastrar novos usuários
		JButton botaoCadastrar = new JButton("CADASTRAR");
		botaoCadastrar.addActionListener(new ActionListener() {
			
			//Método para executar a ação
			public void actionPerformed(ActionEvent e) {
				
				//Criação do Objeto para Realizar o Cadastro
				Cadastrar cadastro = new Cadastrar();
				
				//Função para tentar inserir dados dentro do Bando de Dados
				try {
					//Caso o método "cadastrar" seja verdadeiro, será fechada a janela atual e abrirá a próxima
					if(cadastro.cadastrar(entradaNovoUser, entradaNovaSenha, entradaNome, entradaSobrenome, entradaIdade, entradaCPF)) {
						
						//Mensagem de texto para confirmar que o cadastro foi efetuado
						JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO!");
						
						//Método para fechar a Janela Atual
						frame.dispose();
						
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
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		botaoCadastrar.setForeground(Color.BLACK);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoCadastrar.setBounds(233, 357, 276, 44);
		frame.getContentPane().add(botaoCadastrar);
		
		frame.getRootPane().setDefaultButton(botaoCadastrar);

		//Criação do Botão para retornar a Janela do Administrador
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.addActionListener(new ActionListener() {

			//Método para retonar para a Janela do Administrador
			public void actionPerformed(ActionEvent e) {

				//Função para fechar a Janela Atual
				frame.dispose();

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