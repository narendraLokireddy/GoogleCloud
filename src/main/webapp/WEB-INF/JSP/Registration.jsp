<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form commandName="Registration"
		action="${pageContext.request.contextPath}/registration.htm">
		<table>
			<tr>
				<td colspan="2">
					<p style="color: red">
						<form:errors path="*" />
					</p>
				</td>
			<tr>
				<td>username</td>
				<td><form:input path="username" />
			</tr>
			<tr>
				<td>password</td>
				<td><form:password path="password" /></td>
			<tr>
				<td>role</td>
				<td><form:input path="role" /></td>
			<tr>
				<td>
				<td colspan="2"><input type="submit" value="register" /></td>
		</table>
	</form:form>


</body>
</html>