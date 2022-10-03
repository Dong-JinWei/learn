<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户信息修改</title>
	<script type="text/javascript" src="../static/js/jquery.js"></script>
	<script type="text/javascript" src="../static/js/jsutil.js"></script>
	<link rel="stylesheet" href="<%=path%>/static/css/other.css" type="text/css">
	
	<script type="text/javascript">
	
	$(function(){
		$("#sub_btn").click(function(){
			//用户ID
			var uidText = $("#uid").val();
			var uidPatt = /^\d{1,10}$/;
			if(!uidPatt.test(uidText)){
				$("#updateMsg").html("用户ID不合法");
				return false;
			}
			//判断用户名
			var unameText = $("#uname").val();
			if(isEmpty(unameText)){
				$("#updateMsg").html("用户名不合法");
				return false;
			}
			//判断密码
			var upwdText = $("#upwd").val();
			var upwdText2 = $("#upwd2").val();
			if(isEmpty(upwdText)){
				$("#updateMsg").html("密码不能为空");
				return false;
			}
			if(isEmpty(upwdText2)){
				$("#updateMsg").html("确认密码不能为空");
				return false;
			}
			if (upwdText != upwdText2){
				$("#updateMsg").html("密码不一致");
				return false;
			}
			
			//年龄
			var ageText = $("#age").val();
			if(isEmpty(ageText)){
				$("#updateMsg").html("年龄不能为空")
				return false;
			}
			
			//判断手机号
			var numberText = $("#number").val();
			if(isEmpty(numberText)){
				$("#updateMsg").html("手机号不能为空");
				return false;
			}
			
			
			//判断邮箱
			var mailText = $("#mail").val();
			var mailPatt = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			if(isEmpty(mailText)){
				$("#updateMsg").html("邮箱不能为空");
				return false;
			}
			if(!mailPatt.test(mailText)){
				$("#updateMsg").html("邮箱不合法");
				return false;
			}
			
			
			
			$("#updateMsg").html("");
			$("#updateForm").submit();
		});
		
	
	});
		
	
	</script>
	
</head>
<body>

<div style="text-align: center">
	<a href="http://localhost:8080/myweb/pages/login.jsp">返回登录</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/students.jsp">返回主页</a>&nbsp; &nbsp;
	<a href="http://localhost:8080/myweb/pages/queryUser.jsp">查看用户信息</a>
	<h1>用户信息修改</h1>
	
	<form action="http://localhost:8080/myweb/UpdateUser" method="post" id="updateForm">

	<p>
	用户&nbsp; &nbsp;ID：<input type="text" placeholder="请输入用户ID" name="uid" id="uid"><br>
	用户姓名：<input type="text" placeholder="请输入用户名" name="uname" id="uname"><br>
	密&nbsp; &nbsp; &nbsp; &nbsp;码：<input type="password" placeholder="请输入用户密码" name="upwd" id="upwd"><br>
	确认密码：<input type="password" placeholder="请再次输入密码" name="upwd2" id="upwd2"><br>
	性&nbsp; &nbsp; &nbsp; &nbsp;别：<input type="radio" name="sex" value="男" id="sex">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="sex" value="女" id="sex">女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
	年&nbsp; &nbsp; &nbsp; &nbsp;龄：<input type="text" placeholder="请输入年龄" name="age" id="age"><br>
	手&nbsp; &nbsp; &nbsp; &nbsp;机：<input type="text" placeholder="请输入手机号" name="number" id="number"><br>
	邮箱地址：<input type="text" placeholder="请输入邮箱" name="mail" id="mail"><br>
	
	<span id="updateMsg" style="font-size: 12px; color: red">${updateMessage}</span><br/>
	</p>
	<input type="button" id="sub_btn" value="立即修改"><br/>
	</form>

</div>


</body>
</html>