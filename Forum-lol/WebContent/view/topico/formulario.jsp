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
<h3>Criar Tópico</h3>

<div style="text-align: center; color: red;"> ${msg} </div>


<form action="criarTopico" method="post">
Título:
<br /><input type="text" name="titulo"><br />
<br />Conteúdo:
<br /><textarea rows="20" cols="75" name="conteudo"></textarea><br />
${usuarioLogado.id}<br />
<input type="hidden" name="usuario" value="${usuarioLogado.id}">
${categoria.id}
<input type="hidden" name="categoria" value="${categoria.id}">

<br /><input type="submit" value="Criar">
</form>
</body>
</html>