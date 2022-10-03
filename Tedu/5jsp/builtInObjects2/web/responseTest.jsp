<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>reponse</title>
    </head>
    <body>
        <%
            // 页面跳转（重定向）
            // response.sendRedirect("/builtInObjects2_war_exploded/index.jsp");

            // 设置编码
            response.setContentType("text/html;charset=UTF-8");

            // 响应数据
            PrintWriter writer = response.getWriter();
            writer.write("hello world");

            // 5秒自动刷新
            response.setHeader("refresh", "5");

            // 十秒自动跳转
            response.setHeader("refresh", "10;/builtInObjects2_war_exploded/index.jsp");
        %>
    </body>
</html>
