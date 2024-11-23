<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ProductBean productBean=(ProductBean)session.getAttribute("pbean");
CustomerBean customerBean=(CustomerBean)session.getAttribute("cbean");
out.println("This page belongs to Customer : "+customerBean.getName());
%>
<form action="generateBill" method="post">
<table>
<tr>
<td>
	Product Code :
</td>
<td>
	<%= productBean.getPcode() %>
</td>
</tr>
<tr>
<td>
	Product Name :
</td>
<td>
	<%= productBean.getPname() %>
</td>
</tr>
<tr>
<td>
	Available Qty :
</td>
<td>
	<%= productBean.getPqty() %>
</td>
</tr>
<tr>
<td>
	Required Qty :
</td>
<td>
	<input  width=10px type="text" name="qty" placeholder="Enter the Qty ">
</td>
</tr>

<tr>
<td>

</td>
<td>
	<button type="submit">Generate Bill</button>
</td>
</tr>
	
</table>
</form>
</body>
</html>