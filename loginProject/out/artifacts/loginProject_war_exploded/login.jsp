<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2021/10/14
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center">
    <form action="login" method="post" id="loginForm">
        姓名：<input type="text" name="uname" id="uname" value="${messageModel.object.userName}" ><br/>
        密码：<input type="password" name="upwd" id="upwd" value="${messageModel.object.userPwd}"><br/>
        <span id="msg" style="font-size: 12px; color: red">${messageModel.msg}</span><br/>
        <button type="button" id="loginBtn">登录</button>
        <button type="button">注册</button>
    </form>
</div>
</body>

<%-- 引入Jquery的js文件--%>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

    $("#loginBtn").click(function (){
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();

        if(isEmpty(uname)){
            //如果姓名为空，提示用户（span标签赋值），并且return html()
            $("#msg").html("用户姓名不可为空jsp！")
            return;
        }

        if(isEmpty(upwd)){
            $("#msg").html("用户密码不可为空jsp！");
            return;
        }

        //如果都不为空，提交表单
        $("#loginForm").submit();

    });

    function isEmpty(str){
        if(str == null || str.trim() == "")
            return true;
        return false;
    }


</script>

</html>
