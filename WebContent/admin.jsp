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
	<title>Admin Panel - Digital Bibliographic Library</title>
	
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
	<h1>Admin Control Panel</h1>
	
	<!-- Ban a user interface -->
	<!-- Show list of users-->
	<!-- Check user and ban user button here -->
	<div class="col-lg-6">
		<form action="">
			
		</form>
	</div>
	
	<!-- When user is selected show the list of items purchased -->
	<!-- Here is where find detail button is(Should be the same as the other ones) -->
	<div class="col-lg-6">
		<form action="">
			
		</form>
	</div>
	
	<!-- Search and toggle item availibility -->
	<!-- Perform a search here (Need to add a admin specific button on results.jsp -->
	<div class="col-lg-6">
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