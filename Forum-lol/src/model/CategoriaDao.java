package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class CategoriaDao {

	private Connection connection;

	public CategoriaDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Categoria categoria) {
		try {
			String sql = "insert into categoria (titulo,descricao) values (?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, categoria.getTitulo());
			stmt.setString(2, categoria.getDescricao());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public List<Categoria> listar() {

		try {
			List<Categoria> listaCategoria = new ArrayList<Categoria>();

			String sql = "SELECT * FROM categoria";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria();

				categoria.setId(rs.getInt("id"));
				categoria.setTitulo(rs.getString("titulo"));
				categoria.setDescricao(rs.getString("descricao"));

				listaCategoria.add(categoria);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaCategoria;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Categoria categoria) {

		try {
			String sql = "UPDATE categoria SET titulo = ?, descricao = ? WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, categoria.getTitulo());
			stmt.setString(2, categoria.getDescricao());

			stmt.setInt(3, categoria.getId());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Categoria buscarPorId(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categoria WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Categoria categoria = null;

			if (rs.next()) {
				categoria = new Categoria();

				categoria.setId(rs.getInt("id"));
				categoria.setTitulo(rs.getString("titulo"));
				categoria.setDescricao(rs.getString("descricao"));

			}

			rs.close();
			stmt.close();
			connection.close();

			return categoria;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remover(Categoria categoria) {

		try {
			String sql = "DELETE FROM categoria WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, categoria.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
