<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询用户</title>
<link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">
<style>
body {text-align:center;}
table {margin: auto;}
th, tr, td, table {
	border: 1px solid black;
}

</style>
</head>
<body>
	<a href="http://localhost:8080/myweb/pages/login.jsp">返回登录</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/students.jsp">返回主页</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/deleteUser.jsp">删除用户</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/updateUser.jsp">修改用户信息</a>
	<h1>用户查询</h1>
	<form action="http://localhost:8080/myweb/QueryUser" method="get">
		
			<table>
			<tr>
				<th>用户编号</th>
				<th>用户姓名</th>
				<th>用户密码</th>
				<th>性别</th>
				<th>年龄</th>
				<th>手机</th>
				<th>邮箱</th>
			</tr>
			<c:forEach items="${userList}" var="usr" varStatus="idx">
	        <tr>
	        	<td>${usr.id}</td> <td>${usr.username}</td> <td>${usr.password}</td> <td>${usr.sex}</td> 
	        	<td>${usr.age}</td> <td>${usr.phone}</td> <td>${usr.mail}</td> 
			</tr>
			</c:forEach>
			</table>
			<br/>
			<input type="submit"/>
		
	</form>

</body>
</html>