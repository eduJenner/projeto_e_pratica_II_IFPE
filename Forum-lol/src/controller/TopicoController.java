package controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Topico;
import model.TopicoDao;

@Controller
public class TopicoController {
	
	@RequestMapping("/novoTopico")
	public String form() {
		return "topico/formulario";
	}
	
	@RequestMapping("/criarTopico")
	public String criarTopico(Topico topico,Model model) throws SQLException {

		TopicoDao dao = new TopicoDao();
		dao.adiciona(topico);
		model.addAttribute("msg", "topico criado com sucesso!");
		return "topico/formulario";
	}
}
