<%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        $END$
        <%=request.getParameter("user")%>
        <%=request.getParameter("pwd")%>
        <jsp:include page="/sub.jsp"/>


        <jsp:useBean id="stu" class="cn.tedu.Student" scope="session">
            <jsp:setProperty name="stu" property="id" value="1001"/>
            <jsp:setProperty name="stu" property="name" value="dowei"/>
        </jsp:useBean>
        <jsp:getProperty name="stu" property="id"/>
        <jsp:getProperty name="stu" property="name"/>

    </body>
</html>
