<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MyType.css">
</head>
<body>
<h1>This page join.jsp</h1>
<hr>
<h2>
		<form name="inputForm" action="insertUser.do" method="post">
			<table class="type03">
				<tr>
					<th>ID</th>
					<td align="left">&nbsp;&nbsp;<input type="text" name="id" placeholder="ID"> <input
						type="button" onclick="id_check();" name="idCheck" value="중복확인">
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td align="left">&nbsp;&nbsp;<input type="text" name="password" placeholder="password"></td>
				</tr>
				<tr>
					<th>NICKNAME</th>
					<td align="left">&nbsp;&nbsp;<input type="text" name="nicname" placeholder="name"></td>
				</tr>
				<tr>
					<th>GENDER</th>
					<td><input type="radio" name="gender" value="female"
						checked="checked"> Female &nbsp; <input type="radio"
						name="gender" value="male"> Male</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="join!"> <input
						type="button" value="Cancel" onclick="history.back()"></td>
				</tr>
			</table>
		</form>
	</h2>
</body>
</html>