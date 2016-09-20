<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Digital Bibliographic Library</title>
</head>
<body>
<center>
<c:choose>
	<c:when test="${isLoggedIn eq false }">
		<h2>Login details are incorrect</h2>
	</c:when>
</c:choose>
<form action="control" method="post">
	<fieldset>
	<legend>User Login</legend>
		<table>
			<tr>
				<td>Username: </td> <td><input type="text" name="usernameLogin"></td>
			</tr>
			<tr>
				<td>Password: </td> <td><input type="text" name="passwordLogin"></td>
			</tr>
			<tr>
				<%-- <td><input type="hidden" name="action" value="newUserSignUp"><input type="submit" value="Sign Up"></td> --%>
				<%--<td><input type="hidden" name="action" value="loginUser"><input type="submit" value="Log In"></td> --%>
			</tr>
		</table>
		<input type="hidden" name="action" value="loginUser"><input type="submit" value="Log In">
	</fieldset>
</form>
<form action="control">
	<input type="hidden" name="action" value="newUserSignUp"><input type="submit" value="Sign Up">
</form>
</center>
</body>
</html>