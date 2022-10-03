<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/23
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登陆</title>
    </head>
    <script src="js/jquery.min.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script>
        <c:if test="${not empty cookie.username}">
        window.location.replace("${pageContext.request.contextPath}/ok.jsp");
        </c:if>

        $(document).ready(function (){
            $(":input").focus(function (){
                $("#error").attr("hidden", "hidden");
            })
        })

        function ajaxFunction() {
            let $input = $(":input");
            let in_username = $input[0].value;
            let in_password = $input[1].value;
            let in_check = $("#check").is(":checked");
            $.ajax({
                url: "${pageContext.request.contextPath}/Login",
                type: "POST",
                success: function (result, status, xhr) {
                    if (status == "success") {
                        if (result == "true") {
                            window.location.replace("${pageContext.request.contextPath}/ok.jsp");
                        } else {
                            $("#error").removeAttr("hidden");
                        }
                    }
                },
                data: {username: in_username, password: in_password, check:in_check}
            });
        }
    </script>
    <body>
        <h1>登陆</h1>
        用户名：<input type="text" name="username">
        <br>
        密码：<input type="password" name="password">
        <br>
        <input type="checkbox" id="check">30天免登陆
        <br>
        <span id="error" style="color: red; font-size: 12px;" hidden>❌用户名或密码错误❌，请重新输入</span>
        <br>
        <input type="submit" value="登陆" onclick="ajaxFunction()">
        <a href="${pageContext.request.contextPath}/register.jsp">没有账号？点击注册</a>
    </body>
</html>
