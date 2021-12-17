<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mvc.model.UserContentBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged in</title>
</head>
<body>
	<%
    	UserContentBean printBean = (UserContentBean)request.getAttribute("printBean");
    	out.print(printBean.getToPrint());
	%>
	
	
</body>
</html>