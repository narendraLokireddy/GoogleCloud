<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today's Journeys</title>
</head>
<body style="font-family: consolas; font-size: 18px;">
	<table>
		<tr>
			<td><a href="${pageContext.request.contextPath}/userspdf.htm">PDF</a></td>
			<td>&nbsp;</td>
			<td><a href="${pageContext.request.contextPath}/usersexcel">Excel</a></td>
		</tr>
		<tr>
			<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>ROLE</th>
		</tr>
		<c:forEach items="${users}" var="userBo">
			<tr>
				<td>${userBo.username}</td>
				<td>${userBo.password}</td>
				<td>${userBo.role}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>








