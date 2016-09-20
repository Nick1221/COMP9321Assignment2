<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="shopcart" class="cs9321ass2.ShopCartBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your shopping cart</title>
</head>
<body>
<h1>Shopping Cart</h1>

<p>Your items</p>
<c:choose>
		<c:when test="${isEmpty eq 'true'}">
			<h1>Your shopping cart is empty!</h1>
		</c:when>
		<c:when test="${noneSelected eq 'true' }">
			<h1>No item selected</h1>
			<form action="control">
			<table border="3">
			<%int i = 0; %>
				<c:forEach var="item" items="${shopcart.publications}">
				<tr><td><input type="radio" name="inCarts" value="<%out.println(i);%>"><c:out value="${item}" /></td></tr>
				<%++i; %>
				</c:forEach>
			</table>
			<input type="hidden" name="action" value="removeFrCart">
			<input type="submit" value="Remove from Cart">
			</form>
		</c:when>
		<c:otherwise>
			<form action="control">
			<table border="3">
			<%int i = 0; %>
				<c:forEach var="item" items="${shopcart.publications}">
				<tr><td><input type="radio" name="inCarts" value="<%out.println(i);%>"><c:out value="${item}" /></td></tr>
				<%++i; %>
				</c:forEach>
			</table>
			<input type="hidden" name="action" value="removeFrCart">
			<input type="submit" value="Remove from Cart">
			</form>
		</c:otherwise>
</c:choose>
<br><br>
<form action="search.jsp" method="post">
	<input type="submit" name="action" value="Back to Search"/>
</form>
</body>
</html>