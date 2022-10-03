<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/23
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登陆成功</title>
    </head>
    <style>
        a{
            display: block;
            float: right;
        }
    </style>
    <body>
        <a href="${pageContext.request.contextPath}/UnLogin">退出登陆</a>
       <p style="font-size: 100px; text-align: center;">🎉恭喜您登陆成功🎉</p>
    </body>
</html>
