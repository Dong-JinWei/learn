<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/16
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<center><font size=10>登录</font></center>
<form action="/loginAndRegister_war_exploded/login">
    用户名：<input type="text" name="user">
    <br>
    密码：<input type="password" name="pwd">
    <br>
    <input type="submit" value="登录">
    <br>
    没有账号？<a href="/loginAndRegister_war_exploded/register.jsp">点击注册</a>
</form>
</body>
</html>
