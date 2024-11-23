<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
out.println("Welcome to This Site ,"+cb.getName()+"<br>");
%>
<a href="view2">View Product</a>
<a href="logout">Logout</a>
</body>
</html>