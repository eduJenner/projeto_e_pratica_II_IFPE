<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Cadastro de Usuário</h3>

<form action="cadastraUsuario" method="post">
	<br/>
	Nome:
	<br/>
	<form:errors path="usuario.nome" cssStyle="color:red"/>
	<br/>
	<input type="text" name="nome"/>
	<br/>
	Sobrenome:
	<br/>
	<input type="text" name="sobrenome"/>
	<br/>
	E-mail:
	<br/>
	<input type="text" name="email"/>
	<br/>
	Confirmar E-mail
	<br/>
	<input type="text" name="confirmarEmail"/>
	<br/>
	Data de Nascimento:
	<br/>
	<input type="text" name="dataNasc"/>
	<br/>
	Senha:
	<br/>
	<input type="text" name="senha"/>
	<br/>
	Confirmar Senha
	<br/>
	<input type="text" name="confirmarSenha"/>
	<br/>
	Nome de Usuário
	<br/>
	<input type="text" name="nomeUsuario"/>
	<br/>
	<br/>
	<input type="submit" value="cadastrar"/>
	
</form>
</body>
</html>