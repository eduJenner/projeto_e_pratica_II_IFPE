package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Categoria;
import model.Topico;
import model.TopicoDao;
import model.Usuario;
import model.UsuarioDao;

@Controller
public class TopicoController {

	@RequestMapping("/novoTopico")
	public String form(Usuario usuario, Categoria categoria, HttpSession session, Model model) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);

		}
		return "topico/formulario";
	}

	@RequestMapping("/criarTopico")
	public String criarTopico(Topico topico, Model model) throws SQLException {

		
		TopicoDao dao1 = new TopicoDao();
		dao1.adiciona(topico);
		model.addAttribute("msg", "topico criado com sucesso!");
		return "topico/formulario";
	}
	
	@RequestMapping("/listarTopico")
	public String listarTopico(Model model) throws SQLException{
		TopicoDao dao = new TopicoDao();
		List<Topico> listaTopico = dao.listar();
		model.addAttribute("listaTopico", listaTopico);
		return"topico/pesquisarTopico";
	}
}
