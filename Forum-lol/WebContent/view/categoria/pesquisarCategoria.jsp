<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="/view/menu/menu.jsp"></c:import>
<h3>Listar Categoria</h3>
<div style="text-align: center; color: red;"> ${msg} </div>

<table border="1">
<tr>
	<td>Título</td>
	<td>Descrição</td>
	<td>#</td>
</tr>
<c:forEach var="categoria" items="${listaCategoria}">
<tr>
	<td>${categoria.titulo}</td>
	<td>${categoria.descricao}</td>
	<td>
		<a href="exibirAlterarCategoria?id=${categoria.id}">Alterar</a>
        <a href="removerCategoria?id=${categoria.id}">Remover</a>
    </td>
</tr>
</c:forEach>
</table>
</body>
</html>