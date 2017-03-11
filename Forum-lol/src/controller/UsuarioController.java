package controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.Usuario;
import model.UsuarioDao;
import util.Util;

@Controller
public class UsuarioController {
	// este método retorna um formulário
	@RequestMapping("/novoUsuario")
	public String form() {
		return "usuario/formulario";
	}

	// este método cadastra novos usuários
	@RequestMapping("/cadastraUsuario")
	public String cadastrar(Usuario usuario, @RequestParam("file") MultipartFile imagem, Model model)
			throws SQLException {

		if (Util.fazerUploadImagem(imagem)) {
			usuario.setImagem(Calendar.getInstance().getTime() + " - " + imagem.getOriginalFilename());
		}

		UsuarioDao dao = new UsuarioDao();
		dao.adiciona(usuario);
		model.addAttribute("msg", "Usuario(a) " + usuario.getLogin() + " Cadastrado com Sucesso!");
		return "usuario/formulario";
	}

	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listaUsuario = dao.listar();
		model.addAttribute("listaUsuario", listaUsuario);

		return "usuario/pesquisarUsuario";
	}

	@RequestMapping("/exibirAlterarUsuario")
	public String exibirAlterarUsuario(Usuario usuario, Model model) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioCompleto = dao.buscarPorId(usuario.getId());
		model.addAttribute("usuario", usuarioCompleto);
		return "usuario/alterarUsuario";
	}

	@RequestMapping("/alterarUsuario")
	public String alterar(Usuario usuario, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		model.addAttribute("msg", "Usuario(a) " + usuario.getLogin() + " Alterado com Sucesso!");
		return "forward:listarUsuario";

	}

	@RequestMapping("/removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		dao.remover(usuario);
		model.addAttribute("msg", "Usuario(a)  Removido com Sucesso!");
		return "forward:listarUsuario";
	}
	@RequestMapping("/exibirBuscarUsuario")
	public String exibirBuscarUsuario(){
		return "usuario/buscarUsuarioTeste";
	}
	
	@RequestMapping("/buscarUsuario")
	public String buscarUsuario(Usuario usuario,Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioCompleto = dao.buscarUsuario(usuario.getLogin());
		model.addAttribute("usuario", usuarioCompleto);
		return "usuario/alterarUsuario";
	}
}
