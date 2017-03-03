package controller;

import java.sql.SQLException;

import model.Usuario;
import model.UsuarioDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	// este método retorna um formulário
	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formulario";
	}

	// este método cadastra novos usuários
	@RequestMapping("cadastraUsuario")
	public String cadastrar(Usuario usuario) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(usuario);
		return "usuario/cadastrado";
	}

	

	}
