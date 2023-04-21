//Classe para a Criação da Janela para Apagar os Dados dos usuários
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.cadastro.metodos.Deletar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaApagar {

	JFrame frame;
	private JTextField entradaUserApagar;

	//Declaração do Método para executar o método para inicializar a Janela para Apagar Dados dos Usuários
	public TelaApagar() {
		initialize();
	}

	//Declaração do Método para inicializar a Janela
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 763, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelUserApagar = new JLabel("Digite o Usuário que deseja apagar:");
		labelUserApagar.setFont(new Font("Arial", Font.BOLD, 22));
		labelUserApagar.setBounds(194, 116, 367, 36);
		frame.getContentPane().add(labelUserApagar);
		
		//Entrada do username do usuário que deseja apagar
		entradaUserApagar = new JTextField();
		entradaUserApagar.setToolTipText("");
		entradaUserApagar.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaUserApagar.setColumns(10);
		entradaUserApagar.setBounds(232, 163, 294, 49);
		frame.getContentPane().add(entradaUserApagar);
		
		//Criação do Botão para executar o Método para Apagar os dados de um determinado usuário
		JButton botaoApagar = new JButton("APAGAR");
		botaoApagar.addActionListener(new ActionListener() {
			
			//Método para executar a ação
			public void actionPerformed(ActionEvent e) {
				
				//Janela de texto para obter a confirmação do usuário para executar o método
				int resp = JOptionPane.showConfirmDialog(null, "TEM CERTEZA?");
				
				//Caso a resposta seja "sim", será executado o método para apagar os dados do usuário digitado e irá retonar para a Janela do Administrador
				if(resp == JOptionPane.YES_OPTION) {
					Deletar apagar = new Deletar();
					apagar.ApagarDados(entradaUserApagar);
					
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
			}
		});
		botaoApagar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoApagar.setBounds(295, 245, 167, 49);
		frame.getContentPane().add(botaoApagar);
		
		frame.getRootPane().setDefaultButton(botaoApagar);

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