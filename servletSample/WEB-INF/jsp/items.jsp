<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Servlet Sample</title>
</head>
<body>
	<h1>Items</h1>
	<table class="item_table">
		<tr>
			<th>ItemName</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<td><c:out value="${item.itemName}" /></td>
				<td>
					<form action="./add-item" method="post">
						<input type="hidden" name="item-id" value="<c:out value="${item.getItemId()}" />" />
						<input type="submit" value="Boxに入れる" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="./box">Boxを見る</a>
	</p>
</body>
</html>