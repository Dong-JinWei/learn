<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/23
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>注册</title>
    </head>
    <script src="js/jquery.min.js"></script>
    <script>
        let isRegister = true;
        let isPassword = false;
        $(document).ready(function (){
            $("#username").blur(function (){
                ajaxFindUser();
            });
            $("#username").focus(function (){
                $("#username_error").attr("hidden", "hidden");
                $("#userOk").attr("hidden", "hidden");
            });

            $("#password2").blur(function (){
                let $inputPassword = $("input");
                let password = $inputPassword[1].value;
                let password2 = $inputPassword[2].value;
                if (password != password2){
                    $("#password_error").removeAttr("hidden");
                    $("#pwdOk").attr("hidden", "hidden");
                }else{
                    isPassword = true;
                    $("#password_error").attr("hidden", "hidden");
                    $("#pwdOk").removeAttr("hidden");
                }
            });
            $("#password2").focus(function (){
                $("#password_error").attr("hidden", "hidden");
            });
        });

        function ajaxFindUser(){
            let $input = $(":input");
            let in_username = $input[0].value;
            $.ajax({
                url: "${pageContext.request.contextPath}/FindUser",
                type: "POST",
                success: function (result, status, xhr){
                    if (status == "success"){
                        if (result == "true"){
                            $("#username_error").removeAttr("hidden");
                            $("#userOk").attr("hidden", "hidden");
                        }else{
                            isRegister = false;
                            $("#username_error").attr("hidden", "hidden");
                            $("#userOk").removeAttr("hidden");
                        }
                    }
                },
                data: {username: in_username}
            });
        };


        function ajaxFunction(){
            let $input = $(":input");
            let in_username = $input[0].value;
            let in_password = $input[1].value;
            let in_password2 = $input[2].value;


            $.ajax({
                url: "${pageContext.request.contextPath}/Register",
                type: "POST",
                success: function (result, status, xhr){
                    if (status == "success"){
                        if (result == "true"){
                            alert("注册成功");
                            window.location.replace("${pageContext.request.contextPath}/login.jsp");
                        }else{
                            $("#error").removeAttr("hidden");
                        }
                    }
                },
                data: {username: in_username, password: in_password}
            });
        };
    </script>
    <body>
        <h1 style="text-align: center">注册</h1>
        <div style="margin: 0 auto;width: 380px;height: 300px; padding: 5px;">
            用户名：<input id="username" type="text"><span id="userOk" hidden>✅</span> <span id="username_error" style="color: red; font-size: 12px;" hidden>❌用户名已存在❌</span>
            <br>
            密码：<input type="password">
            <br>
            确认密码：<input id="password2" type="password"> <span id="pwdOk" hidden>✅</span> <span id="password_error" style="color: red; font-size: 12px;"
                                              hidden>❌两次密码不一致❌</span>
            <br>
            <input type="submit" value="注册" onclick="ajaxFunction()">
            <a href="${pageContext.request.contextPath}/login.jsp">已有账号？点击登陆</a>
        </div>
    </body>
</html>
