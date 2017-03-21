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
			String sql = "insert into topico (titulo,criadorDoTopico,categoriaDoTopico,conteudo) values (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, topico.getTitulo());
			stmt.setInt(2,topico.getUsuario().getId());
			stmt.setInt(3, topico.getCategoria().getId());
			stmt.setString(4, topico.getConteudo());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}
