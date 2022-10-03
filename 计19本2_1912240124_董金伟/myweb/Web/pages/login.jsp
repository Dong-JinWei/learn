<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>

    <script type="text/javascript" src="<%=path%>/static/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/jsutil.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$("#loginBtn").click(function (){
			var ID = $("#ID").val();
			var uname = $("#uname").val();
			var upwd = $("#upwd").val();
			
			if(isEmpty(ID)){
				$("#msg").html("用户ID不能为空！");
				return;
			}
			
			if(isEmpty(uname)){
				$("#msg").html("用户名不能为空！");
				return;
			}
			if(isEmpty(upwd)){
				$("#msg").html("用户密码不能为空！");
				return;
			}
			
			$("#loginForm").submit();
		});
	});
	

	</script>  
<link rel="stylesheet" href="<%=path%>/static/css/login.css" type="text/css">
</head>
<body>
<div class="login-box">
		<h1>登录页面</h1>
		
		<div class="input-box">
	    <form action="http://localhost:8080/myweb/LoginServlet" method="post" id="loginForm">
		   
		   <div class="input-text">
		   <input type="text" name="ID" id="ID" placeholder="ID"><br/>
		   </div>
		   
		   <div class="input-text">
		        <input type="text" name="uname" id="uname" placeholder="用户名"><br/>
		    </div>
		    
		   <div class="input-text">
		       <input type="password" name="upwd" id="upwd" placeholder="密码"><br/>		   
		  </div>

				<p>
				    还没有账户？<a href="register.jsp">点击立即注册</a> 
				<p>
	        <span id="msg" style="font-size: 12px; color: red" >${message}</span><br/>
	        <button class="input-btn" type="button" id="loginBtn">登录</button>
	    </form>
		</div>
	
</div>

</body>
</html>