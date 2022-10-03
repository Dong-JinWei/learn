<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--        <%--%>
        <%--            Enumeration<String> headerNames = request.getHeaderNames();--%>
        <%--            while (headerNames.hasMoreElements()) {--%>
        <%--                String s = headerNames.nextElement();--%>
        <%--                String header = request.getHeader(s);--%>
        <%--                System.out.println(s + ":" + header);--%>
        <%--            }--%>
        <%--        %>--%>

        <%--        <%--%>
        <%--            Cookie[] cookies = request.getCookies();--%>
        <%--            for(Cookie cookie: cookies){--%>
        <%--                String name = cookie.getName();--%>
        <%--                String value = cookie.getValue();--%>
        <%--                System.out.println(name + ":" + value);--%>
        <%--            }--%>
        <%--        %>--%>

        ok--------- <a href="/builtInObjects_war_exploded/clear">退出</a>
        <%=pageContext.getAttribute("style")%>
        <%=session.getAttribute("user")%>
    </body>
</html>
