package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import util.ConnectionFactory;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into usuarios"
				+ "(nome,sobrenome,email,confirmarEmail,dataNasc,senha,confirmarSenha,nomeUsuario)"
				+ " values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getConfirmarEmail());
			stmt.setDate(5, new Date(usuario.getDataNasc().getTimeInMillis()));
			stmt.setString(6, usuario.getSenha());
			stmt.setString(7, usuario.getConfirmarSenha());
			stmt.setString(8, usuario.getNomeUsuario());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public Usuario buscarPorId(Long id) {
		Usuario usuario = null;
		try {
			String sql = "select * from usuarios where id =?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				usuario = new Usuario();

				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setConfirmarEmail(rs.getString("confirmarEmail"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setConfirmarSenha(rs.getString("confirmarSenha"));
				usuario.setNomeUsuario(rs.getString("nomeUsuario"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNasc"));
				usuario.setDataNasc(data);

			}
			rs.close();
			stmt.close();

			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Usuario usuario) {
		String sql = "update usuarios set nome=?,sobrenome=?, email=?, confirmarEmail=? , dataNasc=? , senha=? , confirmarSenha=? , nomeUsuario=?"
				+ " where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getConfirmarEmail());
			stmt.setDate(5, new Date(usuario.getDataNasc().getTimeInMillis()));
			stmt.setString(6, usuario.getSenha());
			stmt.setString(7, usuario.getConfirmarSenha());
			stmt.setString(8, usuario.getNomeUsuario());
			stmt.setLong(9, usuario.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
