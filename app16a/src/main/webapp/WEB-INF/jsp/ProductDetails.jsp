<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Save Product</title>
<style type="text/css">
	@import url(css/main.css);
</style>
</head>
<body>
<div id="global" >
		<h4>The product has been saved.</h4>
		<p>
			<h5>Details:</h5>
			ProductName: ${product.name }<br />
			productScription: ${product.description} <br />
			productPrice: $${product.price}
		</p>
</div>
</body>
</html>