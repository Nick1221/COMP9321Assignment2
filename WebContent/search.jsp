<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="shopcart" class="cs9321ass2.ShopCartBean" scope="session" />
<jsp:useBean id="result" class="cs9321ass2.ResultsBean" scope="session" />
<jsp:useBean id="detail" class="cs9321ass2.DetailBean" scope="session" />
<jsp:useBean id="user" class="cs9321ass2.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page - Digital Bibliographic Library</title>
</head>

<%
	//here, if  have to show 10 items, extrct shld happen here?
	ControlServlet cs = new ControlServlet();
%>
<body>
<center>
<h1>Digital Bibliographic Library</h1>
<form action="control">
	<fieldset>
		<legend>Enter details of publication to look-for(case-sensitive)</legend>
		<%-- <textarea name="searchCriteria" rows="2" cols="20"></textarea> --%>
		<input type="text" name="input1"><br>
		<input type="hidden" name="action" value="mainSearch">
		<input type="submit" value="Search">
	</fieldset>
</form>
<form action="control">
	<fieldset>
		<legend>Specific search(case-sensitive)</legend>
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
		<input type="submit" value="Search">
	</fieldset>
</form>
<form action="control">
	<fieldset>
		<legend>10 potential items of interest</legend>
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
</center>
<form action="control" method="post">
	<input type="hidden" name="action" value="shopCart">
	<input type="submit" value="Shopping Cart">
</form>
<form action="addItem.jsp" method="post">
	<input type="submit" value="Register a Publication">
</form>
<form action="existingItems.jsp" method="post">
	<input type="submit" value="See my existing publications">
</form>
</body>
</html>