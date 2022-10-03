<%@ page import="cn.tedu.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/21
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        ${pageContext.request.contextPath}
        <%
            request.setAttribute("stu", new Student(1001, "dowei"));
            session.setAttribute("arr", new int[]{1, 2, 3, 4, 5, 6});
            List<String> list = new ArrayList<>();
            list.add("abc");
            list.add("qwerty");
            session.setAttribute("list", list);
            Map<String, String> map = new HashMap<>();
            map.put("aa", "aaa");
            map.put("bb", "bbb");
            map.put("cc", "ccc");
            application.setAttribute("map", map);
        %>
        ${stu.id}
        ${stu.name}
        ${arr[1]}
        ${list[1]}
        ${map.aa}
        ${map["aa"]}

    </body>
</html>
