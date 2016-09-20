<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="shopcart" class="cs9321ass2.ShopCartBean" scope="session" />
<jsp:useBean id="detail" class="cs9321ass2.DetailBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Full detail</title>
</head>
<body>
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