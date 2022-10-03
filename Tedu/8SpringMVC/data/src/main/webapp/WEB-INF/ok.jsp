<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/8/1
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>Title</title>
        <script src="ok.js"></script>
        <link href="ok.css" rel="stylesheet">
    </head>
    <body>
        ${id}<br>
        ${user}<br>
        ${pwd}
        <h1>=========ok==========</h1>
        <img src="ad-01.jpg ">
        <p class="a" onclick="f()">你好</p>
        <%= session.getAttribute("age")%>
    </body>
</html>
