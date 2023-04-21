//Criação da Classe para relizar o Login no Banco de Dados
package com.cadastro.metodos;

//Bibliotecas necessárias
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import com.cadastro.janelas.TelaADM;
import com.cadastro.janelas.TelaInformacoes;

public class Login {
	//Objeto para realizar a Conexão com o Banco de Dados
	Banco bd = new Banco();
	
	//Método booleano para Realizar o Login no Banco de Dados
	public boolean realizarLogin(JTextField user, JPasswordField pass) {
		//Variável booleana que será alterada se o login for realizado com êxito
		boolean logado = false;
		
		//Variável necessária para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável para armazenar os resultados da Consulta realizada
		ResultSet resultado;

		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();
		
		//Função para tentar realizar o login no Banco de Dados
		try {
			//Variável com o username do usuário que deseja realizar login
			String username = user.getText();

			//Variável com a senha do usuário que deseja realizar login
			String password = new String(pass.getPassword());
			
			//Variável contendo a instrução SQL necessária
			String sql = "select * from usuarios where username = ? and password = ?";
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);
			
			//Função para setar o username do usuário que realizará login na instrução SQL
			declaracaoPronta.setString(1, username);

			//Função para setar a senha do usuário que realizará login na instrução SQL
			declaracaoPronta.setString(2, password);
			
			//Função para realizar a consulta no Banco de Dados
			resultado = declaracaoPronta.executeQuery();
			
			//Função para verificar se o usuário está presente no Bnaco de Dados
			if(resultado.next()) {

				//Caso o usuário esteja presente no Banco de Dados, a variável receberá o valor verdadeiro
				logado = true;
				
				//Função para determinar qual janela o usuário terá acesso
				switch(username) {

				//Caso o usuário seja o administrador, será encaminhado para a janela do administrador
				case "adm":
					
					//Método para encaminhar para a Janela do Administrador
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
					break;

				//Caso o usuário não seja o administrador, será encaminhado para janela que contém as suas informações
				default:

					//Método para encaminhar a janela contendo as informações do usuário
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								TelaInformacoes frame = new TelaInformacoes(user);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
			}
		}catch (Exception e) {}

		//Retono da variável com a confirmação do login no Banco de Dados
		return logado;
	}
}