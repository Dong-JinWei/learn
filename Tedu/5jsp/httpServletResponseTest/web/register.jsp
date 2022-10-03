<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/16
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/httpServletResponseTest_war_exploded/Register">
  <center><font size=10>注册</font></center>
  用户名：<input type="text" name="user">
  <br>
  密码：<input type="password" name="pwd">
  <br>
  <input type="submit" value="提交注册">
  <a href="/httpServletResponseTest_war_exploded/login.jsp"><input type="button" value="返回登录"></a>
</form>
</body>
</html>
