<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/22
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <script>
        function ajaxFunction() {
            //创建AJAX引擎对象，将对象放在xmlHttp变量中。
            var xmlHttp;

            try {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e) {

                // Internet Explorer
                try {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {

                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("您的浏览器不支持AJAX！");
                        return false;
                    }
                }
            }

            //设置对接收到的数据进行处理。
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    var expression = "user=" + xmlHttp.responseText;
                    eval(expression);
                    document.getElementById("div").innerHTML = user.id + " " + user.name + " " + user.age;
                }
            }

            //设置发送请求的url，以及请求方式。
            //url的第一个斜线表示服务器名
            xmlHttp.open("GET", "${pageContext.request.contextPath}/EvalServlet", true);

            //给指定的url方式请求。可以传递参数。
            xmlHttp.send(null);
        }
    </script>
    <body>
        <input type="button" value="ajax" onclick="ajaxFunction()">
        <div id="div"></div>

    </body>
</html>
