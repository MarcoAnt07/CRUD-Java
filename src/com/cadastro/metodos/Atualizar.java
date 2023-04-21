//Criação da Classe com o Método para Atualizar os Dados dos Usuários no Banco de Dados
package com.cadastro.metodos;

//Bibliotecas necessárias
import java.sql.*;
import javax.swing.*;

public class Atualizar {
	//Objeto para realizar a Conexão com o Banco de Dados
	Banco bd = new Banco();
	
	//Método para Atualização de Todos os Dados do Usuário
	public void AtualizarTudo(JTextField username, JTextField user, JPasswordField pass, JTextField nome, JTextField sobrenome, JTextField idade, JTextField cpf) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar executar a Atualização
		try {
			//Variável contendo a instrução SQL necessária
			String sql = "update usuarios set username = ?, password = ?, nome = ?, sobrenome = ?, idade = ?, cpf = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String UserName = username.getText();

			//Variável com o novo username do usuário
			String NovoUser = user.getText();

			//Variável com a nova senha do usuário
			String NovoPass = new String(pass.getPassword());

			//Variável com o novo nome do usuário
			String NovoNome = nome.getText();

			//Variável com o novo sobrenome do usuário
			String NovoSobrenome = sobrenome.getText();

			//Variável com a nova idade do usuário
			String NovaIdade = idade.getText();

			//Variável com o novo CPF do usuário
			String NovoCPF = cpf.getText();
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar o novo username na instrução SQL
			declaracaoPronta.setString(1, NovoUser);

			//Função para setar a nova senha na instrução SQL
			declaracaoPronta.setString(2, NovoPass);

			//Função para setar o nome atualizado na instrução SQL
			declaracaoPronta.setString(3, NovoNome);

			//Função para setar o sobrenome atualizado na instrução SQL
			declaracaoPronta.setString(4, NovoSobrenome);

			//Função para setar a idade atualizada na instrução SQL
			declaracaoPronta.setString(5, NovaIdade);

			//Função para setar o CPF atualizado na instrução SQL
			declaracaoPronta.setString(6, NovoCPF);

			//Função para setar o username antes da Atualização na instrução SQL
			declaracaoPronta.setString(7, UserName);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			
		} 
		//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não seja possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização de Dados");
		}		
	}

	//Método para Atualização da Senha do Usuário
	public void AtualizarSenha(JTextField user, JPasswordField pass) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar executar a Atualização
		try {
			//Variável contendo a instrução SQL necessária
			String sql = "update usuarios set password = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String username = user.getText();

			//Variável com a nova senha do usuário
			String password = new String(pass.getPassword());
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar a nova senha na instrução SQL
			declaracaoPronta.setString(1, password);

			//Função para setar o username atual na instrução SQL
			declaracaoPronta.setString(2, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			} 
			//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não fosse possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização da Senha");
		}
	}

	//Método para Atualização do Username do Usuário
	public void AtualizarUser(JTextField user, JTextField NovoUser) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar executar a Atualização
		try {
			//Variável contendo a instrução SQL necessária
			String sql = "update usuarios set username = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String username = user.getText();

			//Função para setar o novo username na instrução SQL
			String novoUser = NovoUser.getText();
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar o novo username na instrução SQL
			declaracaoPronta.setString(1, novoUser);

			//Função para setar o username antes da Atualização na instrução SQL
			declaracaoPronta.setString(2, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
		}

		//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não fosse possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização do Username");
		}
	}

	//Método para Atualização do Nome do Usuário
	public void AtualizarNome(JTextField user, JTextField nome) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;
		
		//Variável necessária para executar o Update no Banco de Dados
		int executar;

		//Função para tentar executar a Atualização
		try {
			//Variável contendo a instrução SQL necessária
			String sql = "update usuarios set nome = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String username = user.getText();

			//Função para setar o nome atualizado na instrução SQL
			String novoNome = nome.getText();
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar o nome atualizado na instrução SQL
			declaracaoPronta.setString(1, novoNome);

			//Função para setar o username atual na instrução SQL
			declaracaoPronta.setString(2, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
		}

		//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não fosse possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização do Username");
		}
	}

	//Método para Atualização do Sobrenome do Usuário
	public void AtualizarSobrenome(JTextField user, JTextField sobrenome) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar executar a Atualização
		try {
			//Variável com o username do usuário que terá os dados atualizados
			String sql = "update usuarios set sobrenome = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String username = user.getText();

			//Função para setar o sobrenome atualizado na instrução SQL
			String novoSobrenome = sobrenome.getText();
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar o sobrenome atualizado na instrução SQL
			declaracaoPronta.setString(1, novoSobrenome);

			//Função para setar o username atual na instrução SQL
			declaracaoPronta.setString(2, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			} 
			
		//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não fosse possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização do Sobrenome");
		}
	}

	//Método para Atualização da Idade do Usuário
	public void AtualizarIdade(JTextField user, JTextField idade) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar executar a Atualização
		try {
			//Variável com o username do usuário que terá os dados atualizados
			String sql = "update usuarios set idade = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String username = user.getText();

			//Função para setar a idade atualizada na instrução SQL
			String novaIdade = idade.getText();
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar a idade atualizada na instrução SQL
			declaracaoPronta.setString(1, novaIdade);

			//Função para setar o username atual na instrução SQL
			declaracaoPronta.setString(2, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			} 
			
		//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não fosse possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização da Idade");
		}
	}

	//Método para Atualização do CPF do Usuário
	public void AtualizarCPF(JTextField user, JTextField cpf) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar executar a Atualização
		try {
			//Variável com o username do usuário que terá os dados atualizados
			String sql = "update usuarios set CPF = ? where username = ?";
			
			//Variável com o username do usuário que terá os dados atualizados
			String username = user.getText();

			//Função para setar o nome atualizado na instrução SQL
			String novoCPF = cpf.getText();
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar o CPF atualizada na instrução SQL
			declaracaoPronta.setString(1, novoCPF);

			//Função para setar o username atual na instrução SQL
			declaracaoPronta.setString(2, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			} 
			
		//Caso não seja possível realizar a Atualização, será mostrado uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não fosse possível realizar a Atualização
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a Atualização do CPF");
		}
	}
}