<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/15
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/webTest_war_exploded/test" method="get">
    用户名：<input type="text" name="user"><br>
    密码：<input type="password" name="pwd"><br>
    性别：<input type="radio" name="sex" value="女">女 <input type="radio" name="sex" value="男">男<br>
    爱好：<input type="checkbox" name="joy" value="编程">编程 <input type="checkbox" name="joy" value="唱">唱 <input type="checkbox" name="joy" value="跳">跳<br>
    城市：
    <select name="city" >
      <option value="西安">西安</option>
      <option value="北京">北京</option>
      <option value="上海">上海</option>
    </select><br>
    <input type="submit" value="提交">

  </form>
  </body>
</html>
