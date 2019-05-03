<%@ page language="java" contentType="text/html;  
charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first jsp</title>
</head>
<body>
<script>
var a=5;
function myFunction(demo){
	alert(demo);
}
</script>

<div id="demo" style="background-color:#ffaa00; width:100%; height:1000px;">
<h2>Hello World!</h2>
<button onclick="myFunction(demo)">点击这里</button>
</div>
</body>
</html>
