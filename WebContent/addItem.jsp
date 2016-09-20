<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cs9321ass2.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a publication for sale</title>
</head>
<body>
<center>
<h1>Enter publication details</h1>
<form action="control" method="post">
	<table>
		<tr>
			<td>Title: </td><td><input type="text" name="publishTitle"></td>
		</tr>
		<tr>
			<td>Author(separate multiple authors with ","): </td><td><input type="text" name="publishAuthor"></td>
		</tr>
		<tr>
			<td>Year: </td><td><input type="text" name="publishYear"></td>
		</tr>
	</table>
	<input type="hidden" name="action" value="addPublication">
	<input type="submit" value="Add Publication">
</form>
<form action="search.jsp" method="post">
	<input type="submit" name="action" value="Back to Search"/>
</form>
</center>
</body>
</html>