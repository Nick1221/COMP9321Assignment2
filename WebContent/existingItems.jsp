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
%>

<body>

	<!-- Navigation -->
	<!-- TODO: still needs logout? Possible restyling in css to make buttons look like links -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <c:choose>
            	<c:when test="${currUser.isAdmin() }">
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
    
	
	
	<h1>Current items offered by you for sale</h1>
	<%if(existing.isEmpty()){ %>
		<h2>There are no registered publications</h2>
	<%} %>
	<c:choose>
		<c:when test="${nothingSelected eq 'true'}">
			<h2>Must select an item!</h2>
		</c:when>
		<c:when test="${paused eq 'true'}">
			<h2>Item already paused!</h2>
		</c:when>
		<c:when test="${active eq 'true'}">
			<h2>Item already activated!</h2>
		</c:when>
	</c:choose>
	<form action="control" method="post">
	<table border="3">
	<c:forEach var="loggedUser" items="${user.loggedInUser }"> <%--only one user --%>
		<%int i = 0; %>
		<%--<c:forEach var="item" items="${loggedUser.getRegisteredPublications()}"> --%> <%--each publications it has registered --%>
		<%for(DataHolder e : existing){ %>	
			<tr>
				<td><input type="radio" name="ownItems" value="<%out.println(i);%>">
					Title: <%out.println(e.get("title")); %>, 
					Year: <%out.println(e.get("year")); %>, 
					<%--Author(s): <c:out value="${item.getAuthor()}" />,  --%>
					<%--<c:choose>
						<c:when test="${item.isActive() eq 'false'}">
							Active: false
						</c:when>
						<c:otherwise>
							Active: true
						</c:otherwise>
					</c:choose> --%>
					<%	if(e.get("isVisible").equals(true)){ 
							out.println("Active: true");
						} else {
							out.println("Active : false");
						}
					%>
				</td>
			</tr>
			<% ++i; %>
			<%} %>
		<%--</c:forEach> --%>
	</c:forEach>
	</table>
		<input type="submit" name="action" value="activateItem">
		<input type="submit" name="action" value="pauseItem" >
	</form>
	
	<form action="search.jsp" method="post">
		<input type="submit" name="action" value="Back to Search"/>
	</form>
	
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