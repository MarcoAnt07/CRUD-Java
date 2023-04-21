//Classe para a Criação da Janela do Administrador
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TelaADM {

	public JFrame frame;

	//Declaração do Método para executar o método para inicializar a Janela do Administrador
	public TelaADM() {
		initialize();
	}

	//Declaração do Método para inicializar a Janela
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 763, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Criação do Botão para acessar a Tela para Cadastrar novos usuários
		JButton botaoCadastrar = new JButton("CADASTRAR");
		botaoCadastrar.setForeground(Color.BLUE);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoCadastrar.addActionListener(new ActionListener() {
			//Método para definir a ação que o botão irá realizar
			public void actionPerformed(ActionEvent e) {
				
				//Método para fechar a janela atual
				frame.dispose();
				
				//Método para abrir a Tela de Cadastro de novos usuários
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaCadastrar window = new TelaCadastrar();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		botaoCadastrar.setBounds(231, 76, 276, 44);
		frame.getContentPane().add(botaoCadastrar);
		
		//Criação do Botão para acessar a Tela para Consultar os dados dos usuários cadastrados
		JButton botaoConsultar = new JButton("CONSULTAR");
		botaoConsultar.addActionListener(new ActionListener() {
			//Método para definir a ação que o botão irá realizar
			public void actionPerformed(ActionEvent e) {
				
				//Método para fechar a janela atual
				frame.dispose();
				
				//Método para abrir a Tela para Consultar os dados dos usuários
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaConsultar frame = new TelaConsultar();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		botaoConsultar.setForeground(Color.ORANGE);
		botaoConsultar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoConsultar.setBounds(231, 157, 276, 44);
		frame.getContentPane().add(botaoConsultar);
		
		//Criação do Botão para acessar a Tela para Atualizar os dados dos usuários cadastrados
		JButton botaoAtualizar = new JButton("ATUALIZAR");
		botaoAtualizar.addActionListener(new ActionListener() {
			//Método para definir a ação que o botão irá realizar
			public void actionPerformed(ActionEvent e) {
				
				//Método para fechar a janela atual
				frame.dispose();
				
				//Método para abrir a Tela para Atualizar os dados dos usuários
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaAtualizar window = new TelaAtualizar();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		botaoAtualizar.setForeground(Color.GREEN);
		botaoAtualizar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoAtualizar.setBounds(231, 237, 276, 44);
		frame.getContentPane().add(botaoAtualizar);
		
		//Criação do Botão para acessar a Tela para Apagar os usuários do Banco de Dados
		JButton botaoApagar = new JButton("APAGAR");
		botaoApagar.addActionListener(new ActionListener() {
			//Método para definir a ação que o botão irá realizar
			public void actionPerformed(ActionEvent e) {
				
				//Método para fechar a janela atual
				frame.dispose();
				
				//Método para abrir a Tela para Apagar os usuários do Banco de Dados
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaApagar window = new TelaApagar();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		botaoApagar.setForeground(Color.RED);
		botaoApagar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoApagar.setBounds(231, 318, 276, 44);
		frame.getContentPane().add(botaoApagar);
	}
}