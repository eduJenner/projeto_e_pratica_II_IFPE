package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Post;
import model.PostDao;
import model.Topico;
import model.Usuario;
import model.UsuarioDao;

@Controller
public class PostController {

	@RequestMapping("/novoPost")
	public String form(Usuario usuario, Topico topico, HttpSession session, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);
		}

		return "post/formulario";
	}

	@RequestMapping("/criarPost")
	public String criarPost(Post post, Model model) throws SQLException {

		PostDao dao1 = new PostDao();
		dao1.adiciona(post);
		model.addAttribute("msg", "post criado com sucesso!");
		return "post/formulario";
	}
}
