<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
accept-language: ${header['accept-language']}
<br />
session id: ${pageContext.session.id }
<br />
employee: ${requestScope.employee.name}, ${employee.address.city}
<br />
capital: ${capitals["Canada"]}
<br />
<c:forEach var="capital"  items="${capitals}">
${capital}, 
</c:forEach>

</body>
</html>