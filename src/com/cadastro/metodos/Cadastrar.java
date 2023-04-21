//Criação da Classe para realizar o Cadastro de novos usuários no Banco de Dados
package com.cadastro.metodos;

//Bibliotecas necessárias
import java.sql.*;
import javax.swing.*;

public class Cadastrar {
	//Objeto para realizar a Conexão com o Banco de Dados
	Banco bd = new Banco();
	
	//Método booleano para realizar o Cadastro de novos usuários no Banco de Dados
	public boolean cadastrar(JTextField user, JPasswordField pass, JTextField nome, JTextField sobrenome, JTextField idade, JTextField cpf) throws SQLException {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;

		//Variável booleana que será alterada se o cadastro for realizado com êxito
		boolean cadastrado = false;
		
		//Função para tentar realizar um novo cadastro no Banco de Dados
		try {
			//Variável com o username do novo usuário
			String usuario = user.getText();

			//Variável com a senha do novo usuário
			String senha = new String(pass.getPassword());

			//Variável com o nome do novo usuário
			String Nome = nome.getText();

			//Variável com o sobrenome do novo usuário
			String sobreNome = sobrenome.getText();

			//Variável com a idade do novo usuário
			String Idade = idade.getText();

			//Variável com o CPF do novo usuário
			String CPF = cpf.getText();
			
			//Variável contendo a instrução SQL necessária
			String sql = "insert into usuarios (username, password, nome, sobrenome, idade, CPF) values (?, ?, ?, ?, ?, ?)";
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);
			
			//Função para setar o username do novo usúario na instrução SQL
			declaracaoPronta.setString(1, usuario);

			//Função para setar a senha do novo usúario na instrução SQL
			declaracaoPronta.setString(2, senha);

			//Função para setar o nome do novo usúario na instrução SQL
			declaracaoPronta.setString(3, Nome);

			//Função para setar o sobrenome do novo usúario na instrução SQL
			declaracaoPronta.setString(4, sobreNome);

			//Função para setar a idade do novo usúario na instrução SQL
			declaracaoPronta.setString(5, Idade);

			//Função para setar o CPF do novo usúario na instrução SQL
			declaracaoPronta.setString(6, CPF);
			
			//Função para executar o Cadastro no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			
			//Alteração do valor da variável devido ao cadastro ter sido executado com êxito
			cadastrado = true;
		}
		//Caso não seja possível realizar um novo cadastro, será mostrada uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não seja possível cadastrar um novo usuário
			JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CADASTRAR UM NOVO USUÁRIO");
		}

		//Retono para verificar se o cadastro foi realizado com êxito
		return cadastrado;	
	}
}