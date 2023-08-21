<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" >

<title>Insert title here</title>
</head>
<body>

<div id="cont">
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>Login</td>
				<td><input class="inp" type="text" name="tlogin"></td>
			</tr>
		
			<tr>
				<td>Password</td>
				<td><input class="inp" type="password" name="tpassword"></td>
			</tr>
		
			<tr>
				<td>Login</td>
				<td><input class="inp" type="submit" name="submitbtn"></td>
			</tr>
		</table>
	</form>
</div>
<div><p id="errorText">${text}</p></div>
</body>
</html>