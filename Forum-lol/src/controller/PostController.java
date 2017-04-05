package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Post;
import model.PostDao;
import model.Topico;
import model.TopicoDao;
import model.Usuario;
import model.UsuarioDao;

@Controller
public class PostController {

	@RequestMapping("/novoPost")
	public String form(Usuario usuario, HttpSession session, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		
		TopicoDao dao2 = new TopicoDao();
		List<Topico> listaTopico = dao2.listar();
		model.addAttribute("listaTopico", listaTopico);
		
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

	@RequestMapping("/listarPost")
	public String listarPost(Model model) throws SQLException {

		PostDao dao = new PostDao();
		List<Post> listaPost = dao.listar();
		model.addAttribute("listaPost", listaPost);
		return "post/pesquisarPost";
	}

	@RequestMapping("/exibirAlterarPost")
	public String exibirAlterarPost(Usuario usuario,Post post,HttpSession session, Model model)
			throws SQLException {
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		
		TopicoDao dao2 = new TopicoDao();
		List<Topico> listaTopico = dao2.listar();
		model.addAttribute("listaTopico", listaTopico);
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);

		}

		PostDao dao3 = new PostDao();
		Post postCompleto = dao3.buscarPorId(post.getId());
		model.addAttribute("post", postCompleto);
		return "post/alterarPost";
	}
	@RequestMapping("/alterarPost")
	public String alterarPost(Post post, Model model) throws SQLException {

		PostDao dao = new PostDao();
		dao.alterar(post);
		model.addAttribute("msg", "Post alterado com sucesso !");

		return "forward:listarPost";
	}
	@RequestMapping("/removerPost")
	public String removerPost(Post post, Model model) throws SQLException {

		PostDao dao = new PostDao();
		dao.remover(post);
		model.addAttribute("msg", "post Removido com Sucesso!");
		return "forward:listarPost";
	}
}
