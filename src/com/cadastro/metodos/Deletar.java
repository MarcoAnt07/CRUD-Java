//Criação da Classe para Apgar usuários e todos os seus dados do Banco de Dados
package com.cadastro.metodos;

//Bibliotecas necessárias
import java.sql.*;
import javax.swing.*;

public class Deletar {
	//Objeto para realizar a Conexão com o Banco de Dados
	Banco bd = new Banco();
	
	//Método para Apagar usuários do Banco de Dados
	public void ApagarDados(JTextField user) {
		//Variável para realizar a Conexão com o Banco de Dados
		Connection con = bd.conectar();

		//Variável necessário para armazenar a instrução SQL
		PreparedStatement declaracaoPronta;

		//Variável necessária para executar o Update no Banco de Dados
		int executar;
		
		//Função para tentar Apagar os dados do usuário especificado
		try {
			//Variável com o username do usuário que terá os dados apagados
			String username = user.getText();
			
			//Variável contendo a instrução SQL necessária
			String sql = "delete from usuarios where username = ?";
			
			//Criação do objeto que contém a instrução SQL
			declaracaoPronta = con.prepareStatement(sql);

			//Função para setar o username do usuário que será apagado na instrução SQL
			declaracaoPronta.setString(1, username);
			
			//Função para executar a Atualização no Banco de Dados
			executar = declaracaoPronta.executeUpdate();
			
			//Caixa de texto que será mostrada quando a operção for concluida com êxito
			JOptionPane.showMessageDialog(null, "USUÁRIO APAGADO COM SUCESSO!");
		} 
		//Caso não seja possível apagar o usuário, será mostrada uma Caixa de Texto
		catch (Exception e) {
			//Caixa de texto que será mostrada caso não seja possível apagar os dados
			JOptionPane.showMessageDialog(null, "Não foi possível apagar os dados do usuário");
		}
	}
}