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
out.println("Page belongs to Customer :"+customerBean.getName());
//float qty=(float)Float.parseFloat(request.getParameter("qty"));
float qty=(float)session.getAttribute("quantity");
%>
<form action="payment" method="post">
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
	Bill Amount :
</td>
<td>
	<%=productBean.getPprice() * qty %>
</td>
</tr>

<tr>
<td>

</td>
<td>
	<button type="submit">Payment</button>
</td>
</tr>
	
</table>
</form>
</body>
</html>