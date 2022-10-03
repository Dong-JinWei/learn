<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            // 自动刷新
            response.setHeader("refresh", "5");

            // 自动跳转
            response.setHeader("refresh", "5;/builtInObjects_war_exploded/ok.jsp");
        %>
    </body>
</html>
