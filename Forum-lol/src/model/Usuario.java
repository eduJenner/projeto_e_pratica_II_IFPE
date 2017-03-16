package model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {

	private int id;
	@Size(min = 5, max = 50, message = "Mínimo 5 caracteres!")
	private String nome;

	@Email(message = "E-mail incorreto!")
	@NotEmpty(message = "O nome deve ser preenchido!")
	private String email;

	@Size(min = 5, max = 50, message = "Mínimo 5 caracteres!")
	@NotEmpty(message = "O login deve ser preenchido!")
	private String login;
	@Size(min = 8,message = "Mínimo 8 caracteres!")
	@Pattern(regexp = "(?!.*\\s)((?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%]).{8,20})$", message = "A senha deve conter pelo menos um caractere especial,número e letra!")
	@NotEmpty(message = "A senha deve ser preenchida!")
	private String senha;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past(message = "Data incorreta!")
	private Date dataNascimento;
	private String imagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	

}