<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, user.*, publication.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Library Assignment 2">
    <meta name="author" content="">
	<title>Admin Panel - Digital Bibliographic Library</title>
	
	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
</head>

<%
	List<User> users = new User().searchByKey("1",1);
	List<Publication> books = new Publication().searchByKey("1","1");
	User currUser = user.getLoggedInUser().get(0);
	pageContext.setAttribute("userList", users);
	pageContext.setAttribute("bookList", books);
	pageContext.setAttribute("currUser", currUser);
%>


<body>
	<!-- Navigation -->
	<!-- TODO: still needs logout? Possible restyling in css to make buttons look like links -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <c:choose>
            	<c:when test="${currUser.isAdmin() == true }">
            		<li class="sidebar-brand">
		                <a href="#top" onclick=$("#menu-close").click();>Welcome, <%= currUser.get("Username") %>!</a>
		            </li>
		             <li>
		            	<form action="admin.jsp" method="post">
							<input type="submit" value="Admin Control Panel">
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
	<h1>Admin Control Panel</h1>
		
	
	
	<!-- Ban a user interface -->
	<!-- Show list of users-->
	<!-- Check user and ban user button here -->
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">Users</div>
			<div class="panel-body">
				<form action="control">
					<div id="tablecontainer" style="overflow: auto; height: 200px;">
						<table border="2">					
							<c:forEach var="username" items="${userList}">
								<tr>
									<td><input type="radio" name="srchRslts" value="${username.get("Username")}">
										Username: ${username.get("Username")}
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<button type="submit" name="action" value="getuserdetails">User Details</button>
					<button type="submit" name="action" value="banUser">Ban User</button>		
				</form>
			</div>
		</div>
	</div>
	
	<!-- When user is selected show the list of items purchased -->
	<!-- Here is where find detail button is(Should be the same as the other ones) -->
	<div class="col-lg-6">
		<form action="">
			
		</form>
	</div>
	
	<!-- Search and toggle item availibility -->
	<!-- Perform a search here (Need to add a admin specific button on results.jsp -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Publications</div>
			<div class="panel-body">
				<form action="control">
					<div id="tablecontainer" style="overflow: auto; height: 200px;">
						<table border="2">					
							<c:forEach var="book" items="${bookList}">
								<tr>
									<td><input type="radio" name="bk" value="${book.get('title')}">
										Title: ${book.get("title")}
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<button type="submit" name="action" value="removeItemForSale">Remove Item from Sale</button>	
				</form>
			</div>
		</div>
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