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
<title>课程选择</title>

<style>
body {text-align:center;}
</style><link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">
</head>
<body>
<a href="http://localhost:8080/myweb/pages/students.jsp">返回主页</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/scoreinput.jsp">输入成绩</a>&nbsp; &nbsp;
<h1>课程选择</h1>
	<form action="http://localhost:8080/myweb/CourseAndScorseServlet2" method="get" accept-charset="utf-8" >
		<h2>选择你的课程</h2>
		<p>
			JavaWeb：<input type="checkbox" name="courses[1]" id="courses[1]" value="javaweb" />&nbsp; &nbsp; &nbsp; &nbsp;
			MySQ：<input type="checkbox" name="courses[2]" id="courses[2]" value="mysql" />&nbsp; &nbsp; &nbsp; &nbsp;
			Java：<input type="checkbox" name="courses[3]" id="courses[3]" value="java" />&nbsp; &nbsp; &nbsp; &nbsp;<br/>
			
		</p>
		<span id="courseMsg" style="font-size: 12px; color: red" >${scoreSucces}</span><br/>
		<input class="input-btn"  type="submit"/>
	</form>
	
</body>
</html>