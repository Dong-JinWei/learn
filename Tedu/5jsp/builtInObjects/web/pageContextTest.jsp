<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/20
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            // 测试域对象
            pageContext.setAttribute("style", "color");
            Object style = pageContext.getAttribute("style");
            System.out.println(style);
        %>


        <%
        // 测试域对象，三个参数
            pageContext.setAttribute("user", "dowei", PageContext.SESSION_SCOPE);
        %>
        <%
            request.getRequestDispatcher("/ok.jsp").forward(request,response);
        %>
    </body>
</html>
