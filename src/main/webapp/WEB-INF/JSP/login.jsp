<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
</head>
<body>
	<center>

		<h1>Welcome to Spring Security Learning</h1>

		<div
			style="text-align: center; padding: 30px; border: 1px solid; width: 250px;">

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>


			<form
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method="post">
				Username: <input type="text" name="j_username" /> Password: <input
					type="password" name="j_password" /> <input type="submit"
					value="login" /> <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<c:url var="register" value="/registration.htm" />
			<form action="${register}" method="get">
				<p style="colour: red">
					<input type="submit" value="REGISTER">
				</p>
			</form>



		</div>

	</center>
</body>
</html>