<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Cadastro de Usuário</h3>

	<form action="cadastraUsuario" method="post" enctype="multipart/form-data">
		nome:<br />
		<input type="text" name="nome">
		<br />email:<br />
		<input type="text" name="email">
		<br /> login:<br />
		<input type="text" name="login">
		<br /> senha:<br />
		<input type="password" name="senha">
		<br /> confirmar senha:<br />
		<input type="password" name="confirmarSenha">
		<br /> data de nascimento:<br />
		<input type="text" name="dataNascimento"  />
		<br /> foto:<br />
		<input type="file" name="file"> <br />
		<input type="submit"  value="cadastar">
	</form>
</body>
</html>