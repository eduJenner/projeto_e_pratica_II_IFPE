package model;

import java.sql.Date;

public class Post {
	
		private int id;
		private Usuario usuario;
		private Topico topico;
		private String conteudo;
		private Date data;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public Topico getTopico() {
			return topico;
		}
		public void setTopico(Topico topico) {
			this.topico = topico;
		}
		public String getConteudo() {
			return conteudo;
		}
		public void setConteudo(String conteudo) {
			this.conteudo = conteudo;
		}
		public Date getData() {
			return data;
		}
		public void setData(Date data) {
			this.data = data;
		}
		
		
}
