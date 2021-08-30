package br.com.alura.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;

public class TestaInsecaoELstagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Iphone", "Iphone 7 128gb");

		try (Connection connetion = new ConnectionFactory().recuperaConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connetion);
			produtoDao.salvar(produto);
			List<Produto>listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
		
	}

}
