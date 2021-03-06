package br.com.alura.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		String nome = "";
		String descricao = "";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperaConexao();) {
			connection.setAutoCommit(false);
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);) {
				adicionaVariavel("SmartTV", "Televis?o Smart de 90Polegadas", stm);
				adicionaVariavel("Radio", "Radio de Bateria", stm);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionaVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("N?o foi possivel adicionar o Produto");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys();) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O valor do novo id ? " + id);
			}
		}
	}
}
