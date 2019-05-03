<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productform</title>
<style>
@import url("css/main.css");
</style>
</head>
<body>
	<div id="gloable">
		<form action="product_save.action" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<label for="name">name: </label> <input type="search" id="name"
					name="name" placeholder="请输入" tabindex="1" /> <label
					for="description">Description: </label> <input type="text"
					id="description" name="description" tabindex="2"> <label
					for="price">Price: </label> <input type="text" id="price"
					name="price" tabindex="3">
				<div id="buttons">
					<label for="dummy"> </label> <input id="reset" type="reset"
						tabindex="4"> <input id="submit" type="submit"
						tabindex="5" value="Add Product">
						</div>
			</fieldset>
		</form>
	</div>
</body>
</html>