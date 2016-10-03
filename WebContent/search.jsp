<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*" %>
<jsp:useBean id="shopcart" class="cs9321ass2.ShopCartBean" scope="session" />
<jsp:useBean id="result" class="cs9321ass2.ResultsBean" scope="session" />
<jsp:useBean id="detail" class="cs9321ass2.DetailBean" scope="session" />
<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Library Assignment 2">
    <meta name="author" content="">
    
	<title>Search Page - Digital Bibliographic Library</title>
	
	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
</head>

<%
	//here, if  have to show 10 items, extrct shld happen here?
	ControlServlet cs = new ControlServlet();
%>

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
    
    <div class="col-lg-6" align="center">
		<form action="control">
			<fieldset>
				<h2>Enter details of publication to look-for</h2>
				<%-- <textarea name="searchCriteria" rows="2" cols="20"></textarea> --%>
				<input type="text" name="input1">
				<input type="hidden" name="action" value="mainSearch">
				<input type="submit" class="btn btn-info" value="Submit">
			</fieldset>
		</form>
	</div>
	
	<div class="col-lg-6" align="center">
		<form action="control">
			<fieldset>
				<h2>Specific search(case-sensitive)</h2>

				<h2>Advanced search(case-sensitive)</h2>

				<table>
					<tr>
						<td>Year: </td><td> <input type="text" name="year"></td>
					</tr>
					<tr>
						<td>Address: </td><td> <input type="text" name="address"></td>
					</tr>
					<tr>
						<td>Author: </td><td> <input type="text" name="author"></td>
					</tr>
					<tr>
						<td>Publisher: </td><td> <input type="text" name="publisher"></td>
					</tr>
					<tr>
						<td>ISBN: </td><td> <input type="text" name="isbn"></td>
					</tr>
				</table>
				<input type="hidden" name="action" value="specSearch">
				<input type="submit" class="btn btn-info" value="Submit">
			</fieldset>
		</form>
	</div>
	
	<div class="row">
		<div class="col-lg-12" align="center" style="overflow: auto">
			<form action="control">
				<fieldset>
					<legend>Titles that you might be interested in</legend>
					<%--10 random objs of publications, then maybe a button(Details)/(Buy) beside them --%>
					<table border="3" style="width:100%">
						<tr>
							<th>Title</th>
							<th>Author</th>
							<th>Key</th>
						</tr>
						<% List<Publication> itemsToShow = cs.getRandomObjs(); 
							for(Publication p : itemsToShow)
							{ %>
						<tr>
							<td><input type="radio" name="randoms" value="<%out.println(p.getKey());%>"><%out.println(p.getTitle());%></td>
							<td><%out.println(p.getAuthor());%></td>
							<td><%out.println(p.getKey());%></td>
							<%--<td><input type="hidden" name="action" value="detail">
							<input type="submit" value="Find Details"></td> --%>
						</tr>
							<%} %>
					</table>
					<input type="hidden" name="action" value="getdetail">
					<input type="submit" value="Find Details">
				</fieldset>
			</form>
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