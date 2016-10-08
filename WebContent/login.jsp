<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Library Assignment 2">
    <meta name="author" content="">
    
	<title>Login Page - Digital Bibliographic Library</title>
	
	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Digital Bibliographic Library</h1>
		</div>
    </header>
    
    <!-- Check for logged in condition? -->
	<center>
	<c:choose>
		<c:when test="${isLoggedIn eq false }">
			<h2>Login details are incorrect</h2>
		</c:when>
	</c:choose>
	
	<!-- Login interface -->
	<div class="bg-primary">
		<form action="control" method="post">
			<fieldset>
			<legend>User Login</legend>
				<table>
					<tr>
						<td>Username: </td> <td><input type="text" name="usernameLogin" style="color: black"></td>
					</tr>
					<tr>
						<td>Password: </td> <td><input type="password" name="passwordLogin" style="color: black"></td>
					</tr>
					<tr>
						<%-- <td><input type="hidden" name="action" value="newUserSignUp"><input type="submit" value="Sign Up"></td> --%>
						<%--<td><input type="hidden" name="action" value="loginUser"><input type="submit" value="Log In"></td> --%>
					</tr>
				</table>
				<input type="submit" name="action" value="loginUser" style="color:black;">
				<input type="submit" name="action" value="newUserSignUp" style="color:black;">
			</fieldset>
		</form>
	
	</div>
	</center>
	
</body>
</html>