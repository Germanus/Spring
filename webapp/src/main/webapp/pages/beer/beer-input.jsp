<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<form:form action="beer-advice" commandName="color">
		Select beer characteristics:
		<table align="center">

			<tr>
				<td>Color:</td>
				<td>
					<form:select path="name">
						<form:option value="light"></form:option>
						<form:option value="dark"></form:option>
					</form:select>
				</td>
			</tr>			
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		
	</form:form>

</body>
</html>