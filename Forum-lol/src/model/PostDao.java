package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Post> listar() {

		try {
			List<Post> listaPost = new ArrayList<Post>();

			String sql = "SELECT * FROM post";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Post post = new Post();

				post.setId(rs.getInt("id"));
				post.setConteudo(rs.getString("conteudo"));
				post.setData(rs.getDate("data"));

				UsuarioDao dao = new UsuarioDao();
				Usuario usuario = dao.buscarPorId(rs.getInt("criadorDoPost"));
				post.setUsuario(usuario);

				TopicoDao dao2 = new TopicoDao();
				Topico topico = dao2.buscarPorId(rs.getInt("topicoDoPost"));
				post.setTopico(topico);

				listaPost.add(post);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaPost;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Post buscarPorId(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM post WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Post post = null;

			if (rs.next()) {
				post = new Post();

				post.setId(rs.getInt("id"));
				post.setConteudo(rs.getString("conteudo"));
				post.setData(rs.getDate("data"));

				UsuarioDao dao = new UsuarioDao();
				Usuario usuario = dao.buscarPorId(rs.getInt("criadorDoPost"));
				post.setUsuario(usuario);

				TopicoDao dao2 = new TopicoDao();
				Topico topico = dao2.buscarPorId(rs.getInt("topicoDoPost"));
				post.setTopico(topico);
			}

			rs.close();
			stmt.close();
			connection.close();

			return post;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Post post) {

		try {
			String sql = "DELETE FROM post WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, post.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Post post) {
		try {
			String sql = "UPDATE post SET criadorDoPost = ?,topicoDoPost = ?,conteudo = ? WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, post.getUsuario().getId());
			stmt.setInt(2, post.getTopico().getId());
			stmt.setString(3, post.getConteudo());
			stmt.setInt(4, post.getId());
			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
