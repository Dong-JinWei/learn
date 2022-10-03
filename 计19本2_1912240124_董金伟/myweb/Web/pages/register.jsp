<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
	<script type="text/javascript" src="../static/js/jquery.js"></script>
	<script type="text/javascript" src="../static/js/jsutil.js"></script>
	<link rel="stylesheet" href="../static/css/register.css" type="text/css">
	<script type="text/javascript">
	
	$(function(){
		$("#sub_btn").click(function(){
			//用户ID
			var uidText = $("#uid").val();
			var uidPatt = /^\d{1,10}$/;
			if(!uidPatt.test(uidText)){
				$("#msg").html("用户ID不合法");
				return false;
			}
			//判断用户名
			var unameText = $("#uname").val();
			if(isEmpty(unameText)){
				$("#msg").html("用户名不合法");
				return false;
			}
			//判断密码
			var upwdText = $("#upwd").val();
			var upwdText2 = $("#upwd2").val();
			if(isEmpty(upwdText)){
				$("#msg").html("密码不能为空");
				return false;
			}
			if(isEmpty(upwdText2)){
				$("#msg").html("确认密码不能为空");
				return false;
			}
			if (upwdText != upwdText2){
				$("#msg").html("密码不一致");
				return false;
			}
			
			//年龄
			var ageText = $("#age").val();
			if(isEmpty(ageText)){
				$("#msg").html("年龄不能为空")
				return false;
			}
			
			//判断手机号
			var numberText = $("#number").val();
			if(isEmpty(numberText)){
				$("#msg").html("手机号不能为空");
				return false;
			}
			
			
			//判断邮箱
			var mailText = $("#mail").val();
			var mailPatt = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			if(isEmpty(mailText)){
				$("#msg").html("邮箱不能为空");
				return false;
			}
			if(!mailPatt.test(mailText)){
				$("#msg").html("邮箱不合法");
				return false;
			}
			
			
			
			$("#msg").html("");
			$("#registerForm").submit();
		});
		
	
	});
		
	
	</script>
	
</head>
<body>

<div class="login-box">
	<h1>注册</h1>
	<div class="input-box">
		<form action="http://localhost:8080/myweb/RegisterServlet" method="post" id="registerForm">

	
	<div class="input-text">
	<input type="text" placeholder="请输入用户ID" name="uid" id="uid"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入用户名" name="uname" id="uname"><br>
	</div>
	
	<div class="input-text">
	<input type="password" placeholder="请输入用户密码" name="upwd" id="upwd"><br>
	</div >
	<div class="input-text">
	<input type="password" placeholder="请再次输入密码" name="upwd2" id="upwd2"><br>
	</div>
	
	<div class="input-text">
	<input type="radio" name="sex" value="男" id="sex">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="sex" value="女" id="sex">女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入年龄" name="age" id="age"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入手机号" name="number" id="number"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入邮箱" name="mail" id="mail"><br>
	</div>

	<span  id="msg" style="font-size: 12px; color: red">${message}</span><br/>

	<input class="input-btn" type="button" id="sub_btn" value="立即注册"><br/>
	
	<p>
    已有账号？<a href="login.jsp">点击登录</a> 
    </p>
    </form>
    
	</div>
</div>
</body>
</html>