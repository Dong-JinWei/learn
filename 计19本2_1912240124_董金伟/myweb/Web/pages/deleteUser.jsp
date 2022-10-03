<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除用户</title>

<script type="text/javascript" src="<%=path%>/static/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jsutil.js"></script>
<link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">
<script type="text/javascript">

function submitBt(){
	var deleteUser = $("#deleteUser").val();
	if(isEmpty(deleteUser)){
		$("#deleteUserMsg").html("用户ID不能为空！");
		return;
	}
	$("#deleteFrom").submit();
}

</script>  

<title>查询用户</title>
<style>
body {text-align:center;}


</style>

</head>


<body>
	<a href="http://localhost:8080/myweb/pages/login.jsp">返回登录</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/students.jsp">返回主页</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/queryUser.jsp">返回查询</a>
	<h1>删除用户</h1>
	
	<form action="http://localhost:8080/myweb/DeleteUser" method="get" id="deleteFrom">
		输入要删除的用户编号：<input type="text" name="deleteUser" id="deleteUser"><br/>
		<span id="deleteUserMsg" style="font-size: 12px; color: red" >${deleteUserMsg}</span><br/>
		<button type="button"  name="deleteButton" id="deleteButton" onclick="submitBt()">提交</button>
		
	</form>

</body>
</html>