<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Country list</title>
</head>
<body>
we operate in these countries:
<c:set var="hello" value="how do you do"   scope="session" />
<%
    model.Product product = new Product();
	product.setId("1");
	product.setName("d");
	product.setPrice(1.5);
	session.setAttribute("Product",product);
%>
</body>
</html>