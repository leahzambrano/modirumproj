<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login System</title>
</head>
<body>
<h1>Login System</h1>
	<form method="post" action="LoginCheck">
		<br>
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
				<td><a href="./forgotpass.jsp">Forgot Password?</a></td>
			</tr>
			<tr>
				<td></td>
			</tr>

			<tr>
				
				<td></td>
				<td><input type="submit" value="Login" id="btn_login"></td>
			</tr>
			</table>
			<br>
			Not a member?<a href="./newuser.jsp">click here</a>
	</form>
</body>
</html>