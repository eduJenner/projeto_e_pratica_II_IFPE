<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:import url="/view/menu/menu.jsp"></c:import>

	<h3>Criar Post</h3>

	<div style="text-align: center; color: red;">${msg}</div>

	<form action="criarPost" method="post">

		<input type="hidden" name="usuario" value="${usuarioLogado.id}"><br />

		<br />
		
		<textarea rows="20" cols="75" name="conteudo">${post.conteudo}</textarea>
		
		<br /> Tópico: <br /> <select name="topico">
			<option value="">Selecione</option>
			<c:forEach items="${listaTopico}" var="obj">
				<option value="${obj.id}">${obj.titulo}</option>
			</c:forEach>
		</select> <input type="submit" value="Criar">
	</form>
</body>
</html>