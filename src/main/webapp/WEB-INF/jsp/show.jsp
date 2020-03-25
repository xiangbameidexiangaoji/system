<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		color: green;
	}
</style>
</head>
<body>
	<table border="1px" align="center" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<td>${user.userid }</td>
				<td>${user.username }</td>
				<td>${user.userage }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>