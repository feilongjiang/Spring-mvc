<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body id="global">
	<form action="product_save.action"  method="post" >
	 <!--  围绕数据的Fieldset  -->
		<fieldset >
		<legend>Add a Product</legend>
		<p>
		<label for="name'">Product name: </label>
		<input type="text" name="name"  id = "name" tabindex="2" /> <br />
		</p>
		<p>
		<!--  当用户选择该标签时，浏览器就会自动将焦点转到和标签相关的表单控件上。  -->
		<label for="description" >Description:</label>
		 <input type="text" name="description"  id = "description"  tabindex="1" /> <br />
		 </p>
		 <p>
		 <label for="price" >Price: </label>
		  <input type="text" name="price"  id="price"  tabindex="3" /> <br />
		</p>
		<input type="reset" value="reset"  id ="reset" tabindex="5"/>
		<input type="submit" value="Add product"  id =" submit" tabindex="4"/>
		<p>
		</fieldset>
	</form>
</body>
</html>