<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/23
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登陆</title>
    </head>
    <script src="js/jquery.min.js"></script>
    <script>

        $(document).ready(function(){
            $("input").focus(function () {
                $("#error").attr("hidden", "hidden");
                // document.getElementById("error").setAttribute("hidden", "hidden");
            });
        });

        function ajaxFunction() {
            let $input = $(":input");
            let username = $input[0].value;
            let password = $input[1].value;

            $.ajax({
                url: "${pageContext.request.contextPath}/Login",
                type: "POST",
                success: function (result, status, xhr) {
                    if (status == "success") {
                        // console.log(result);
                        if (result == "true") {
                            window.location.replace("${pageContext.request.contextPath}/ok.jsp")
                        }else{
                            $("#error").removeAttr("hidden");
                            // document.getElementById("error").removeAttribute("hidden");
                        }
                    }
                },
                data: {user:username, pwd: password}
            });
        }

    </script>
    <body>
        <div>
            用户名：<input id="user" type="text" name="user">
            <br>
            密&nbsp;&nbsp;&nbsp;码：<input id="pwd" type="password" name="pwd">
            <br>
            <span id="error" style="color: red; font-size: 12px" hidden>用户名或密码错误，请重新输入</span>
            <br>
            <input type="submit" value="登陆" onclick="ajaxFunction()">
        </div>

    </body>
    <style>
        div{
            width: 300px;
            height: 200px;
            margin: 0 auto;
        }
    </style>
</html>
