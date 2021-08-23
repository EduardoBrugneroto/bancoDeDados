package br.com.alura.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testeListagem {
	public static void main(String[] args) throws SQLException{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		
		Statement stm =	connection.createStatement();	
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO" );
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()){
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String Nome = rst.getString("NOME");
			System.out.println(Nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
		
		
		
 }
}