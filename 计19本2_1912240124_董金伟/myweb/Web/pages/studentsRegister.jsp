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
    <title>注册信息</title>
	<script type="text/javascript" src="../static/js/jquery.js"></script>
	<script type="text/javascript" src="../static/js/jsutil.js"></script>
	<link rel="stylesheet" href="<%=path%>/static/css/register.css" type="text/css">
	
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
			//班级
			var sclassText = $("#sclass").val();
			if(isEmpty(sclassText)){
				$("#msg").html("班级不能为空")
				return false;
			}
			//专业
			var specText = $("#spec").val();
			if(isEmpty(specText)){
				$("#msg").html("专业不能为空")
				return false;
			}
			//学院
			var sdeptText = $("#sdept").val();
			if(isEmpty(sdeptText)){
				$("#msg").html("学院不能为空")
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
			
			
			$("#msg").html("");
			$("#studentsRegisterForm").submit();
		});
		
	
	});
		
	
	</script>
	
</head>
<body>

<div class="login-box">
	<a href="./students.jsp">返回查询</a>
	<h1>注册信息</h1>
	<div class="input-box">
	<form action="http://localhost:8080/myweb/StudentsRegisterServlet" method="get" id="studentsRegisterForm">

	<div class="input-text">
	<input type="text" placeholder="请输入用户ID" name="uid" id="uid"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入用户名" name="uname" id="uname"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入班级" name="sclass" id="sclass"><br>
	</div>
	
	<div class="input-text">
	<input type="radio" name="sex" value="男" id="sex">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="sex" value="女" id="sex">女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入专业" name="spec" id="spec"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入学院" name="sdept" id="sdept"><br>
	</div>
	
	<div class="input-text">
	<input type="text" placeholder="请输入年龄" name="age" id="age"><br>
	
	</div>

	<div class="input-text">
	<input type="text" placeholder="请输入手机号" name="number" id="number"><br>
	</div>
	
	<div class="input-text">
	<span id="msg" style="font-size: 12px; color: red">${message}</span><br/>
	</div>
	

	<input class="input-btn" type="button" id="sub_btn" value="立即注册"><br/>
	<p>
	    注册成功后请重新登录！<a href="login.jsp">点击登录</a> 
	</p>
	</form>
	
	</div>
</div>

</body>
</html>