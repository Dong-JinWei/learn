<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%! int i = 0;%>
        <%
            int j = 1;
            while (j <= 100){
                i = i + j;
                j++;
            }
        %>
        <%=i%>
        <%=j%>

    </body>
</html>
