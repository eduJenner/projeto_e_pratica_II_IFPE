package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;

public class PostDao {
	private Connection connection;

	public PostDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Post post) {
		try {
			String sql = "insert into post (criadorDoPost,topicoDoPost,conteudo) values (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, post.getUsuario().getId());
			stmt.setInt(2, post.getTopico().getId());
			stmt.setString(3, post.getConteudo());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}
}