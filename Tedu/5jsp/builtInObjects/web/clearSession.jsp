<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            session.setAttribute("name", "dowei");
            session.invalidate();
            Object name = session.getAttribute("name");
            System.out.println(name);
        %>
    </body>
</html>
