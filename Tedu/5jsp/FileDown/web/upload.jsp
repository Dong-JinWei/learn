<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/20
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>上传</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" value="添加图片" name="f1">
            <input type="file" value="添加图片" name="f2">
            <input type="submit" value="上传">
        </form>
    </body>
</html>
