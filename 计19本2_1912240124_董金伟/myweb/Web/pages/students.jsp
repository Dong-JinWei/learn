<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
<link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">

<style>
body {text-align:center;}
table {margin: auto;}

a.button {
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
}
</style>

</head>
<body>

<a href="http://localhost:8080/myweb/pages/courseAndScorse.jsp">查询成绩</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/login.jsp">返回登录</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/queryUser.jsp">查询所有用户</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/updateUser.jsp">修改用户信息</a>&nbsp; &nbsp;
<a href="http://localhost:8080/myweb/pages/findStudents.jsp">查询所有学生</a>&nbsp; &nbsp;
	<div style="text-align: center">
	<h2>
		登录成功！欢迎【<span id="msg" style="color: red" >${loginName}</span>】！<br/>
	</h2>
	
	<h1>个人信息查询</h1>
	    <form action="http://localhost:8080/myweb/StudentsServlet" method="get" id="studentFrom">
	        <span id="msg" style="font-size: 12px; color: red">${studentsMassage}</span><br/>
	        <span id="msg" style="font-size: 12px; color: red">${scoreSucces}</span><br/>
	        
	        <button type="submit" name="sButton" id="sButton" >查询信息</button>&nbsp;&nbsp;
	    </form>
	    
	    没有查到？<a href="http://localhost:8080/myweb/pages/studentsRegister.jsp">点击注册或修改信息</a>
	</div>
	
		<br>
	
	
	<div style="align:center">
	<table border="1">
    <tr>
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>用户班级</th>
        <th>用户性别</th>
        <th>用户专业</th>
        <th>用户院系</th>
        <th>用户年龄</th>
        <th>用户手机</th>
    </tr>
    <tr>
        <td>${messageId}</td>
        <td>${messageSname}</td>
        <td>${messageSclass}</td>
        <td>${messageSsex}</td>
        <td>${messageSpec}</td>
        <td>${messageSdept}</td>
        <td>${messageSage}</td>
        <td>${messageSphone}</td>
    </tr>
</table>
	
	</div>
</body>
</html>