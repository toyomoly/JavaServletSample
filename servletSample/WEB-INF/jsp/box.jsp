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
	<h1>Box</h1>
	<table>
		<tr>
			<th>ItemName</th>
			<th class="cart_count">PickCount</th>
		</tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<td><c:out value="${item.itemName}" /></td>
				<td><c:out value="${item.pickCount}" /></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<div>
			<a href="./items">Item一覧へ戻る</a>
		</div>
	</div>
</body>
</html>