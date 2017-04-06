<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:import url="/view/menu/menu.jsp"></c:import>
		
<h3>Alterar Cadastro </h3>
	
	<div style="text-align: center; color: red;"> ${msg} </div>
	
<form action="alterarUsuario" method="post" enctype="multipart/form-data">

	<form:errors path="usuario.nome" cssStyle="color: red;" /><br />
	<form:errors path="usuario.email" cssStyle="color: red;" /><br />
	<form:errors path="usuario.login" cssStyle="color: red;" /><br />
	<form:errors path="usuario.senha" cssStyle="color: red;" /><br />
	<form:errors path="usuario.dataNascimento" cssStyle="color: red;" /><br />



		<input type="hidden" name="id" value="${usuario.id}" />
	
		nome:<br />
		<input type="text" name="nome" value="${usuario.nome}" />
		<br />email:<br />
		<input type="text" name="email" value="${usuario.email}" />
		<br /> login:<br />
		<input type="text" name="login" value="${usuario.login}" />
		<br /> senha:<br />
		<input type="password" name="senha" value="${usuario.senha}" />
		<br /> confirmar senha:<br />
		<input type="password" name="confirmarSenha" />
		<br /> data de nascimento:<br />
		<input type="text" name="dataNascimento"  value="<fmt:formatDate value='${usuario.dataNascimento}' pattern='dd/MM/yyyy' />"  />
		<br /> foto:<br />
		<input type="hidden" name="imagem" value="${usuario.imagem}" />
		<img alt="" src="view/img/${usuario.imagem}" style="width: 30%;">
		<br />
		Insira uma nova foto:<br />
		<br /><input type="file" name="file">
		<br />	<br />
		<input type="submit"  value="alterar" >
	
</form>

</body>
</html>