<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="result" class="cs9321ass2.ResultsBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
	<h1>Search results</h1>
	<c:choose>
		<c:when test="${isEmpty eq 'true'}">
			<h1>Sorry, no matching datasets found!</h1>
		</c:when>
		<c:when test="${noneSelected eq 'true'}">
			<h1>Sorry, no publication has been selected</h1>
			<form action="control">
				<table border="2">
					<%int i = 0; %>
					<c:forEach var="rslt" items="${result.results}">
					<tr><td><input type="radio" name="srchRslts" value="<%out.println(i);%>"><c:out value="${rslt}" /></td></tr>
					<%++i; %>
					</c:forEach>
				</table>
				<input type="hidden" name="action" value="addtocartFrSearchResult">
				<input type="submit" value="Add to Cart">
			</form>
		</c:when>
		<c:otherwise>
			<form action="control">
			<table border="2">
				<%--<c:set var="total" scope="session" value="${fn:length(result.results)}"/>
				<c:set var="perPage" scope="session"  value="10"/>
				<c:set var="pageStart" value="${param.start}"/>
				<c:if test="${empty pageStart or pageStart < 0}">
				    <c:set var="pageStart" value="0"/>
				</c:if>
				<c:if test="${total <= pageStart}">
				    <c:set var="pageStart" value="${pageStart - perPage}"/>
				</c:if>  --%>
				<%int i = 0; %>
				<c:forEach var="rslt" items="${result.results}"><%--begin="${pageStart}" end="${pageStart + perPage - 1}"--%>
				<tr><td><input type="radio" name="srchRslts" value="<%out.println(i);%>"><c:out value="${rslt}" /></td></tr>
				<%++i; %>
				</c:forEach>
			</table>
			<input type="hidden" name="action" value="addtocartFrSearchResult">
			<input type="submit" value="Add to Cart">
			</form>
			<%--<a href="?start=${pageStart - perPage}">Previous</a> ${pageStart +1} - ${pageStart + perPage} of ${total}--%>
			<%--<a href="?start=${pageStart + perPage}">Next</a><br/> --%>
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
</body>
</html>