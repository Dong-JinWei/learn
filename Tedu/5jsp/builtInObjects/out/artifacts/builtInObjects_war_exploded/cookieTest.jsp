<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            Cookie cookie = new Cookie("user", "dowei");
            cookie.setMaxAge(30);
            cookie.setPath("/");
            response.addCookie(cookie);
            request.getRequestDispatcher("ok.jsp").forward(request,response);
        %>
    </body>
</html>
