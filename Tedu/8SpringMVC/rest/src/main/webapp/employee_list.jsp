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
        <title>employee list</title>
    </head>
    <link href="${pageContext.request.contextPath}/static/css/index_work.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/vue.js"></script>
    <body>
        <div id="app">
            <table>
                <tr>
                    <th colspan="5">employee list</th>
                </tr>
                <tr>
                    <th>id</th>
                    <th>lastName</th>
                    <th>email</th>
                    <th>gender</th>
                    <th>option （<a href="${pageContext.request.contextPath}/to/add">添加用户</a>）</th>
                </tr>
                <c:forEach items="${allEmployees}" var="employee" varStatus="status">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.email}</td>
                        <td>${employee.gender}</td>
                        <td>
                            <a @click="deleteEmployee()" href="${pageContext.request.contextPath}/employee/${employee.id}">delete</a>
                            <a href="${pageContext.request.contextPath}/employee/${employee.id}">update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <form method="post">
                <input type="hidden" name="_method" value="delete">
            </form>
        </div>
        <script type="text/javascript">
            var vue = new Vue({
                el:"#app",
                methods:{
                    deleteEmployee(){
                        //获取form表单
                        var form = document.getElementsByTagName("form")[0];
                        //将超链接的href属性值赋值给form表单的action属性
                        //event.target表示当前触发事件的标签
                        form.action = event.target.href;
                        //表单提交
                        form.submit();
                        //阻止超链接的默认行为
                        event.preventDefault();
                    }
                }
            });
        </script>
    </body>

</html>
