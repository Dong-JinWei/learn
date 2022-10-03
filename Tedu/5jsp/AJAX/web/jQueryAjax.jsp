<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/22
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <script src="js/jquery.min.js"></script>
    <script>
        function ajaxFunction(){
            $.ajax({
                url:"${pageContext.request.contextPath}/JQueryServlet",
                type: "GET",
                success: function (result, status, xhr){
                    if (status == "success"){
                        var expression = "user=" + result;
                        eval(expression);
                        document.getElementById("div").innerHTML = user.name + " " + user.age;
                    }
                },
                data : {user: "水果", pwd: 34}
            });
        }

        function f(){
            var url = "${pageContext.request.contextPath}/JQueryServlet";
            var data = {user: "水果", pwd: 34};
            var callback = function (result, status, xhr){
                if (status == "success"){
                    var exp = "book=" + result;
                    eval(exp);
                    document.getElementById("div2").innerHTML = book.name + " " + book.age;
                }
            };
            $.get(url, data, callback);
        }
    </script>
    <body>
        <input type="button" value="ajax1" onclick="ajaxFunction()">
        <input type="button" value="ajax2" onclick="f()">
        <div id="div"></div>
        <div id="div2"></div>
    </body>
</html>
