<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- 	${pageContext.request.userPrincipal.name}
		You are using spring security with database <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
 --%>
	<form
		action="${pageContext.request.contextPath}/j_spring_security_logout"
		method="post" id="logoutForm">

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>


	Registerd users:
	<a href="${pageContext.request.contextPath}/users.htm">Registerdusers</a>
 
 
	<form:form method="POST"
		action="http://localhost:8083/spring-jdbc_project/request.htm"
		commandName="Journey">
 
		<table>
			<tr>
				<td colspan="2"><span style="color: red;"> <form:errors
							path="*" />
				</span></td>
			</tr>
			<tr>
				<td>Source:</td>
				<td><form:input path="source" /></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><form:input path="destination" /></td>
			</tr>
			<tr>
				<td>JourneyDate:</td>
				<td><form:input path="journeyDate" /></td>
			</tr>
			<tr>
				<td>Bus No:</td>
				<td><form:input path="busNo" /></td>
			</tr>

			<tr>
				<td>Amount:</td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><form:radiobutton path="gender" value="M" label="male" />
				<td><form:radiobutton path="gender" value="F" label="femaile" />
				</td>
			</tr>

			<tr>
				<td>country</td>
				<td><form:select path="country">
						<form:option value="0" label="Select" />
						<form:option value="India" label="India" />
						<form:option value="USA" label="USA" />
						<form:option value="UK" label="UK" />
					</form:select></td>

			</tr>

			<tr>
				<td>About you :</td>
				<td><form:textarea path="aboutYou" /></td>
			</tr>
			<tr>
				<td>Community :</td>
				<td><form:checkbox path="community" value="Spring"
						label="Spring" /> <form:checkbox path="community"
						value="Hibernate" label="Hibernate" /> <form:checkbox
						path="community" value="Struts" label="Struts" /></td>
			</tr>
			<%-- <tr>
			<td></td>
			<td><form:checkbox path="mailingList"
				label="Would you like to join our mailinglist?" /></td>
		</tr>
 --%>
			<tr>
				<td colspan="2"><input type="submit" value="add" /></td>
			</tr>
		</table>
	</form:form>




</body>
</html>