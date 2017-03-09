<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
      
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
	
	nome:<br />
		<input type="text" name="nome" value="${usuario.nome}">
		<br />email:<br />
		<input type="text" name="email" value="${usuario.email}">
		<br /> login:<br />
		<input type="text" name="login" value="${usuario.login}">
		<br /> senha:<br />
		<input type="password" name="senha" value="${usuario.senha}">
		<br /> confirmar senha:<br />
		<input type="password" name="confirmarSenha">
		<br /> data de nascimento:<br />
		<input type="text" name="dataNascimento"  value="<fmt:formatDate value='${usuario.datNascimento}' pattern='dd/MM/yyyy' />"/>
		<br /> foto:<br />
		<br />
		<input type="submit"  value="alterar">
	
</form>

</body>
</html>