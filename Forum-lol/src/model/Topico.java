package model;

import java.sql.Date;

public class Topico {
	
	private int id;
	private String titulo;
	private Usuario usuario;
	private Categoria categoria;
	private Date dataCriacaoDoTopico;
	private int visualizacoes;
	private String conteudo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Date getDataCriacaoDoTopico() {
		return dataCriacaoDoTopico;
	}
	public void setDataCriacaoDoTopico(Date dataCriacaoDoTopico) {
		this.dataCriacaoDoTopico = dataCriacaoDoTopico;
	}
	public int getVisualizacoes() {
		return visualizacoes;
	}
	public void setVisualizacoes(int visualizacoes) {
		this.visualizacoes = visualizacoes;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
