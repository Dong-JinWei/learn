<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/22
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>listener</title>
    </head>
    <body>
        <%
            application.setAttribute("user", "dowei");
            application.setAttribute("user", "dong");
            Object user = application.getAttribute("user");
            application.removeAttribute("user");
        %>
        <%=user%>
    </body>
</html>
