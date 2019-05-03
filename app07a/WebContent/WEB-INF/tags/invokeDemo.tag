<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="productDetails"  fragment="true"  %>
<!--  因为invoke 是用来调用fragment 的,如果fragment="false" 的话 连续按F5刷新页面会报错 -->
<%@ variable name-given="productName"  %>
<%@ variable name-given="description"  %>
<%@ variable name-given="price"  %>
<%
	jspContext.setAttribute("productName", "Pelesonic DVD Player");
	jspContext.setAttribute("description","Dolby Digital output through coaxial digital-audio jack,"
						+" 500 lines horizontal resolution-image digest viewing");
	jspContext.setAttribute("price",65);
%>
<jsp:invoke fragment="productDetails" />