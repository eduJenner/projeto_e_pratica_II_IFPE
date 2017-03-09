package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			String sql = "UPDATE usuario SET nome = ?, email = ?, login = ?, senha = ?, dataNascimento = ? WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, new Date(usuario.getDataNascimento().getTime()));
			stmt.setInt(6, usuario.getId());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
