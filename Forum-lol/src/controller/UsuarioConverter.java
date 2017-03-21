package controller;

import java.sql.SQLException;

import org.springframework.core.convert.converter.Converter;

import model.Usuario;
import model.UsuarioDao;

public class UsuarioConverter implements Converter<String,Usuario> {
	
	public Usuario convert(String id){
		
		UsuarioDao dao = null;
		try {
			dao = new UsuarioDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.buscarPorId(Integer.valueOf(id));
	}
}
