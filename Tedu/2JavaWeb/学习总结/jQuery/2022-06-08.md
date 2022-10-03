<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>2022-06-08</u></center>

# jQuery

官网：http://jquery.com

jQuery 是一个js库，简单易学

很多前端框架依赖于jQuery，例如bootstrap，easyui，layui等等，易于处理AJAX 代码（到服务器阶段学习）

## 如何搭建 jQuery 环境

1. 下载 jQuery 相关的 js 文件

   - jQuery-1.8.3.js 开发版本，包含注释，缩进等等

   - jQuery-1.8.3.min.js 线上版本，对开发板进行压缩，便于网络中传输，适合于线上产品

2. 把 jQuery.js 文件拷贝到项目的js文件夹下

3. 把 jQuery.js 文件引入`<script src="js/jquery-1.8.3.min.js"></script>`

4. 书写代码测试

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
       <script src="js/jquery-1.8.3.min.js"></script>
       <script>
           //document.write($);
           function showUser(){
               let username = document.getElementById("username").value;
               alert(username);
               // 这里可以看出，jQuery比js书写简单
               alert($("#username").val());
           }
   
       </script>
   </head>
   <body>
   <input type="text" name="username" id="username"/>
   <input type="button" value="点我" onclick="showUser()"/>
   </body>
   </html>
   ```

   ```js
   // js的处理方式
   window.onload = function (){
       var d = document.getElementById("d");
       d.style.width = "300px";
       d.style.height = "300px";
       d.style.backgroundColor = "red";
   }
   ```

   ```js
   // jquery 的三种处理方式
   $(document).ready(function (){
       let d = document.getElementById("d");
       d.style.width = "300px";
       d.style.height = "300px";
       d.style.backgroundColor = "red";
   })
   $().ready(function (){
       let d = document.getElementById("d");
       d.style.width = "300px";
       d.style.height = "300px";
       d.style.backgroundColor = "green";
   })
   $(function (){
       let d = document.getElementById("d");
       d.style.width = "300px";
       d.style.height = "300px";
       d.style.backgroundColor = "blue";
   })
   ```

   ```js
   // jQuery 书写样式的方法
   $(function (){
       $("#d").css("width","300px")
           .css("height","300px")
           .css("background-color","yellow");
   })
   ```

   ```js
   // jQuery 对象和js对象的互相转换
   $(function (){
       // js的的方法和jQuery的方法不能混用
       let d = document.getElementById("d"); // js 对象
       // 转换的语法：$(js对象)
       let $d = $(d); // $d 是jquery对象
       $("#d").css("width","300px")
           .css("height","300px")
           .css("background-color","yellow");
   })
   ```

   ```js
   // jquery 转换为js对象
   $(function (){
       // jquery 对象实质上是一个数组
       // 通过下标可以取出js对象
       let d = $("#d")[0];
       d.style.width = "300px";
       d.style.height = "300px";
       d.style.backgroundColor = "red";
   })
   ```

## 处理空指针异常方式

```js
// js 遇到了空指针时，程序会停止
var person = null;
alert(person.name);
alert("程序正常结束")

// jquery中$() 中的参数为null时，可以继续调用其方法或者属性
var person = null; // js对象
$(person).val();
alert("程序正常结束");
```

## jQuery选择器

id选择器

复合选择器

通配符选择器

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>标签选择器</title>
  <script src="js/jquery-1.8.3.min.js"></script>
  <script !src="">
    $(function (){
      // $("p").css("font-size","50px").css("color","red");
      // $("h3").css("font-size","50px").css("color","blue");
      // $("p,h3").css("font-size","50px").css("color","red");
      $("*").css("font-size","50px").css("color","red");
    })
  </script>
</head>
  <body>
    窗前明月光
<!--  让p标签变大变红，h3标签变大变蓝-->
    <p>大家好1</p>
    <p>大家好2</p>
    <p>大家好3</p>
    <p>大家好4</p>
    <p>大家好5</p>
    <h3>晚上好1</h3>
    <h3>晚上好2</h3>
    <h3>晚上好3</h3>
    <h3>晚上好4</h3>
    <h3>晚上好5</h3>
  </body>
</html>
```

jquery的类选择器

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>类选择器</title>
        <script src="js/jquery-1.8.3.min.js"></script>
        <script !src="">
            $(function (){
                // 需求：把a标签变大变红，b变大变蓝
                // $(".a").css("font-size","50px").css("color","red");
                // $(".b").css("font-size","50px").css("color","blue");
                // 需求：把p标签位数是奇数标签变大变红
                $("p.a").css("font-size","50px").css("color","red");
            })
        </script>
    </head>
    <body>
        <p class="a">大家好1</p>
        <p class="b">大家好2</p>
        <p class="a">大家好3</p>
        <p class="b">大家好4</p>
        <p class="a">大家好5</p>
        <h3 class="a">晚上好1</h3>
        <h3 class="b">晚上好2</h3>
        <h3 class="a">晚上好3</h3>
        <h3 class="b">晚上好4</h3>
        <h3 class="a">晚上好5</h3>
    </body>
</html>
```

