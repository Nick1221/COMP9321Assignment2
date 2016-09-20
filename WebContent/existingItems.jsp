<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Existing items offered for sale</title>
</head>
<body>
	<h1>Current items offered by you for sale</h1>
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
		<c:forEach var="item" items="${loggedUser.myRegisteredPublications}"> <%--each publications it has registered --%>
			<tr>
				<td><input type="radio" name="ownItems" value="<%out.println(i);%>">
					Title: <c:out value="${item.getTitle()}" />, 
					Year: <c:out value="${item.getYear()}" />, 
					Author(s): <c:out value="${item.getAuthor()}" />, 
					<c:choose>
						<c:when test="${item.isActive() eq 'false'}">
							Active: false
						</c:when>
						<c:otherwise>
							Active: true
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<% ++i; %>
		</c:forEach>
	</c:forEach>
	</table>
		<input type="submit" name ="action" value="activateItem" placeholder="Activate Item">
		<input type="submit" name="action" value="pauseItem" placeholder="Pause Item">
	</form>
	
	<form action="search.jsp" method="post">
		<input type="submit" name="action" value="Back to Search"/>
	</form>
</body>
</html>