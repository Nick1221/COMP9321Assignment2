<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*" %>
<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Library Assignment 2">
    <meta name="author" content="">
    <title>Item addition page - Digital Bibliographic Library</title>
    
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
	<h1>Shopping Cart</h1>
	
	<!-- Add item fields -->
	<center>
	<h1>Enter publication details</h1>
	<form action="control" method="post">
		<table>
			<tr>
				<td>Title: </td><td><input type="text" name="publishTitle"></td>
			</tr>
			<tr>
				<td>Author(separate multiple authors with ","): </td><td><input type="text" name="publishAuthor"></td>
			</tr>
			<tr>
				<td>Year: </td><td><input type="text" name="publishYear"></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="addPublication">
		<input type="submit" value="Add Publication">
	</form>
	<form action="search.jsp" method="post">
		<input type="submit" name="action" value="Back to Search"/>
	</form>
	</center>
</body>
</html>