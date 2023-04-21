package com.cadastro.metodos;

//Biblioteca necessária
import java.sql.*;

public class Banco {
	//Variável necessária para realizar a conexão com o Banco de Dados
	Connection conexao = null;

	//Método que retorna a conexão com o Banco de Dados
	public Connection conectar() {

		//Função para tentar realizar a conexão com o Banco de Dados
		try {
			//Função reponsável por inicializar o driver de conexão do MySQL
			Class.forName("com.mysql.jdbc.Driver");
			
			//Variável responsável por armazenar a refência para a conexão estabelecida com o Banco de Dados
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/cadastro", "root", "");
		} 

		//Caso não seja possível realizar a conxão com o Banco de Dados, será printada a mensagem de erro
		catch (Exception e) {
			System.out.println("FALHA NA CONEXÃO");
		}
		
		//Retono da Conexão com o Banco de Dados
		return conexao;
	}
}