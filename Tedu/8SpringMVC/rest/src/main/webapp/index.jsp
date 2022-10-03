<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true" %>
<html>
<body>
<h2>Hello World!</h2>
    <a href="${pageContext.request.contextPath}/user">获取所有用户</a>
    <a href="${pageContext.request.contextPath}/user/1">获取id对应的用户</a>
    <br>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="submit" value="插入一个用户">
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="submit" value="修改一个用户">
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="删除一个用户">
    </form>

    <hr>
    <hr>
    <a href="${pageContext.request.contextPath}/employee">查询所有员工信息</a>
</body>
</html>
