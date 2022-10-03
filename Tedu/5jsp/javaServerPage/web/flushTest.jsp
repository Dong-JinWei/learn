<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="true" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            int i = 0;
            for (; i < 1000; i++) {
        %>
        <%=i + "你好"%>
        <%
            }
        %>
    </body>
</html>
