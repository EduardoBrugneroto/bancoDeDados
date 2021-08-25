package br.com.alura.banco;
import java.sql.Connection;
import java.sql.SQLException;




public class main {
	public static void main(String[] args) throws SQLException{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		
		System.out.println("Fechando conexão");
		
		connection.close();	
	}
}
