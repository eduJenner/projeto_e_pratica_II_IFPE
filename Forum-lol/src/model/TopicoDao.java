package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;

public class TopicoDao {
	private Connection connection;

	public TopicoDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Topico topico) {
		try {
			String sql = "insert into topico (titulo,conteudo,criadorDoTopico,categoriaDoTopico,dataCriacaoDoTopico,conteudo) values (?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, topico.getTitulo());
			stmt.setString(2, topico.getConteudo());
			stmt.setString(3, topico.getUsuario().getLogin());
			stmt.setInt(4, topico.getCategoria().getId());
			stmt.setDate(5, new java.sql.Date( topico.getDataCriacaoDoTopico().getTime()));
			
			stmt.setString(6, topico.getConteudo());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}
