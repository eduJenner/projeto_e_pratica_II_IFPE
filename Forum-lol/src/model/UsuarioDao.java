package model;

import java.sql.Connection;
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
		try {
			String sql = "insert into usuario (nome,email,login,senha,dataNascimento,imagem) values (?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stmt.setString(6, usuario.getImagem());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public void alterar(Usuario usuario) {

		try {
			String sql = "UPDATE usuario SET nome = ?, email = ?, login = ?, senha = ?, dataNascimento = ? WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
			stmt.setInt(6, usuario.getId());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscarPorId(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				usuario.setImagem(rs.getString("imagem"));

			}

			rs.close();
			stmt.close();
			connection.close();

			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listar() {

		try {
			List<Usuario> listaUsuario = new ArrayList<Usuario>();

			String sql = "SELECT * FROM usuario";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Usuario usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				usuario.setImagem(rs.getString("imagem"));

				listaUsuario.add(usuario);
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
			String sql = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscarLogin(String login) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE login = ?");
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				usuario.setImagem(rs.getString("imagem"));

			}

			rs.close();
			stmt.close();
			connection.close();

			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public Usuario buscarUsuario(Usuario usuario) {

		try {

			Usuario usuarioConsultado = null;
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usuario where login = ? and senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				usuarioConsultado = new Usuario();
				usuarioConsultado.setId(rs.getInt("id"));
				usuarioConsultado.setNome(rs.getString("nome"));
				usuarioConsultado.setEmail(rs.getString("email"));
				usuarioConsultado.setLogin(rs.getString("login"));
				usuarioConsultado.setSenha(rs.getString("senha"));
				usuarioConsultado.setDataNascimento(rs.getDate("dataNascimento"));
				usuarioConsultado.setImagem(rs.getString("imagem"));
			}

			rs.close();
			stmt.close();

			return usuarioConsultado;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
