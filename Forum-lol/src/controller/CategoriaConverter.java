package controller;

import java.sql.SQLException;

import org.springframework.core.convert.converter.Converter;

import model.Categoria;
import model.CategoriaDao;

public class CategoriaConverter implements Converter<String,Categoria> {
	public Categoria convert(String id){
		CategoriaDao dao = null;
		try {
			dao = new CategoriaDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.buscarPorId(Integer.valueOf(id));
	}
}
