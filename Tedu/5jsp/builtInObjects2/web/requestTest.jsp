<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/19
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>request</title>
    </head>
    <body>
        <%
            // 获取客户端发送的数据
            String name = request.getParameter("name");

            // 设置编码
            request.setCharacterEncoding("UTF-8");

            // 域对象保存数据
            request.setAttribute("user", "djw");
            Object user = request.getAttribute("user");

            // 页面转发
            // request.getRequestDispatcher("index.jsp").forward(request, response);

            // 获取请求参数
            Enumeration<String> headerNames = request.getHeaderNames();
            String s = null;
            String header = null;
            while (headerNames.hasMoreElements()){
                s = headerNames.nextElement();
                header = request.getHeader(s);
                System.out.println(s + ":" + header);
            }

            // 获取请求客户端地址
            String remoteHost = request.getRemoteHost();
            // 获取请求客户端端口号
            int remotePort = request.getRemotePort();

            // 获取请求方式
            String method = request.getMethod();
            System.out.println(method);

            // 获取cookies
            Cookie[] cookies = request.getCookies();

            // 获取客户端请求的URL
            StringBuffer requestURL = request.getRequestURL();
            System.out.println(requestURL);
        %>
        <%="name：" + name%>
        <%=remoteHost + ":" + remotePort%>
    </body>
</html>
