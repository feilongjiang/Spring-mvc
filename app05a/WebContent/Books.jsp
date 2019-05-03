<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books list</title>
<style>
table, tr, td {
	border: 1px, solid brown;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>ISB</td>
			<td>Title</td>
		</tr>
		<c:forEach var="book" items="${requestScope.books}">
			<tr>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
			</tr>
</c:forEach>

	</table>
	Books in Styled Table
	<table>
		<tr style="background: #ababff">
			<td>ISBN</td>
			<td>Title</td>
		</tr>
		<c:forEach items="${requestScope.books}" var="book" varStatus="status">
			<c:if test="${status.count%2 == 0}">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2 != 0}">
				<tr style="background: #dedeff">
			</c:if>
			<td>${book.isbn}</td>
			<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>

ISBNs only:
	<c:forEach items="${requestScope.books }"  var="book"	 varStatus="status">
		${book.isbn}<c:if test="${!status.last}">,</c:if>
	</c:forEach>
</body>
</html>