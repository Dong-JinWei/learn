<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/20
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%!int i = 0;%>
        <%
            // 从application中读取数据
            Object user = application.getAttribute("user");
            // 将读取的数据加一
            if (user == null){
                application.setAttribute("user", 1);
            }
            i = Integer.parseInt(user+"") + 1;
            // 将加一后的数据放入application
            application.setAttribute("user", i);
            // 获取文件的上下文路径
            String realPath = application.getRealPath("/applicationTest.jps");
        %>
        <%=realPath%>
    </body>
</html>
