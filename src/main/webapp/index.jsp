<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		<input type="text" name="username">
		<input type ="text" name="password">
		<input type ="submit" name="Login">
	</form> 
</body>
</html>