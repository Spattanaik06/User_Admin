<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
background :cornsilk;
}
</style>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Wel Come to the Portal ," +ab.getFname()+"<br>");

%>

<div>
<table>
<tr>
	<td><button><a href="Product.html">Add Product</a></button></td>
	<td><button><a href="view">View Product</a></button></td>
	<td><button><a href="logout">Logout</a></button></td>
</tr>
</table>
</div>
</body>
</html>