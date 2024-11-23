<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("The page belongs to"+ab.getFname()+"<br>");
ProductBean pb=(ProductBean)request.getAttribute("pbean");
%>
<table>
<form action="update" method="post">
<input type="hidden" name="pcode" value="<%=pb.getPcode() %>">
<tr>
<td>
Product Price :
</td>
<td>
<input type="text" name="price" value="<%=pb.getPprice() %>"><br></td>
</tr>
<tr>
<td>

Product Qty :
</td>
<td>
<input type="text" name="pqty" value="<%=pb.getPqty() %>"><br></td>
</tr>
<tr>
<td></td>
<td>
<button type="submit">Update</button>
</td>
</tr>
</form>
</table>
<body>
</body>
</html>