<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>2022-05-30</u></center>

# 如何判断星期

```js
var date = new Date();
// 星期天用0表示
var week = date.getDay();
var weeks = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
document.write(weeks[week]);
```

# Math 类

```js
// 圆周率
document.write(Math.PI + "<br/>");
// 2的平方根
document.write(Math.SQRT2 + "<br/>");
// 二分之一的平方根
document.write(Math.SQRT1_2 + "<br/>");
// 计算一个数的平方根
document.write(Math.sqrt(25) + "<br/>");
// 向上取整
document.write(Math.ceil(2.3) + "<br/>");
// 向下取整
document.write(Math.floor(2.3) + "<br/>");
// 取绝对值
document.write(Math.abs(-100) + "<br/>");
// 四舍五入
document.write(Math.round(2.5)+ "<br/>");
// 最大值
document.write(Math.max(2.5, 3, 10)+ "<br/>");
// 最小值
document.write(Math.min(2.5, 3, 10)+ "<br/>");
// 随机数，范围是0-1，[0,1)
document.write(Math.random()+ "<br/>");
```

## 练习：模拟福彩3D

```html
<style>
    div {
        width: 50px;
        height: 50px;
        border: 5px solid royalblue;
        border-radius: 50%;
        display: inline-block;
        line-height: 50px;
        text-align: center;
        color: darkcyan;
        font-size: 50px;
    }
</style>
<script>
    function f() {
    for (let i = 0; i < 3; i++) {
        let num = Math.floor(Math.random() * 10);
        document.write("<div>" + num + "</div>");
    }
}
    f();
</script>
```

# 字符串

```js
// 创建字符串方式1
var str = new String("大家好");
document.write(str + "<br/>");
document.write(typeof(str) + "<br/>");// 结果object是引用数据类型

// 创建字符串方式2
var str2 = "大家好";
document.write(str2 + "<br/>");
document.write(typeof(str2) + "<br/>"); // 是基本数据类型

// 把String当成对象来使用时，会自动封装成object类型
document.write(str2.length + "<br/>");
```

### 字符串的常见方法

```js
let str = "helloworld";
// 返回指定下标的字符
document.write(str.charAt(0) + "<br/>");
// 返回字符串第一次出现的位置
document.write(str.indexOf("o") + "<br/>");
// 返回字符串最后一次出现的位置
document.write(str.lastIndexOf("o")+ "<br/>");
// 替代指定的字符，默认一次只能替换一个，第一次出现的
document.write(str.replace("o","x") + "<br/>");
// 如果想替代多个字符，需要使用正则表达式
document.write(str.replace(/o/g,"x") + "<br/>");
// 截取字符串，从3开始，截取10个，表示范围，一般都是包头不包伟
document.write(str.substring(3,10) + "<br/>");
// 截取从指定下标值开始的n个字符
document.write(str.substr(3,10) + "<br/>");

// 全部转换为大写
document.write(str.toUpperCase() + "<br/>");
// 全部转换为小写
document.write(str.toLocaleLowerCase() + "<br/>");
// 按照指定字符切割字符串
var tel = "029-88899900-8-1";
var tels = tel.split("-");
document.write(tels + "<br/>"); // 返回一个数组
document.write(tels[0] + "<br/>");
var n1 = "大家好";
var n2 = "吃了吗";
// 拼接字符串
document.write(n1.concat(n2)+ "<br/>");
var str3 = "    hello   ";
// 去掉字符串的前后空格，如果想去掉全部空格，可以已使用正则表达式
document.write(str3.trim() + "!" + "<br/>");
```