<%@ page import="cn.tedu.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            request.setAttribute("stu", new Student(1001, "dowei"));
            session.setAttribute("arr", new int[]{11, 22, 33, 44, 55});
            List<String> list = new ArrayList<String>();
            list.add("123");
            list.add("222");
            list.add("333");
            list.add("444");
            pageContext.setAttribute("list", list);
            Map<String, String> map = new HashMap<>();
            map.put("aa", "a");
            map.put("bb", "b");
            map.put("cc", "c");
            application.setAttribute("map", map);
        %>

        ${stu.name}
        <br>
        ${arr[2]}
        <br>
        ${list[1]}
        <br>
        ${map["aa"]}
        ${map.bb}
        <br>
        ${pageContext.request.contextPath}
        <br>
        ${param.user}
        <br>
        ${header.Cookie}
        <br>
        ${cookie.JSESSIONID.value}
        <br>
        ${initParam.charset}
    </body>
</html>
