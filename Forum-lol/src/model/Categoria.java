package model;

import java.sql.Date;

public class Categoria {
	
	private int id;
	private String titulo;
	private String descricao;
	private Date ultimo_post;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getUltimo_post() {
		return ultimo_post;
	}
	public void setUltimo_post(Date ultimo_post) {
		this.ultimo_post = ultimo_post;
	}
	
	
}
