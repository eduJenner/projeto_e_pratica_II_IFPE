<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import url="/view/menu/menu.jsp"></c:import>
	
	<h3>Cadastro de Usuário</h3>
	
	
	<div style="text-align: center; color: red;"> ${msg} </div>
	<form action="cadastraUsuario" method="post" enctype="multipart/form-data">
	<form:errors path="usuario.nome" cssStyle="color: red;" /><br />
	<form:errors path="usuario.email" cssStyle="color: red;" /><br />
	<form:errors path="usuario.login" cssStyle="color: red;" /><br />
	<form:errors path="usuario.senha" cssStyle="color: red;" /><br />
	<form:errors path="usuario.dataNascimento" cssStyle="color: red;" /><br />
	
		<br />Nome:<br />
		<input type="text" name="nome">
		<br />Email:<br />
		<input type="text" name="email">
		<br /> Login:<br />
		<input type="text" name="login">
		<br /> Senha:<br />
		<input type="password" name="senha">
		<br /> Confirmar Senha:<br />
		<input type="password" name="confirmarSenha">
		<br /> Data de Nascimento:<br />
		<input type="text" name="dataNascimento" />
		<br /> Foto:<br />
		<input type="file" name="file"> <br />
		 <br /><input type="submit"  value="Cadastar">
	</form>
</body>
</html>