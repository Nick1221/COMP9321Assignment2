<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Library Assignment 2">
    <meta name="author" content="">
    
	<title>User Registration - Digital Bibliographic Library</title>
	
	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
<title>User Registration</title>
</head>
<body>
	<!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Digital Bibliographic Library</h1>
		</div>
    </header>
	<h1>Shopping Cart</h1>
	
	<!-- User info section -->
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
				<td>Year of birth: </td> <td><input type="text" name="yearOfBirth"><input type="text" name="yearOfBirth"><input type="text" name="yearOfBirth"></td>
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