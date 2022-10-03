<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>2022-06-01</u></center>

# JavaScript 的组成

ECMAScript，BOM 和 DOM

# BOM

BOM = brower object model：浏览器对象模型

js 内置了一些和浏览器有关的对象

```js
// window 是一个内置对象
document.write("window = " + window);
// 弹出一个窗口（浏览器默认当广告来处理）
window.open("https://www.baidu.com/");
// 在当前窗口打开一个页面
window.location.href = "https://www.baidu.com/";
// window 可以省略不写
open("https://www.baidu.com/");
location.href = "https://www.baidu.com/";
window.alert("nihc ");
// window 是BOM中最大的对象
var a = 3;
document.write(window.a);
// 获取浏览器高度和宽度
document.write("宽度" + window.innerWidth + ",高度" + window.innerHeight);
```

# 定时器

1. setTimeout()

```html
		<title>定时器</title>
		<script>
			var i = 0;
			function test(){
				// document.write("test函数被执行了"+i+"<br/>");
				alert("test函数被执行了"+i+"<br/>");
				i++;
			}
			var id;
			function run(){
				// 指定时间执行一次
				// setTimeout("test()", 3000);
				//
				// setInterval("test()", 1000);
				id = setInterval("test()", 2000);
			}
			function stop(){
				// 清除定时器，需要传递定时器的id
				clearInterval(id);
			}
		</script>
	</head>
	<body>
		<input type="button" value="开始" onclick="run()">
		<input type="button" value="停止" onclick="stop()">
	</body>
```

使用 setTimeout 实现多次调用

```js
function test() {
  alert("大家好");
  setTimeout("test()", 3000);
}
test();
```

让`setTimeout`停止的方法`learTimeout`

# location 对象

作用让页面来跳转到指定地址

```html
	<style>
		a {
			display: block;
			width: 50px;
			height: 20px;
			text-decoration: none;
			background-color: #ccc;
			border-radius: 5px;
			font-size: 15px;
			color: black;
			text-align: center;
			line-height: 20px;
		}
		a:hover {
			background-color: orange;
			color: #fff;
			box-shadow: 1px 1px #ccc;
		}
	</style>
	<script>
		function openWeb(){
			var url = prompt("请输入网址");
			location.href = "http://www." + url;
		}
	</script>
</head>
<body>
	<a href="javascript:openWeb()">点我</a>
</body>
```

# DOM 对象

document 表示页面

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>初步DOM</title>
    <script>
      // 只控制当前页面
      // var title = prompt("请输入页面的标题");
      // 当前页面的标题
      // document.title = title;
      // var c = prompt("请输入要改变的颜色");
      // 使用js控制样式时，如果样式有多个单词，把"-"删除
      // 后边的单词首 字母大写
      // document.body.style.backgroundColor = c;
      // 此时没有效果，因为还未解析到body标签
      // 解决1：把代码放到body后边
      // 解决2：放到window.onload这个函数中
      // 页面加载完毕后执行其代码
      window.onload = function () {
        var c = prompt("请输入要改变的颜色");
        document.body.style.backgroundColor = c;
      };
    </script>
  </head>
  <body></body>
  <!-- 		<script>
			// 只控制当前页面
			// var title = prompt("请输入页面的标题");
			// 当前页面的标题
			// document.title = title;
			var c = prompt("请输入要改变的颜色");
			// 使用js控制样式时，如果样式有多个单词，把"-"删除
			// 后边的单词首 字母大写
			document.body.style.backgroundColor = c;
			// 此时没有效果，因为还未解析到body标签
		</script> -->
</html>
```

## 如何获取标签对象

1. 通过 id 来获取标签对象，获取标签对象以后，就可以操纵改变前的任意属性

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>获取标签对象</title>
  </head>
  <body>
    <font id="f">大家好</font>
  </body>
  <script>
    var f = document.getElementById("f");
    f.size = "7";
    f.color = "red";
    f.style.fontFamily = "楷体";
  </script>
</html>
```

如果属性和关键字相同，可以使用一下方法

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>使用js绘制div</title>
    <style>
      .d {
        width: 300px;
        height: 300px;
        background-color: skyblue;
      }
    </style>
  </head>
  <body>
    <div id="d"></div>
  </body>
  <script>
    // 如果id值写错，会返回null
    var div = document.getElementById("d");
    // div.style.width = "200px";
    // div.style.height = "200px";
    // div.style.backgroundColor = "red";
    // div.style.margin = "0 auto";
    // div.style.border = "1px blue solid"
    // class是js的关键字，如果想使用class要改名为className
    div.className = "d";
  </script>
</html>
```

1. 书写用户名，明码，按钮，点击按钮时，显示用户名和密码
2. 给图片添加两个按钮，一个按钮有放大的功能，一个按钮有缩小的功能
3. 给页面添加三个按钮，每次点击按钮都会改变页面的北京图片
