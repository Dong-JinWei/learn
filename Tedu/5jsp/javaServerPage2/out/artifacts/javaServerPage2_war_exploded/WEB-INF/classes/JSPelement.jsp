<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <jsp:forward page="index.jsp">
            <jsp:param name="user" value="dowei"/>
            <jsp:param name="pwd" value="123"/>
        </jsp:forward>

    </body>
</html>
