<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                if ("user".equals(name) && "dowei".equals(value)){
                    request.getRequestDispatcher("ok.jsp").forward(request,response);
                    return ;
                }
            }
        %>

        <form action="/builtInObjects_war_exploded/login">
            
            用户名：<input type="text" name="user">
            <br>
            密码：<input type="text" name="pwd">
            <br>
            <input type="checkbox" name="check" value="1">30天免登录
            <br>
            <input type="submit" value="提交">
        </form>
    </body>
</html>
