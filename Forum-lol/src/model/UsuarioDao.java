package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario"
				+ "(nome,email,login,senha,dataNascimento,imagem)"
				+ " values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, new Date(usuario.getDataNascimento().getTime()));
			stmt.setString(6, usuario.getImagem());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public void alterar(Usuario usuario) {
		try {
			String sql = "update usuario set nome = ?,email = ?,login = ?,senha = ?,dataNascimento = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, usuario.getDataNascimento());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Usuario> listar() {
		try {
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			String sql = "select * from usuario";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Usuario usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));

			}

			rs.close();
			stmt.close();
			connection.close();

			return listaUsuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Usuario usuario) {
		try {
			String sql = "delete from * usuario where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
