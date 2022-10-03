<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/8/2
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>update employee</title>
    </head>
    <link href="${pageContext.request.contextPath}/static/css/index_work.css" rel="stylesheet">
    <body>

        <form action="${pageContext.request.contextPath}/employee" method="post">
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="id" value="${employee.id}">
            <table>
                <tr>
                    <th colspan="2">update employee</th>
                </tr>
                <tr>
                    <td>lastName</td>
                    <td><input type="text" name="lastName" value="${employee.lastName}"></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" value="${employee.email}"></td>
                </tr>
                <tr>
                    <td>gender</td>
                    <td>
                        <c:if test="${employee.gender == '1'}">
                            <input type="radio" name="gender" checked="checked" value="1">male
                            <input type="radio" name="gender" value="0">female
                        </c:if>
                        <c:if test="${employee.gender == '0'}">
                            <input type="radio" name="gender" value="0">male
                            <input type="radio" name="gender" checked="checked" value="1">female
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="update">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
