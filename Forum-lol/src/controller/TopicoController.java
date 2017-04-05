package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Categoria;
import model.CategoriaDao;
import model.Topico;
import model.TopicoDao;
import model.Usuario;
import model.UsuarioDao;

@Controller
public class TopicoController {

	@RequestMapping("/novoTopico")
	public String form(Usuario usuario, HttpSession session, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		
		CategoriaDao dao2 = new CategoriaDao();
		List<Categoria> listaCategoria = dao2.listar();
		model.addAttribute("listaCategoria", listaCategoria);
		
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
	public String listarTopico(Model model) throws SQLException {

		TopicoDao dao = new TopicoDao();
		List<Topico> listaTopico = dao.listar();
		model.addAttribute("listaTopico", listaTopico);
		return "topico/pesquisarTopico";
	}

	@RequestMapping("/exibirAlterarTopico")
	public String exibirAlterarTopico(Usuario usuario, HttpSession session, Topico topico,
			Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		
		CategoriaDao dao2 = new CategoriaDao();
		List<Categoria> listaCategoria = dao2.listar();
		model.addAttribute("listaCategoria", listaCategoria);
		
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);

		}

		TopicoDao dao3 = new TopicoDao();
		Topico topicoCompleto = dao3.buscarPorId(topico.getId());
		model.addAttribute("topico", topicoCompleto);
		return "topico/alterarTopico";
	}

	@RequestMapping("/alterarTopico")
	public String alterarTopico(Topico topico, Model model) throws SQLException {

		TopicoDao dao = new TopicoDao();
		dao.alterar(topico);
		model.addAttribute("msg", "Topico alterado com sucesso !");

		return "forward:listarTopico";
	}

	@RequestMapping("/removerTopico")
	public String removerTopico(Topico topico, Model model) throws SQLException {

		TopicoDao dao = new TopicoDao();
		dao.remover(topico);
		model.addAttribute("msg", "Topico Removido com Sucesso!");
		return "forward:listarTopico";
	}
	  
}
