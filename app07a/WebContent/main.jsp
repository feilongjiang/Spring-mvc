<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Your referer header: ${header.referer}
<br/>
<tags:doBodyDemo>
${header.referer} <!--  这个值会传给doBodyDemo.tag 里的 referer1 变量-->
</tags:doBodyDemo>
<a href="viewReferer.jsp">View</a> the referer as a Session attribute.
</body>
</html>