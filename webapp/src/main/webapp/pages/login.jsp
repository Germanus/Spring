<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login</title>
</head>
<body>

<c:if test="${not empty param.error}">
	<font color="red">Login error.<br/>
	Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</font>
</c:if>

<form method="POST" action="<c:url value="/login"/>" >
	<table>
		<tr>
			<td align="right">Username</td>
			<td><input type="text" name="username"/>
		</tr>
		<tr>
			<td align="right">Password</td>
			<td><input type="text" name="password"/>
		</tr>
		<tr>
			<td align="right">Remember me</td>
			<td><input type="checkbox" name="j_spring_security_remember_me"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
			</td>
			
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" name="Login"/>
				<input type="reset" name="Reset"/>
			</td>			
		</tr>				
	</table>
</form>

</body>
</html>