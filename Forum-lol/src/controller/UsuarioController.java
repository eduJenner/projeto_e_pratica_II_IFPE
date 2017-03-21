package controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model,
			@RequestParam("file") MultipartFile imagem, @RequestParam("senha") String param1,
			@RequestParam("confirmarSenha") String param2) throws SQLException {

		if (param1.equals(param2)) {

			if (result.hasErrors()) {
				return "usuario/formulario";
			}

			if (Util.fazerUploadImagem(imagem)) {
				usuario.setImagem(Calendar.getInstance().getTime() + " - " + imagem.getOriginalFilename());
			}

			UsuarioDao dao = new UsuarioDao();
			dao.adiciona(usuario);
			model.addAttribute("msg", "Usuario(a) " + usuario.getLogin() + " Cadastrado com Sucesso!");
			return "usuario/formulario";
		} else {
			model.addAttribute("msg", "Senhas não conferem!");
			return "usuario/formulario";
		}

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
	public String alterar(@Valid Usuario usuario, BindingResult result, Model model,
			@RequestParam("senha") String param1, @RequestParam("confirmarSenha") String param2) throws SQLException {
		if (param1.equals(param2)) {

			if (result.hasErrors()) {
				return "usuario/alterarUsuario";
			}

			UsuarioDao dao = new UsuarioDao();
			dao.alterar(usuario);
			model.addAttribute("msg", "Usuario(a) " + usuario.getLogin() + " Alterado com Sucesso!");

			return "forward:listarUsuario";
		} else {
			model.addAttribute("msg", "Senhas não conferem!");
			return "usuario/alterarUsuario";
		}
	}

	@RequestMapping("/removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		dao.remover(usuario);
		model.addAttribute("msg", "Usuario(a)  Removido com Sucesso!");
		return "forward:listarUsuario";
	}

	@RequestMapping("/exibirBuscarUsuario")
	public String exibirBuscarUsuario() {
		return "usuario/buscarUsuarioTeste";
	}

	@RequestMapping("/buscarUsuario")
	public String buscarUsuario(Usuario usuario, Model model) throws SQLException {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioCompleto = dao.buscarLogin(usuario.getLogin());
		model.addAttribute("usuario", usuarioCompleto);
		return "usuario/alterarUsuario";
	}
	@RequestMapping("/exibirLogin")
	public String exibirLogin(){
		return"login/login";
	}
	
	@RequestMapping("/efetuarLogin")
	public String login(Usuario usuario, HttpSession session, Model model) throws SQLException{
		
		UsuarioDao dao = new  UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);
		if(usuarioLogado != null ){
			session.setAttribute("usuarioLogado", usuarioLogado);
			return"index";
		}
		model.addAttribute("msg", "Não foi encontrado um usuário com o login e senha informados.");
		return "login/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
		}
}
