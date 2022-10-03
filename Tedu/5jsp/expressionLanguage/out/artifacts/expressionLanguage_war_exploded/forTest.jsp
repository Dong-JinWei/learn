<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:forEach var="i" begin="0" end="10" step="1">
            ${i}
        </c:forEach>
        <br>
        <%request.setAttribute("arr", new int[]{11, 22, 33,44,55});%>
        <c:forEach items="${arr}" var="data"  varStatus="status">
            ${data} ${status.count} ${status.first} ${status.last}<br>
        </c:forEach>

        <c:forEach items="${paramValues.joy}" var="joy" varStatus="status">
            <c:if test="${status.count mod 2 == 0}">
                <c:set var="color" value="red" scope="page"></c:set>
            </c:if>
            <c:if test="${status.count mod 2 != 0}">
                <c:set var="color" value="blue" scope="page"></c:set>
            </c:if>
            <p style="color:${pageScope.color};">${joy}</p>
        </c:forEach>
    </body>
</html>
