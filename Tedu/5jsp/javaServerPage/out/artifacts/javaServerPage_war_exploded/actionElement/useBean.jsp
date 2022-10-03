<%@ page import="cn.tedu.Student" %><%--
  Created by IntelliJ IDEA.
  User: 26465
  Date: 2022/7/18
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--        <%--%>
        <%--            Student stu = new Student();--%>
        <%--        %>--%>
        <%-- 等价--%>
        <jsp:useBean id="student" class="cn.tedu.Student" scope="request">

            <%--            <%student.setId(1001);%>--%>
            <%--            <%student.setName("张三");%>--%>
            <%--            等价--%>
            <jsp:setProperty name="student" property="id" value="1001"></jsp:setProperty>
            <jsp:setProperty name="student" property="name" value="张三"></jsp:setProperty>

            <%--            <%--%>
            <%--            student.getId();--%>
            <%--            student.getName();--%>
            <%--            //获取id和name，并输出到页面--%>
            <%--            %>--%>
            <%--            等价--%>
            <jsp:getProperty name="student" property="id"/>
            <jsp:getProperty name="student" property="name"/>

        </jsp:useBean>
    </body>
</html>
