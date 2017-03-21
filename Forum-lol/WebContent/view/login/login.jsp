<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Login</h3>
<div style="color: red;" align="center"> <h3> ${msg} </h3> </div>
<form action="efetuarLogin" method="post">
informe seu login:<br />
<br /><input type="text" name="login"><br />
informe sua senha:<br />
<br /><input type="password" name="senha"><br />
<input type="submit" value="Login">
</form>
</body>
</html>