<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a
{
	text-decoration:none;
}
</style>
</head>
<body>
<%
String s=(String)request.getAttribute("msg");
out.println(s);
%>

<table>
<tr>
	<td><button><a href="Product.html">Add Product</a></button></td>
	<td><button><a href="view">View Product</a></button></td>
	<td><button><a href="logout">Logout</a></button></td>
</tr>
</table>
</body>
</html>