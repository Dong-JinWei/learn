<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p style="font-size: 50px">服务器粗错啦</p>
        <%=exception.getMessage()%>
    </body>
</html>
