<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/20
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>下载</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/DownloadServlet?file=1.png">下载图片</a>
        <a href="<%=request.getContextPath()%>/DownloadServlet?file=图片.jpg">下载壁纸</a>
    </body>
</html>
