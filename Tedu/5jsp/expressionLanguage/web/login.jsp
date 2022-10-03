<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>登陆</title>
    </head>
    <body>

        <%Cookie[] cookies = request.getCookies();%>
        <c:if test="${(not empty cookie.name) && (cookie.value == dowei)}">
            <%
                request.getRequestDispatcher("ok.jsp").forward(request, response);
            %>
        </c:if>


        <form action="${pageContext.request.contextPath}/Login">
        username: <input type="text" name="username">
        <br>
        password: <input type="password" name="pwd">
        <br>
        <input type="checkbox" name="check" value="1">30天免登录
        <br>
        <input type="submit" value="登陆">
        </form>
    </body>
</html>
