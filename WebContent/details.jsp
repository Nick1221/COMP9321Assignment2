<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="shopcart" class="cs9321ass2.ShopCartBean" scope="session" />
<jsp:useBean id="detail" class="cs9321ass2.DetailBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Library Assignment 2">
    <meta name="author" content="">
	<title>Details Page - Digital Bibliographic Library</title>
	
	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body>
	<!-- Navigation -->
	<!-- TODO: still needs logout? Possible restyling in css to make buttons look like links -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li class="sidebar-brand">
                <a href="#top" onclick=$("#menu-close").click();>Menu</a>
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
        </ul>
    </nav>
    


	<!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Digital Bibliographic Library</h1>
		</div>
    </header>
    
    <!-- Display details -->
	<center>
		<c:choose>
			<c:when test="${isEmpty eq 'true'}">
				<h1>No publication has been selected!</h1>
			</c:when>
			<c:otherwise>
				<fieldset>
				<legend>Full Details</legend>
					<c:forEach var="info" items="${detail.fullDetailed}">
					<c:out value="${info}" />
					</c:forEach>
				</fieldset>
				<form action="control">
				<input type="hidden" name="action" value="addtocartFrDetail">
				<input type="submit" value="Add to Cart">
				</form>
			</c:otherwise>
		</c:choose>
	<br><br><br><br><br>
	<form action="control">
		<input type="hidden" name="action" value="shopCart">
		<input type="submit" value="Shopping Cart">
	</form>
	<br>
	<form action="search.jsp" method="post">
		<input type="submit" name="action" value="Back to Search"/>
	</form>
	</center>
</body>
</html>