<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/15
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/servlet2_war_exploded/request" method="post">
    用户名：<input type="text" name="user"> <br>
    密码：<input type="password" name="pwd"><br>
    性别：<input type="radio" name = "sex" value="0">男
    <input type="radio" name = "sex" value="1">女<br>

    爱好：
    <input type="checkbox" name="joy" value="篮球">篮球
    <input type="checkbox" name="joy" value="足球">足球
    <input type="checkbox" name="joy" value="乒乓球">乒乓球
    <input type="checkbox" name="joy" value="编程">编程<br>
    
    城市：
    <select name="city">
      <option value="西安">西安</option>
      <option value="北京">北京</option>
      <option value="上海">上海</option>
      <option value="成都">成都</option><br>

      <input type="hidden" name="book" value="Java">

      <input type="submit" value="提交">
    </select>
  </form>
  </body>
</html>
