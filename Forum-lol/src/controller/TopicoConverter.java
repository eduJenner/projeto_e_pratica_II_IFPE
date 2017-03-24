package controller;

import java.sql.SQLException;

import org.springframework.core.convert.converter.Converter;

import model.Topico;
import model.TopicoDao;

public class TopicoConverter implements Converter<String,Topico>{
	public Topico convert(String id){
		TopicoDao dao = null;
		try {
			dao = new TopicoDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.buscarPorId(Integer.valueOf(id));
	}
}
