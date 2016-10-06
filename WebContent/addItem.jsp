<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, user.* , java.util.*" %>
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

<%
	User currUser = user.getLoggedInUser().get(0);
	pageContext.setAttribute("isAdmin", currUser.get("isAdmin"));
%>

<body>
	<!-- Navigation -->
	<!-- TODO: still needs logout? Possible restyling in css to make buttons look like links -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <c:choose>
            	<c:when test="${isAdmin == 'true'}">
            		<li class="sidebar-brand">
		                <a href="#top" onclick=$("#menu-close").click()");>Welcome, <%= currUser.get("Username") %>!</a>
		            </li>
		            <li>
		            	<form action="admin.jsp" method="post">
							<input type="submit" value="Admin Control Panel">
						</form>
		            </li>
		            <li>
		            	<form action="search.jsp" method="post">
							<input type="submit" value="Home Page">
						</form>
		            </li>
		            <li>
		                <form action="control" method="post">
							<input type="hidden" name="action" value="shopCart">
							<input type="submit" value="Shopping Cart">
						</form>
		            </li>
		            <li>
		            	<form action="addItem.jsp" method="post">
							<input type="submit" value="Register a Publication">
						</form>
		            </li>
		            <li>
		            	<form action="existingItems.jsp" method="post">
							<input type="submit" value="See my existing publications">
						</form>
		            </li>
            	</c:when>           
            	<c:otherwise>
            		<li class="sidebar-brand">
		                <a href="#top" onclick=$("#menu-close").click();>Welcome, <%= currUser.get("Username") %>!</a>
		            </li>
		            <li>
		            	<form action="search.jsp" method="post">
							<input type="submit" value="Home Page">
						</form>
		            </li>
		            <li>
		                <form action="control" method="post">
							<input type="hidden" name="action" value="shopCart">
							<input type="submit" value="Shopping Cart">
						</form>
		            </li>
		            <li>
		            	<form action="addItem.jsp" method="post">
							<input type="submit" value="Register a Publication">
						</form>
		            </li>
		            <li>
		            	<form action="existingItems.jsp" method="post">
							<input type="submit" value="See my existing publications">
						</form>
		            </li>
            	</c:otherwise>
            </c:choose>
            
        </ul>
    </nav>
    
    
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
			<tr>
				<td>Volume: </td><td><input type="text" name="publishVolume"></td>
			</tr>
			<tr>
				<td>Editors: </td><td><input type="text" name="publishEditors"></td>
			</tr>
			<tr>
				<td>Picture: </td><td><input type="text" name="publishPic"></td>
			</tr>
			<tr>
				<td>Price: </td><td><input type="text" name="publishPrice"></td>
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