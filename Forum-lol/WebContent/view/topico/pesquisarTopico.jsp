<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/view/menu/menu.jsp"></c:import>
<h3>Listar Tópicos</h3>
<table border="1">
<tr>
	<td>ID topico</td>
	<td>titulo</td>
	<td>usuario</td>
	<td>categoria</td>
	<td>dataCriacaoDoTopico</td>
	<td>visualizacoes</td>
	<td>conteudo</td>
	<td>#</td>
</tr>
<c:forEach var="topico" items="${listaTopico}">
<tr>
	<td>${topico.id}</td>
	<td>${topico.titulo}</td>
	<td>${topico.usuario.login}</td>
	<td>${topico.categoria.titulo}</td>
	<td><fmt:formatDate value="${topico.dataCriacaoDoTopico}" pattern="dd/MM/yyyy"/></td>
	<td>${topico.visualizacoes}</td>
	<td>${topico.conteudo}</td>
	<td>
		<a href="exibirAlterarTopico?id=${topico.id}">Alterar</a>
		<a href="removerTopico?id=${topico.id}">Remover</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>