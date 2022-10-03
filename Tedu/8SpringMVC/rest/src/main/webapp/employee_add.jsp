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
        <title>add employee</title>
    </head>
    <link href="${pageContext.request.contextPath}/static/css/index_work.css" rel="stylesheet">
    <body>

        <form action="${pageContext.request.contextPath}/employee" method="post">
            <table>
                <tr>
                    <th colspan="2">add employee</th>
                </tr>
                <tr>
                    <td>lastName</td>
                    <td><input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>gender</td>
                    <td>
                        <input type="radio" name="gender" value="1">male
                        <input type="radio" name="gender" value="0">female
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="add">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
