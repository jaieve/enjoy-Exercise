<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<style>
	th {width:100px; background-color: rgb(200, 150, 200); align:center;}
</style>
</head>
<body>
<center>
<h1>Login</h1>
<hr>
<form action="login.do" method="post">
<table border="1">
	<tr><th>ID</td><td><input type="text" name="id" value="${userVO.id }"></td></tr>
	<tr><th>PW</td><td><input type="password" name="password"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="LogIn"></td></tr>
</table>
</form>
<hr>
</center>
</body>
</html>