<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/16
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<center><font size=10>注册</font></center>
<form action="/loginAndRegister_war_exploded/register">
    用户名：<input type="text" name="user">
    <br>
    密码：<input type="password" name="pwd">
    <br>
    <input type="submit" value="提交">
    <br>
    已有账号？<a href="/loginAndRegister_war_exploded/login.jsp">点击登录</a>
</form>
</body>
</html>
