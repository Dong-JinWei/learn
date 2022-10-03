<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>2022-06-10</u></center>

# DOM 树

```
			html （根节点）
		/  		\  （父子）
	head		body （head和body是兄弟）
	/ \			/ 	\
title	script  img		div
```

# jQuery 的遍历方式

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>遍历</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>
      $(function () {
        // jquery 对象实质上是一个数组
        var $input = $("input");
        // 数组的遍历方式
        for (var i = 0; i < $input.length; i++) {
          // 遍历出的是dom对象，不是jQuery对象
          alert($input[i].value);
        }
        // jQuery 的遍历
        // index 表示下标值，elment表示遍历出的DOM对象
        $input.each(function (index, element) {
          alert(index + "=" + element.value);
        });
      });
    </script>
  </head>
  <body>
    <input type="button" value="点我1" />
    <input type="button" value="点我2" />
  </body>
</html>
```

# jQuery 选择器

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>直接子元素选择器</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>
      $(function () {
        $("form > input").val("大家好"); // name
        $("form  input").val("大家好"); // name and newsletter
      });
    </script>
  </head>
  <body>
    <form>
      <label>Name:</label>
      <input name="name" />
      <fieldset>
        <label>Newsletter:</label>
        <input name="newsletter" />
      </fieldset>
    </form>
    <input name="none" />
  </body>
</html>
```

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>+号选择器</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>
      $(function () {
        // + 表示label紧接着的后一个选择器
        $("label + input").val("good luck");
      });
    </script>
  </head>
  <body>
    <form>
      <label>Name:</label>
      <input name="name" />
      <fieldset>
        <label>Newsletter:</label>
        <input name="newsletter" />
      </fieldset>
    </form>
    <input name="none" />
  </body>
</html>
```

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>兄弟选择器</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>
      $(function () {
        $("form ~ input").val("晚上好");
      });
    </script>
  </head>
  <body>
    <form>
      <label>Name:</label>
      <input name="name" />
      <fieldset>
        <label>Newsletter:</label>
        <input name="newsletter" />
      </fieldset>
    </form>
    <input name="none" />
  </body>
</html>
```

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Other selectors</title>
    <script src="js/jquery-1.8.3.js"></script>
    <script>
      $(function () {
        // 第一个出现的li
        $("li:first").css("color", "red");
        // 最后出现的li
        $("li:last").css("color", "green");

        $("input:not(:checked)").css("background", "red");

        // 选择偶数行，index从0开始
        $("tr:even").css("color", "red");
        // 选择计数行，index从0开始
        $("tr:odd").css("color", "green");
        // 选择指定行，index从0开始
        $("tr:eq(3)").css("font-size", "50px");
        // 选择大于指定索引的元素，索引从0开始
        $("tr:gt(3)").css("font-size", "30px");
        //  选择小于指定索引的元素，索引从0开始
        $("tr:lt(2)").css("font-size", "40px");
        // 匹配如 h1, h2, h3之类的标题元素
        $(":header").css("background", "#eee");
      });
    </script>
  </head>
  <body>
    <ul>
      <li>list item 1</li>
      <li>list item 2</li>
      <li>list item 3</li>
      <li>list item 4</li>
      <li>list item 5</li>
    </ul>

    <input name="apple" />
    <input name="flower" checked="checked" />

    <table>
      <tr>
        <td>Header 0</td>
      </tr>
      <tr>
        <td>Value 1</td>
      </tr>
      <tr>
        <td>Value 2</td>
      </tr>
      <tr>
        <td>Value 3</td>
      </tr>
      <tr>
        <td>Value 4</td>
      </tr>
      <tr>
        <td>Value 5</td>
      </tr>
    </table>

    <h1>Header 1</h1>
    <p>Contents 1</p>
    <h2>Header 2</h2>
    <p>Contents 2</p>
  </body>
</html>
```

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title></title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <!-- jQuery实现 -->
    <script>
      $(function () {
        $("tr:even").css("background-color", "red");
        $("tr:odd").css("background-color", "skyblue");
      });
    </script>

    <!-- js实现 -->
    <script>
      window.onload = function () {
        var trs = document.getElementsByTagName("tr");
        for (var i in trs) {
          if (i % 2 == 0) {
            trs[i].style.backgroundColor = "red";
          } else {
            trs[i].style.backgroundColor = "skyblue";
          }
        }
      };
    </script>
  </head>
  <body>
    <table>
      <tr>
        <td>第一行</td>
      </tr>
      <tr>
        <td>第二行</td>
      </tr>
      <tr>
        <td>第三行</td>
      </tr>
      <tr>
        <td>第四行</td>
      </tr>
      <tr>
        <td>第五行</td>
      </tr>
      <tr>
        <td>第六行</td>
      </tr>
    </table>
  </body>
</html>
```
