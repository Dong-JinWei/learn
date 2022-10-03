<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String s = headerNames.nextElement();
                String header = request.getHeader(s);
                System.out.println(s + ":" + header);

            }
            String remoteHost = request.getRemoteHost();
            int remotePort = request.getRemotePort();
            System.out.println(remoteHost + ":" + remotePort);
            StringBuffer requestURL = request.getRequestURL();
            System.out.println(requestURL.toString());
            String name = request.getParameter("name");
        %>
        <%=remoteHost+":"+remotePort%>
        <a href="ok.jsp">点击跳转</a>
        <%=name%>
    </body>
</html>
