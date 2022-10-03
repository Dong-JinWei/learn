<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            session.setMaxInactiveInterval(10);
            session.setAttribute("user", "dowie");
        %>
        session write
    </body>
</html>
