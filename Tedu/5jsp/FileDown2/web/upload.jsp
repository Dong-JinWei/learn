<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/20
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>上传</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/UploadServlet" enctype="multipart/form-data" method="post">
            <input type="file" value="添加文件" name="file">
            <input type="submit" value="上传">
        </form>
    </body>
</html>
