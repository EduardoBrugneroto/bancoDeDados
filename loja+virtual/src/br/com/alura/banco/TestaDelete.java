package br.com.alura.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestaDelete {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperaConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		
		stm.setInt(1, 2);
		
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("A quantidade de linhas modfcadas foram de " + linhasModificadas);
	}
}
