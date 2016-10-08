<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, user.*, java.util.*, general.*" %>
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
    <title>User registered items - Digital Bibliographic Library</title>
    
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
	List<DataHolder> existing = currUser.getRegisteredPublications();
	pageContext.setAttribute("isAdmin", currUser.get("isAdmin"));
%>

<body>
<!-- Navigation -->
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
		            	<form action="userDetails.jsp" method="post">
							<input type="submit" value="Profile">
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
		            <li>
		            	<form action="control" method="post">
							<input type="hidden" name="action" value="userLogout">
							<input type="submit" value="Logout">
						</form>
		            </li>		            
            	</c:when>
            	<c:otherwise>
            		<li class="sidebar-brand">
		                <a href="#top" onclick=$("#menu-close").click();>Welcome, <%= currUser.get("Username") %>!</a>
		            </li>
		            <li>
		            	<form action="userDetails.jsp" method="post">
							<input type="submit" value="Profile">
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
		            <li>
		            	<form action="control" method="post">
							<input type="hidden" name="action" value="userLogout">
							<input type="submit" value="Logout">
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
    
    <div class="col-lg-12">
    	<h1>User Details</h1>
    	<form action="control" method="post">
		<table>
			<tr>
				<td>Username: </td> <td><input type="text" name="username" value="<% out.println(currUser.get("Username").toString()); %>"></td>
			</tr>
			<tr>
				<td>Password: </td> <td><input type="password" name="password" value="<% out.println(currUser.get("password").toString()); %>"></td>
			</tr>
			<tr>
				<td>Email: </td> <td><input type="text" name="email" value="<% out.println(currUser.get("email").toString()); %>"></td>
			</tr>
			<tr>
				<td>First name: </td> <td><input type="text" name="firstname" value="<%out.println(currUser.get("firstName").toString()); %>"></td>
			</tr>
			<tr>
				<td>Last name: </td> <td><input type="text" name="lastname" value="<%out.println(currUser.get("lastName").toString()); %>"></td>
			</tr>			
			<tr>
				<td>Full address: </td> <td><input type="text" name="fullAddress" value="<%out.println(currUser.get("fullAddress").toString()); %>"></td>
			</tr>
			<tr>
				<td>Nickname: </td> <td><input type="text" name="nickname" value="<%out.println(currUser.get("nickname").toString()); %>"></td>
			</tr>
			<tr>
				<td>Credit card number: </td> <td><input type="text" name="creditCardNo" value="<%out.println(currUser.get("cardNumber").toString()); %>"></td>
			</tr> 
		</table>
		<input type="hidden" name="action" value="changeUser">
		<input type="submit" value="Change Details">
	</form>
    </div>
	
	
	
		<!-- jQuery -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
    <!-- Custom Theme JavaScript -->
    <script>   

    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
   
    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    //#to-top button appears after scrolling
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    
    </script>
</body>
</html>