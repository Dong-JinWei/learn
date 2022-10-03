<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
<%--        测试c:out--%>
        <c:out value="hello" default="默认值" escapeXml="false"></c:out>
        <br>
        <c:out value="${null}" default="默认值" escapeXml="false"></c:out>
        ${1+2}
        <br>
        <c:out value="<p style= 'color:red; font-size: 100px'>hello</p>" default="null" escapeXml="false"></c:out>
        <c:out value="<p style= 'color:red; font-size: 100px'>hello</p>" default="null" escapeXml="true"></c:out>
        <div style="color:<c:out value="red"></c:out>">
            world
        </div>

<%--        测试c:set--%>
        <c:set var="name" value="dowei" scope="request"></c:set>
        ${name}

        <jsp:useBean id="stu" scope="session" class="cn.tedu.Student">
            <jsp:setProperty name="stu" property="id" value="1001"></jsp:setProperty>
            <jsp:setProperty name="stu" property="name" value="Jonny"></jsp:setProperty>
        </jsp:useBean>

        ${stu}
        <c:set target="${stu}" property="id" value="1002"></c:set>
        ${stu}

    </body>
</html>
