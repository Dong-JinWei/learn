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
<link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">

<style>
body {text-align:center;}
</style>
</head>
<body>

<a href="http://localhost:8080/myweb/pages/students.jsp">返回主页</a>&nbsp; &nbsp;

<h1>成绩录入</h1>
	<form action="http://localhost:8080/myweb/ScoreInput" method="get" accept-charset="utf-8" >
		<h2>请输入你的成绩</h2>
		<div style="centet">
		<p>
			JavaWeb：<input type="text" name="JavaWeb" id="JavaWeb"><br/>
			MySQL&nbsp; &nbsp;：<input type="text" name="MySQL" id="MySQL"><br/>
			JAVA&nbsp; &nbsp; &nbsp; &nbsp;：<input type="text" name="JAVA" id="JAVA"><br/>
		</p>
		
		<span id="scoremsg" style="font-size: 12px; color: red" >${scoreMessage}</span><br/>
		<span id="scoremsg" style="font-size: 12px; color: red" >${courseSucces}</span><br/>
		<span id="scoremsg" style="font-size: 12px; color: red" >${scoreSucces}</span><br/>
		
		<input type="submit" name="scoreinputBtn" name="scoreinputBtn"/>
		
		</div>
		
		
	</form>
	
</body>

<script>
$(function(){
	$("#scoreinputBtn").click(function (){
		var javaWeb = $("#JavaWeb").val();
		var mySQL = $("#MySQL").val();
		var java = $("#JAVA").val();
		
		if(isEmpty(javaWeb)){
			$("#scoremsg").html("JavaWeb成绩不能为空！");
			return;
		}
		
		if(isEmpty(mySQL)){
			$("#scoremsg").html("MySQL成绩不能为空！");
			return;
		}
		if(isEmpty(java)){
			$("#scoremsg").html("java成绩不能为空！");
			return;
		}
		
		if((javaWeb > 0  || javaWeb < 100) && () &&()){
			$("#loginForm").submit();
		}else{
			$("#scoremsg").html("成绩不合法，请输入有效的成绩！");
			return;
		}
		
		
	});
});

</script>
</html>