<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/view/menu/menu.jsp"></c:import>

	<h3>Alterar Post</h3>

	<div style="text-align: center; color: red;">${msg}</div>

<form action="alterarPost" method="post">
	<input type="hidden" name="id" value="${post.id}" />
	
	<input type="hidden" name="usuario" value="${post.usuario.id}"><br />

	<input type="hidden" name="topico" value="${post.topico.id}"><br />
	
	<br /><textarea rows="20" cols="75" name="conteudo"></textarea><br />
	
	

	<input type="submit" value="Alterar">
</form>
</body>
</html>