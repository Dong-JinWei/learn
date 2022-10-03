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
<title>查询学生</title>
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
	<h1>学生查询</h1>
	<form action="http://localhost:8080/myweb/FindStudents" method="get">
		
			<table>
			<tr>
				<th>学生编号</th>
				<th>学生姓名</th>
				<th>学生班级</th>
				<th>性别</th>
				<th>专业</th>
				<th>所属院系</th>
				<th>年龄</th>
				<th>手机</th>
			</tr>
			<c:forEach items="${studentsList}" var="stu" varStatus="idx">
	        <tr>
	        	<td>${stu.id}</td> <td>${stu.username}</td> <td>${stu.sclass}</td> <td>${stu.sex}</td> 
	        	<td>${stu.spec}</td> <td>${stu.dept}</td> <td>${stu.sage}</td> <td>${stu.phone}</td> 
			</tr>
			</c:forEach>
			</table>
			<br/>
			<input type="submit"/>
		
	</form>

</body>
</html>