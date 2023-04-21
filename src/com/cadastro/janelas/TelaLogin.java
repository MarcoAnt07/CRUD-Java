//Classe para a Crição da Janela de Login
package com.cadastro.janelas;

//Importação das bibliotecas necessárias
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cadastro.metodos.Login;

public class TelaLogin {

	private JFrame frame;
	private JTextField entradaUsuario;
	private JPasswordField entradaSenha;

	//Declaração do Método Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Declaração do Método para executar o método para inicializar a Janela de Login
	public TelaLogin() {
		initialize();
	}

	//Declaração do Método para inicializar a Janela
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 763, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Entrada do Username do usuário para Realizar o Login
		entradaUsuario = new JTextField();
		entradaUsuario.setToolTipText("");
		entradaUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaUsuario.setBounds(240, 132, 294, 49);
		frame.getContentPane().add(entradaUsuario);
		entradaUsuario.setColumns(10);
		
		//Entrada da Senha do usuário para Realizar o Login
		entradaSenha = new JPasswordField();
		entradaSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		entradaSenha.setBounds(240, 256, 294, 49);
		frame.getContentPane().add(entradaSenha);
		
		//Criação do Botão para Realizar o Login
		JButton botaoEntrar = new JButton("ENTRAR");
		botaoEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Criação do Objeto para Realização do Login
				Login entrar = new Login();
				
				//Caso a função "realizarLogin" seja verdadeira, será fechada a janela atual e abrirá a próxima
				if(entrar.realizarLogin(entradaUsuario, entradaSenha)) {
					frame.dispose();
				}
				
				//Caso o método "realizarLogin" seja falsa, será exibida a mensagem de usuário e/ou senha incorreto(s)
				else {
					JOptionPane.showMessageDialog(null, "USUÁRIO E/OU SENHA INCORRETO(S)");
				}
			}
		});
		botaoEntrar.setFont(new Font("Arial", Font.BOLD, 22));
		botaoEntrar.setBounds(307, 331, 167, 49);
		frame.getContentPane().add(botaoEntrar);
		
		JLabel labelUser = new JLabel("Usuário");
		labelUser.setFont(new Font("Arial", Font.BOLD, 22));
		labelUser.setBounds(240, 85, 294, 36);
		frame.getContentPane().add(labelUser);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Arial", Font.BOLD, 22));
		labelSenha.setBounds(240, 209, 294, 36);
		frame.getContentPane().add(labelSenha);
		
		JCheckBox checkBoxExibirSenha = new JCheckBox("Exibir Senha");
		checkBoxExibirSenha.setSelected(false);
		checkBoxExibirSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		checkBoxExibirSenha.setBounds(571, 272, 97, 23);
		frame.getContentPane().add(checkBoxExibirSenha);
		
		frame.getRootPane().setDefaultButton(botaoEntrar);
		
		//Criação do Check Box para exibir ou não a senha digitada
		checkBoxExibirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Caso o Check Box esteja marcado, será exibida a senha
				if(checkBoxExibirSenha.isSelected() == true) {
					entradaSenha.setEchoChar((char) 0);
				}
				
				//Caso o Check Box não esteja marcado, os caracteres serão substituídos pelo caracter especial '●'
				else {
					entradaSenha.setEchoChar('●');
				}
		}
		
		});
	}
}