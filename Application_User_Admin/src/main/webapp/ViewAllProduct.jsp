<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*,java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
background-color:rgb(123,453,456);
}
a
{
text-decoration:none;
}
</style>
</head>
<body>
<div style="color:blue">
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("alist");
out.println("All the Product are in  this Page ,"+ab.getFname()+"<br>");
if(al.size()==0)
{
	out.println("Product  Not Available");
}
else
{
	Iterator<ProductBean> it=al.iterator();
	
	while(it.hasNext())
	{
		ProductBean pb=it.next();
		out.println(pb.toString()+"<a href='edit?pcode="+pb.getPcode()+"'>Edit</a>"+"&nbsp;&nbsp"+"<a href='delete?pcode="+pb.getPcode()+"'>Delete</a>"+"<br>");
	}
}
%>
<a href="Product.html">Product</a>
<a href="logout">Logout</a>
</div>
</body>
</html>