package controller;

import java.sql.SQLException;
import java.util.Calendar;

import model.Usuario;
import model.UsuarioDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import util.Util;

@Controller
public class UsuarioController {
	// este método retorna um formulário
	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formulario";
	}

	// este método cadastra novos usuários
	@RequestMapping("cadastraUsuario")
	public String cadastrar(Usuario usuario,@RequestParam("file") MultipartFile imagem) throws SQLException {

		if (Util.fazerUploadImagem(imagem)) {
			usuario.setImagem(Calendar.getInstance().getTime() + " - " + imagem.getOriginalFilename());
		}

		
		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(usuario);
		return "usuario/cadastrado";
	}

	

	}
