package controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Usuario;
import model.UsuarioDao;

@Controller
public class UsuarioController {
	// este método retorna um formulário
	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formulario";
	}

	// este método cadastra novos usuários
	@RequestMapping("cadastraUsuario")
	public String cadastrar(@Valid Usuario usuario, BindingResult result) throws SQLException {

		if (result.hasFieldErrors("nome")) {
			return "usuario/formulario";
		}
		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(usuario);
		return "usuario/cadastrado";
	}

	// com erro
	@RequestMapping("mostraUsuario")
	public String mostra(Long id, Model model) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		model.addAttribute("usuario", dao.buscarPorId(id));
		return "usuario/mostra";
	}
	//com erro
	@RequestMapping("alteraUsuario")
	public String altera(Usuario usuario) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		dao.altera(usuario);
		return "usuario/alterado";

	}
}