<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>hello</title>
    </head>
    <body>
        <%--java程序--%>
        <%
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= i; j++) {
                    // System.out.print(j + "*" + i + "=" + i*j + "\t");
        %>
        <%=j + "*" + i + "=" + i * j + "\t"%>
        <%
        %>
        <%
            }
            // System.out.println();
            // res += "\n";
        %>
        <br>
        <%
            }
        %>


        <%int total = 10;%>
        <%=total%>
        <p style="font-size: <%=total%>px;color: red">hello</p>

    </body>
</html>
