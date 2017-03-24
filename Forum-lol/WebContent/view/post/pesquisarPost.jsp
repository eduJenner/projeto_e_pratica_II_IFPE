<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/view/menu/menu.jsp"></c:import>
	<h3>Listar Post's</h3>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Usuário</td>
			<td>Tópico</td>
			<td>Texto</td>
			<td>Data do Post</td>
			<td>#</td>
		</tr>
		<c:forEach var="post" items="${listaPost}">
			<tr>
				<td>${post.id}</td>
				<td>${post.usuario.login}</td>
				<td>${post.topico.titulo}</td>
				<td>${post.conteudo}</td>
				<td><fmt:formatDate value="${post.data}" pattern="dd/MM/yyyy" /></td>
				<td>
					<a href="exibirAlterarPost?id=${post.id}">Alterar</a>     
				    <a href="removerPost?id=${post.id}">Remover</a></td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>