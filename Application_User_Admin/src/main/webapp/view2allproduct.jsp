<%@page import="com.mysql.cj.xdevapi.Table"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{
text-decoration:none;
}
</style>
</head>
<body>
<%
CustomerBean customerBean=(CustomerBean)session.getAttribute("cbean");
out.println("Page Belongs to Customer :"+customerBean.getName()+"<br>");
ArrayList<ProductBean> alist=(ArrayList<ProductBean>)session.getAttribute("alist");
	Iterator<ProductBean> it=alist.iterator();
	while(it.hasNext())
	{
		ProductBean productBean=it.next();
		
		out.println(productBean.toString()+" <a href='buy?pcode="+productBean.getPcode()+"'>Buy</a>"+"<br>");
		
	}
	
%>
<a href="logout">Logout</a>
</body>
</html>