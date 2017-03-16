package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Categoria;
import model.CategoriaDao;

@Controller
public class CategoriaController {

	@RequestMapping("/novaCategoria")
	public String form() {
		return "categoria/formulario";
	}

	@RequestMapping("/cadastraCategoria")
	public String cadastrar(Categoria categoria, Model model) throws SQLException {

		CategoriaDao dao = new CategoriaDao();
		dao.adiciona(categoria);
		model.addAttribute("msg", "Categoria " + categoria.getTitulo() + " criada com sucesso!");
		return "categoria/formulario";
	}

	@RequestMapping("/listarCategoria")
	public String listarCategoria(Model model) throws SQLException {

		CategoriaDao dao = new CategoriaDao();
		List<Categoria> listaCategoria = dao.listar();
		model.addAttribute("listaCategoria", listaCategoria);

		return "categoria/pesquisarCategoria";
	}

	@RequestMapping("/exibirAlterarCategoria")
	public String exibirAlterarCategoria(Categoria categoria, Model model) throws SQLException {
		CategoriaDao dao = new CategoriaDao();
		Categoria categoriaCompleta = dao.buscarPorId(categoria.getId());
		model.addAttribute("categoria", categoriaCompleta);
		return "categoria/alterarCategoria";
	}

	@RequestMapping("/alterarCategoria")
	public String alterar(Categoria categoria, Model model) throws SQLException {

		CategoriaDao dao = new CategoriaDao();
		dao.alterar(categoria);
		model.addAttribute("msg", "Categoria " + categoria.getTitulo() + " Alterado com Sucesso!");

		return "forward:listarCategoria";
	}

	@RequestMapping("/removerCategoria")
	public String removerCategoria(Categoria categoria, Model model) throws SQLException {

		CategoriaDao dao = new CategoriaDao();
		dao.remover(categoria);
		model.addAttribute("msg", "Categoria  Removida com Sucesso!");
		return "forward:listarCategoria";
	}
}
