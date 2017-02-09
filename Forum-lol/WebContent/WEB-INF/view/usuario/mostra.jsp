<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Alterar Cadastro </h3>

<form action="alteraUsuario" method="post">

	
	
	<input type="hidden" name="id" value="${usuario.id}" />
	
	<br/>
	Nome:
	<br/>
	<form:errors path="usuario.nome" cssStyle="color:red"/>
	<br/>
	<input type="text" name="nome" value="${usuario.nome}"/>
	<br/>
	Sobrenome:
	<br/>
	<input type="text" name="sobrenome" value="${usuario.sobrenome}" />
	<br/>
	E-mail:
	<br/>
	<input type="text" name="email" value="${usuario.email}"/>
	<br/>
	Confirmar E-mail
	<br/>
	<input type="text" name="confirmarEmail"value="${usuario.confirmarEmail}"/>
	<br/>
	Data de Nascimento:
	<br/>
	<input type="text" name="dataNasc" value="<fmt:formatDate value="${usuario.dataNasc.time}"/>"/>
	<br/>
	Senha:
	<br/>
	<input type="text" name="senha" value="${usuario.senha}"/>
	<br/>
	Confirmar Senha
	<br/>
	<input type="text" name="confirmarSenha" value="${usuario.confirmarSenha}"/>
	<br/>
	Nome de Usuário
	<br/>
	<input type="text" name="nomeUsuario" value="${usuario.nomeUsuario}"/>
	<br/>
	<br/>
	<input type="submit" value="alterar"/>
	
</form>

</body>
</html>