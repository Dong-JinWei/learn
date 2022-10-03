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
<title>课程与成绩查询</title>
 <link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">

<style>
th, tr, td, table {
	border: 1px solid black;
}


body {text-align:center;}
table {margin: auto;}

</style>
</head>
<body>

<a href="http://localhost:8080/myweb/pages/login.jsp">返回登录</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/students.jsp">返回主页</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/courseAndScorse2.jsp">选择课程</a>
	<h1>查询课程与成绩</h1>
	<h1>【<span id="msg" style="color: red" >${loginName}</span>】的成绩如下！<br/></h1>
	
	
	<form action="http://localhost:8080/myweb/CourseAndScorseServlet" method="get">
        <span id="msg" style="font-size: 12px; color: red">${studentsMessage}</span>
        
        <button type="submit" name="sButton" id="sButton" value= "${loginName}" >查询成绩</button>&nbsp;&nbsp;<br/>
        
    </form>
	
	<table>
		<tr>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>授课教师</th>
			<th>成绩</th>
		</tr>
		<c:forEach items="${ScorseList}" var="usr" varStatus="idx">
        <tr>
        	<td>${usr.cno}</td> <td>${usr.cname}</td> <td>${usr.ctecher}</td> <td>${usr.score}</td> 
		</tr>
		</c:forEach>
	</table>
	
	<p style="color: red">如果没有成绩，请先选择课程，并录入成绩。</p>
 
</body>
</html>