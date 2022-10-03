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
        <script src="${pageContext.request.contextPath}/ok.js"></script>
        <link href="${pageContext.request.contextPath}/ok.css" rel="stylesheet">
    </head>
    <body>
        ${id}<br>
        ${user}<br>
        ${pwd}
        <h1>=========ok==========</h1>
        <img src="${pageContext.request.contextPath}/ad-01.jpg ">
        <p class="a" onclick="f()">你好</p>
        <%= session.getAttribute("age")%>
        <hr>
        ${sessionScope.user}
        ${sessionScope.pwd}
        <hr>
        ${applicationScope.user}
        ${applicationScope.pwd}
    </body>
</html>
