<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add product form</title>
<style type="text/css">
@import
url("css/main.css")
</style>
</head>
<body>
	<div id="global">
		<form action="product_save" method="post">
			<fieldset>
				<legend>add a product</legend>
				<p>
					<label for="name">product Name</label> <input type="text"
						placeholder="请输入名字" />
				</p>
				<p>
					<label for="description">Description: </label> <input type="text"
						id="description" name="description" tabindex="2">
				</p>
				<p>
					<label for="price">Price: </label> <input type="text" id="price"
						name="price" tabindex="3">
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Add Product">
				</p>

			</fieldset>
		</form>
	</div>
</body>
</html>