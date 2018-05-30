<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Servlet Sample</title>
</head>
<body>
	<h1>Login</h1>
	<div>
		<form action="./login" method="post">
			<table>
				<tr>
					<td>ユーザー名</td>
					<td><input type="text" name="user-name" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="ログイン" />
		</form>
	</div>
</body>
</html>