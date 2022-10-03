<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:set var="name" value="dowei" scope="request"></c:set>
        <c:if test="${not empty requestScope.name}">
            <c:out value="request 中有name"></c:out>
        </c:if>
        <c:if test="${empty requestScope.name}">
            <c:out value="request 中没有name"></c:out>
        </c:if>

        <c:set var="day" value="2" scope="request"></c:set>
        <c:choose>
            <c:when test="${day == 1}">
                <c:out value="星期1"></c:out>
            </c:when>
            <c:when test="${day == 2}">
                <c:out value="星期2"></c:out>
            </c:when>
            <c:when test="${day == 3}">
                <c:out value="星期3"></c:out>
            </c:when>
            <c:when test="${day == 4}">
                <c:out value="星期4"></c:out>
            </c:when>
            <c:otherwise>
                <c:out value="其他星期"></c:out>
            </c:otherwise>
        </c:choose>
    </body>
</html>
