<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<center>
<c:choose>
	<c:when test="${registered eq false }">
		<h2>Must register first</h2>
	</c:when>
</c:choose>
<h1>Enter User Details</h1>
<form action="control" method="post">
	<table>
		<tr>
			<td>Username: </td> <td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password: </td> <td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td>Email: </td> <td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>First name: </td> <td><input type="text" name="firstname"></td>
		</tr>
		<tr>
			<td>Last name: </td> <td><input type="text" name="lastname"></td>
		</tr>
		<tr>
			<td>Year of birth: </td> <td><input type="text" name="yearOfBirth"></td>
		</tr>
		<tr>
			<td>Full address: </td> <td><input type="text" name="fullAddress"></td>
		</tr>
		<tr>
			<td>Credit card number: </td> <td><input type="text" name="creditCardNo"></td>
		</tr> 
	</table>
	<input type="hidden" name="action" value="registerUser">
	<input type="submit" value="Register User">
</form>
<form action="login.jsp" method="post">
	<input type="submit" value="Back to Login page">
</form>
</center>
</body>
</html>