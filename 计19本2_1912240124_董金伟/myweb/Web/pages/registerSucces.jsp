<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功</title>
<link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">
<style type="text/css">

	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color: red;
	}
</style>

</head>
<body>

	<h1>
		注册成功<a href="/myweb/pages/login.jsp">点击登录</a>	
	</h1>

</body>
</html>