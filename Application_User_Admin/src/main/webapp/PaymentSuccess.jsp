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
CustomerBean customerBean=(CustomerBean)session.getAttribute("cbean");
out.println("page belongs to customer :"+customerBean.getName()+"<br>");
String msg=(String)request.getAttribute("msg");
out.println(msg+"<br>");
%>
<a href="view2">View All Products</a>
<a href="logout">Logout</a>
</body>
</html>