//Classe para a Criação da Janela para Mostrar os dados do próprio usuário
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cadastro.metodos.Banco;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TelaInformacoes extends JFrame {

	private JPanel contentPane;

	//Declaração do Método para iniciar a Janela com os dados do proprío usuário
	public TelaInformacoes(JTextField user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 763, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Arial", Font.BOLD, 22));
		labelNome.setBounds(10, 140, 294, 30);
		contentPane.add(labelNome);
		
		//Label para printar o nome do usuário
		JLabel labelPrintarNome = new JLabel();
		labelPrintarNome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarNome.setBounds(10, 181, 401, 30);
		contentPane.add(labelPrintarNome);
		
		JLabel labelUser = new JLabel("Usuário:");
		labelUser.setFont(new Font("Arial", Font.BOLD, 22));
		labelUser.setBounds(10, 58, 294, 30);
		contentPane.add(labelUser);
		
		//Label para printar o username do usuário
		JLabel labelPrintarUser = new JLabel();
		labelPrintarUser.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarUser.setBounds(10, 99, 401, 30);
		contentPane.add(labelPrintarUser);
		
		JLabel labelSobrenome = new JLabel("Sobrenome:");
		labelSobrenome.setFont(new Font("Arial", Font.BOLD, 22));
		labelSobrenome.setBounds(10, 222, 294, 30);
		contentPane.add(labelSobrenome);
		
		//Label para printar o sobrenome do usuário
		JLabel labelPrintarSobrenome = new JLabel();
		labelPrintarSobrenome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarSobrenome.setBounds(10, 263, 401, 30);
		contentPane.add(labelPrintarSobrenome);
		
		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setFont(new Font("Arial", Font.BOLD, 22));
		labelIdade.setBounds(10, 304, 294, 30);
		contentPane.add(labelIdade);
		
		//Label para printar a idade do usuário
		JLabel labelPrintarIdade = new JLabel();
		labelPrintarIdade.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPrintarIdade.setBounds(10, 345, 401, 30);
		contentPane.add(labelPrintarIdade);
		
		//Declaração do objeto para Realizar a Conexão com o Banco de Dados
		Banco bd = new Banco();
		
		//Variável para realizar a Consulta dentro do Banco de Dados
		Statement declaracao;
		
		//Variável para armazenar os resultados da Consulta realizada
		ResultSet resultado;
		
		//Variáveis para armazenar os dados da consulta realizada
		String usuario;
		String nome;
		String sobrenome;
		String idade;
		
		//Função para tentar realizar a consulta dentro do Bando de Dados
		try {
			//Função para tentar realizar a consulta dentro do Bando de Dados
			Connection con = bd.conectar();
			
			declaracao = con.createStatement();
			
			//Consulta que será realizada no Banco de Dados
			resultado = declaracao.executeQuery("select * from usuarios where username = '" + user.getText() + "'");
			
			//Função para buscar os dados dentro do Banco de Dados
			if(resultado.next()) {
				
				//Função para armazenar o username do usuário dentro da variável "usuario"
				usuario = resultado.getString("username");
				
				//Função para armazenar o nome do usuário dentro da variável "nome"
				nome = resultado.getString("nome");
				
				//Função para armazenar o sobrenome do usuário dentro da variável "sobrenome"
				sobrenome = resultado.getString("sobrenome");
				
				//Função para armazenar a idade do usuário dentro da variável "idade"
				idade = resultado.getString("idade");
				
				//Função para o Label pritar o dado que está armazenado na variável "usuario"
				labelPrintarUser.setText(usuario);
				
				//Função para o Label pritar o dado que está armazenado na variável "nome"
				labelPrintarNome.setText(nome);
				
				//Função para o Label pritar o dado que está armazenado na variável "sobrenome"
				labelPrintarSobrenome.setText(sobrenome);
				
				//Função para o Label pritar o dado que está armazenado na variável "idade"
				labelPrintarIdade.setText(idade);
			}
		} catch(Exception e) {}
	}
}