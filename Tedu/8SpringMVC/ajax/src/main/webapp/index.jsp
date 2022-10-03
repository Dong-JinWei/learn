<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
    <body>

        <div id="app">
            <h1>index.html</h1>
            <input type="button" value="测试SpringMVC处理ajax" @click="testAjax()"><br>
            <input type="button" value="使用@RequestBody注解处理json格式的请求参数" @click="testRequestBody()"><br>
            <a href="${pageContext.request.contextPath}/test/ResponseBody">测试@Responsebody注解响应浏览器数据</a><br>
            <input type="button" value="使用@Responsebody注解处理json格式的请求参数" @click="testRResponseBodyJson()"><br>
            <a href="${pageContext.request.contextPath}/test/down">下载图片</a>><br>
            <form action="${pageContext.request.contextPath}/test/up" method="post" enctype="multipart/form-data">
                <input type="file" name="photo">
                <input type="submit" value="上传">
            </form>
        </div>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/vue.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/axios.min.js"></script>
        <script type="text/javascript">
            var vue = new Vue({
                el: "#app",
                methods: {
                    testAjax() {
                        axios.post(
                            "/ajax/test/ajax?id=1001",
                            {username: "admin", password: "123456"}
                        ).then(response => {
                            console.log(response.data);
                        });
                    },
                    testRequestBody() {
                        axios.post(
                            "/ajax/test/RequestBody/json",
                                {username: "admin", password: "123456", age: 23, gender: "男"}
                        ).then(response => {
                            console.log(response.data);
                        });
                    },
                    testRResponseBodyJson(){
                        axios.post("/ajax/test/ResponseBody/json").then(response => {
                            console.log(response.data);
                        })
                    }
                }
            });
        </script>
    </body>
</html>
