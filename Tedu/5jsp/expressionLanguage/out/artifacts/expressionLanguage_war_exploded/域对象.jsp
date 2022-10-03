<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("stu", "dowie");
    request.setAttribute("age", 20);
    session.setAttribute("price", 34.5);
    application.setAttribute("address", "xi`an");
%>

${pageScope.stu}
${requestScope.age}
${sessionScope.price}
${applicationScope.address}

</body>
</html>
