<%--
  Created by IntelliJ IDEA.
  User: hkarling
  Date: 2019-06-24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    String addr = request.getParameter("addr");
    String id = request.getParameter("id");
%>
<h2><%=addr%><br><%=id%></h2>
</body>
</html>
