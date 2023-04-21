//Classe para Criação da Janela de Atualização de Dados
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.cadastro.metodos.Atualizar;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizar {

	JFrame frame;
	private JTextField entradaBuscarUser;
	private JPasswordField entradaAtualizarSenha;
	private JTextField entradaAtualizarUser;
	private JTextField entradaAtualizarNome;
	private JButton btnAtualizarUsurio;
	private JButton btnAtualizarSenha;
	private JButton btnAtualizarNome;
	private JButton btnAtualizarTudo;
	private JLabel lblDigiteAIdade;
	private JTextField entradaAtualizarIdade;
	private JButton btnAtualizarIdade;
	private JButton botaoVoltar;
	private JTextField entradaAtualizarSobrenome;
	private JTextField entradaAtualizarCPF;

	//Declaração do Método para executar o método para inicializar a Janela de Atualizar Dados dos Usuários
	public TelaAtualizar() {
		initialize();
	}

	//Declaração do Método para inicializar a Janela
	private void initialize() {
		//Criação do objeto para realizar as Atualizações na tabela Usuários no Banco de Dados
		Atualizar update = new Atualizar();
		
		//Criação da Janela
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 915, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Entrada de dados para procurar o usuário que será realizada as alterações
		entradaBuscarUser = new JTextField();
		entradaBuscarUser.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaBuscarUser.setColumns(10);
		entradaBuscarUser.setBounds(10, 65, 288, 30);
		frame.getContentPane().add(entradaBuscarUser);
		
		JLabel labelUserUpdate = new JLabel("Digite o Usuário que deseja atualizar:");
		labelUserUpdate.setFont(new Font("Arial", Font.BOLD, 22));
		labelUserUpdate.setBounds(10, 24, 401, 30);
		frame.getContentPane().add(labelUserUpdate);
		
		//Entrada para Atualização da Senha do usuário
		entradaAtualizarSenha = new JPasswordField();
		entradaAtualizarSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaAtualizarSenha.setBounds(323, 168, 288, 30);
		frame.getContentPane().add(entradaAtualizarSenha);
		
		JLabel labelAtualizarUser = new JLabel("Digite o Usuário atualizado:");
		labelAtualizarUser.setFont(new Font("Arial", Font.BOLD, 22));
		labelAtualizarUser.setBounds(10, 127, 278, 30);
		frame.getContentPane().add(labelAtualizarUser);
		
		//Entrada para a Atualização do Username do usuário
		entradaAtualizarUser = new JTextField();
		entradaAtualizarUser.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaAtualizarUser.setColumns(10);
		entradaAtualizarUser.setBounds(10, 168, 288, 30);
		frame.getContentPane().add(entradaAtualizarUser);
		
		JLabel labelAtualizarSenha = new JLabel("Digite a Senha atualizada:");
		labelAtualizarSenha.setFont(new Font("Arial", Font.BOLD, 22));
		labelAtualizarSenha.setBounds(323, 127, 268, 30);
		frame.getContentPane().add(labelAtualizarSenha);
		
		//Entrada para Atulização do Nome do usuário
		entradaAtualizarNome = new JTextField();
		entradaAtualizarNome.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaAtualizarNome.setColumns(10);
		entradaAtualizarNome.setBounds(10, 272, 288, 30);
		frame.getContentPane().add(entradaAtualizarNome);
		
		JLabel labelAtualizarNome = new JLabel("Digite o Nome atualizado:");
		labelAtualizarNome.setFont(new Font("Arial", Font.BOLD, 22));
		labelAtualizarNome.setBounds(10, 231, 268, 30);
		frame.getContentPane().add(labelAtualizarNome);
		
		//Botão para Realizar a Atualização do Username do usuário
		btnAtualizarUsurio = new JButton("ATUALIZAR USUÁRIO");
		btnAtualizarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarUser(entradaBuscarUser, entradaAtualizarUser);
			}
		});
		btnAtualizarUsurio.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizarUsurio.setBounds(654, 46, 235, 30);
		frame.getContentPane().add(btnAtualizarUsurio);
		
		//Botão para Realizar a Atualização da Senha do usuário
		btnAtualizarSenha = new JButton("ATUALIZAR SENHA");
		btnAtualizarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarSenha(entradaBuscarUser, entradaAtualizarSenha);
			}
		});
		btnAtualizarSenha.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizarSenha.setBounds(654, 87, 235, 30);
		frame.getContentPane().add(btnAtualizarSenha);
		
		//Botão para Realizar a Atualização do Nome do usuário
		btnAtualizarNome = new JButton("ATUALIZAR NOME");
		btnAtualizarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarNome(entradaBuscarUser, entradaAtualizarNome);
			}
		});
		btnAtualizarNome.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizarNome.setBounds(654, 128, 235, 30);
		frame.getContentPane().add(btnAtualizarNome);
		
		lblDigiteAIdade = new JLabel("Digite a Idade atualizada:");
		lblDigiteAIdade.setFont(new Font("Arial", Font.BOLD, 22));
		lblDigiteAIdade.setBounds(10, 336, 268, 30);
		frame.getContentPane().add(lblDigiteAIdade);
		
		//Entrada para Atualização da Idade do usuário
		entradaAtualizarIdade = new JTextField();
		entradaAtualizarIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaAtualizarIdade.setColumns(10);
		entradaAtualizarIdade.setBounds(10, 377, 288, 30);
		frame.getContentPane().add(entradaAtualizarIdade);
		
		//Botão para Realizar a Atualização da Idade do usuário
		btnAtualizarIdade = new JButton("ATUALIZAR IDADE");
		btnAtualizarIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarIdade(entradaBuscarUser, entradaAtualizarIdade);
			}
		});
		btnAtualizarIdade.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizarIdade.setBounds(654, 209, 235, 30);
		frame.getContentPane().add(btnAtualizarIdade);
		
		//Botão para Realizar todas as Atualizações dos Dados do usuário
		btnAtualizarTudo = new JButton("ATUALIZAR TUDO");
		btnAtualizarTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarTudo(entradaBuscarUser, entradaAtualizarUser, entradaAtualizarSenha, entradaAtualizarNome, entradaAtualizarSobrenome, entradaAtualizarIdade, entradaAtualizarCPF);
			}
		});
		btnAtualizarTudo.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizarTudo.setBounds(654, 300, 235, 30);
		frame.getContentPane().add(btnAtualizarTudo);
		
		//Botão para Retornar a Tela Inicial
		botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
		botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
		botaoVoltar.setBounds(723, 429, 166, 30);
		frame.getContentPane().add(botaoVoltar);
		
		JLabel labelAtualizarSobrenome = new JLabel("Digite o Sobrenome atualizado:");
		labelAtualizarSobrenome.setFont(new Font("Arial", Font.BOLD, 22));
		labelAtualizarSobrenome.setBounds(323, 231, 317, 30);
		frame.getContentPane().add(labelAtualizarSobrenome);
		
		//Entrada para Atualização do Sobrenome do usuário
		entradaAtualizarSobrenome = new JTextField();
		entradaAtualizarSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaAtualizarSobrenome.setColumns(10);
		entradaAtualizarSobrenome.setBounds(323, 272, 288, 30);
		frame.getContentPane().add(entradaAtualizarSobrenome);
		
		JButton btnAtualizarSobrenome = new JButton("ATUALIZAR SOBRENOME");
		btnAtualizarSobrenome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarSobrenome(entradaBuscarUser, entradaAtualizarSobrenome);
			}
		});
		btnAtualizarSobrenome.setFont(new Font("Arial", Font.BOLD, 16));
		btnAtualizarSobrenome.setBounds(654, 169, 235, 30);
		frame.getContentPane().add(btnAtualizarSobrenome);
		
		JButton botaoAtualizarCPF = new JButton("ATUALIZAR CPF");
		botaoAtualizarCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.AtualizarCPF(entradaBuscarUser, entradaAtualizarCPF);
			}
		});
		botaoAtualizarCPF.setFont(new Font("Arial", Font.BOLD, 16));
		botaoAtualizarCPF.setBounds(654, 250, 235, 30);
		frame.getContentPane().add(botaoAtualizarCPF);
		
		JLabel labelAtualizarCPF = new JLabel("Digite o CPF atualizado:");
		labelAtualizarCPF.setFont(new Font("Arial", Font.BOLD, 22));
		labelAtualizarCPF.setBounds(323, 336, 268, 30);
		frame.getContentPane().add(labelAtualizarCPF);
		
		//Entrada para Atualização do CPF do usuário
		entradaAtualizarCPF = new JTextField();
		entradaAtualizarCPF.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaAtualizarCPF.setColumns(10);
		entradaAtualizarCPF.setBounds(323, 377, 288, 30);
		frame.getContentPane().add(entradaAtualizarCPF);

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