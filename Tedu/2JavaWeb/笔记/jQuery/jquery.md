#                              JQuery

## 初识JQuery

### 一、JQuery简介

​	本质：JS语言编写的程序库。

​	好处：写的少，做的多。

​	功能：操作DOM元素、操作页面样式、属性、事件处理、很方便进行AJAX操作

​	下载：https://jquery.com/

​	hello world：加载jquery.js       $(function(){})



### 二、JQuery语法

​	JQuery对象：JQuery对象.方法名(实参表)；

​	JS对象：JS对象.属性名=值；




​	语法：$("选择器").方法名(实参表)；

​	css：设置或获取样式。

​			css("样式名", "值");

​	html：设置或获取标签体内容。



### 三、JQuery代码风格

### 1、链式操作：

​	$("选择器").方法名(实参表).方法名(实参表).方法名(实参表).......

### 2、隐式迭代：

​	选择器选中的标签对象都会进行响应的操作。



### 四、JQuery对象 和 JS对象 的关系

### 1、JQuery对象本质：

JQuery对象的本质：是数组，数组中的元素是 JS对象。



### 2、JQuery对象和JS对象的转换：

JQuery对象转换为JS对象：JQuery对象[下标]

JS对象转换为JQuery对象：$(JS对象)



保存JQuery对象的变量名通常以 $ 开头。



## 选择器

### 一、基本选择器：

### 1、全局选择器：

*{}   选择所有标签，包括html标签

### 2、标签选择器：

标签名{}  选择名字相同的标签。

### 3、类选择器：

.名字{}  选择class 属性值为指定名字的标签。class="a b c"

### 4、id选择器：

#名字{}  选择id属性值为指定名字的标签。

### 5、优先级

id > class > 标签 > 全局



### 二、高级选择器：

E F 是某种选择器。

#### 1、层次选择器：

##### 	1.1、后代：

​		E F{}

​		根据E选择器选择标签，在选择的标签的 后代 中，根据F选择器进行选择。

##### 	1.2、儿子：

​		E>F{}

​		根据E选择器选择标签，在选择的标签的 儿子 中，根据F选择器进行选择。

##### 	1.3、紧跟其后的一个兄弟：

​		E+F{}

​		根据E选择器选择标签，在紧跟其后的一个兄弟中，根据F选择器进行选择

##### 	1.4、其后所有的兄弟：

​		E~F{}

​		根据E选择器选择标签，在紧跟其后的所有兄弟中，根据F选择器进行选择

##### 	1.5、并集

​		E,F{}

​		根据 E选择器 和 F选择器 选择标签。

##### 	1.6、交集

​		EF{}

​		根据 E选择器 和 F选择器 同时选择标签。

#### 2、结构伪类选择器：

##### 	2.1、E:first-child：

​		根据 E选择器选择标签，在选择的标签中选择是某个标签的第一个儿子的标签。

##### 	2.2、E:last-child：

​		根据 E选择器选择标签，在选择的标签中选择是某个标签的最后一个儿子的标签。

##### 	2.3、E:nth-child(n)：

​		根据 E选择器选择标签，在选择的标签中选择是某个标签的最后n个儿子的标签。

​		n：1 2 3 4...    even偶数   odd奇数



##### 	2.4、E:first-of-type:

​		根据 E选择器选择标签，父标签相同的为一组，在选择每组中的第一个儿子的标签。

##### 	2.5、E:last-of-type:

​		根据 E选择器选择标签，父标签相同的为一组，在选择每组中的最后一个儿子的标签。

##### 	2.6、E:nth-of-type(n):

​		根据 E选择器选择标签，父标签相同的为一组，在选择每组中的第n个儿子的标签。

​		n：1 2 3 4...    even偶数   odd奇数



#### 3、属性选择器：

##### 	3.1、[属性名]

​		给属性名赋值的标签。

##### 	3.2、[属性名="值"]

​		给属性名赋指定的值的标签。

##### 	3.3、[属性名$="值"]

​		给属性名赋值，值以指定的值结尾的标签。

##### 	3.4、[属性名^="值"]

​		给属性名赋值，值以指定的值开头的标签。

##### 	3.5、[属性名*="值"]

​		给属性名赋值，值包含指定的值的标签。



### 三、过滤器：

​	创建JQuery对象时使用。

#### 	1、:first

​	筛选第一个

#### 	2、:last

​	筛选最后一个

#### 	3、:even

​	筛选偶数个。JQuery对象中的对象从0开始编号。

#### 	4、:odd

​	筛选奇数个。

#### 	5、:eq(n)

​	筛选等于n的。

#### 	6、:gt(n)

​	筛选大于n的。

#### 	7、:lt(n)

​	筛选小于n的。



## 事件与动画

### 一、事件分类：

1、基本事件：

鼠标相关   键盘相关   窗口相关   表单相关

通过调用方法设置事件处理程序；事件属性去掉on的单词是方法名；

2、复合事件：

鼠标连续点击   鼠标移入移出



### 二、鼠标相关的事件：

#### 1、鼠标点击：

click

#### 2、鼠标移入：

mouseover    mouseenter

#### 3、鼠标移出：

mouseout    mouseleave



### 三、键盘相关的事件：

#### 1、键盘按下：keydown  

可以监听普通按钮  功能按钮的按下事件。



### 四、窗口相关的事件：

#### 1、移动滚动条事件：scroll



### 五、表单事件：

#### 1、提交事件：submit   

事件处理程序返回boolean类型数据，true进行页面跳转，false不跳转。

#### 2、获取焦点事件：focus

#### 3、失去焦点事件：blur

#### 4、改变事件：change		

失去焦点时，内容改变，则触发该事件。

#### 5、触发事件：

调用对应的方法，没有传function类型参数，则触发该事件的操作。



### 六、绑定事件和移除事件：

#### 1、绑定事件 bind

bind("事件类型"  [, json格式数据]， function(data){事件处理程序})



json格式数据：{属性名：值，属性名：值，属性名：值.......}

获取传递的数据：添加形参；形参名.data.属性名；



可以给同一个事件设置多个事件处理程序。



#### 2、移出事件 unbind

##### 2.1、unbind()

将标签对象中 所有事件对应的所有事件处理程序移除。

##### 2.2、unbind("事件类型")

将标签对象中 指定的事件类型 对应的 所有事件处理程序 移除。

##### 2.3、unbind("事件类型" , function名)：

将标签对象中 指定的事件类型 对应 指定的事件处理程序 移除。



### 七、复合事件：

#### 1、鼠标连续点击   

toggle(function(){},  function(){}, function(){}.......);

#### 2、鼠标移入移出

hover(function(){},  function(){});

第一个函数是鼠标移入事件处理程序。

第二个函数是鼠标移出事件处理程序



### 八、动画：

#### 1、hide  和 show

```
$(selector).show(speed,callback)
$(selector).hide(speed,callback)
```

#### 2、fadeOut  和  fadeIn

```
$(selector).fadeOut(speed,callback)
$(selector).fadeIn(speed,callback)
```

#### 3、slideDown  和  slideUp

```
$(selector).slideDown(speed,callback)
$(selector).slideUp(speed,callback)
```

#### 4、animate

```
$(selector).animate(styles,speed,easing,callback)
```

style是json格式数据：{样式名:值，样式名:值.......}

该值时样式最终的值，即动画结束后的样式值。



callback是回调函数，当动画过程结束时自动调用。



补充知识：

1. document.body

​	返回html dom中的body节点 即<body>

2. document.documentElement

​	返回html dom中的root根节点 即<html>



范例：

点击按钮页面移动到某个位置。

轮播图。



## DOM操作

### 一、样式

#### 1、css

​	设置样式：

​		css("样式名"， "值")；

​		css({"样式名"：值， "样式名"：值， .......})

​	获取样式：

​		css("样式名");



#### 2、addClass、hasClass、removeClass

​	addClass("类选择器名");

​	addClass("类选择器名 类选择器名 类选择器名......");

​	hasClass("选择器名")；

​	removeClass("类选择器名");

​	addClass("类选择器名 类选择器名 类选择器名......");



### 二、内容：

#### 	1、html()

​	html("内容")：设置标签体内容。

​	html()：获取标签体内容



### 三、属性

#### 	1、attr()

​	attr("属性名" [，值])：设置 或 获取 属性值。操作普通属性。如：src  id  name

#### 	2、prop()

​	prop("属性名" [，值])：设置 或 获取 属性值。操作控制属性。如：disable  checked



​	获取或设置value属性值：val([值])



练习：

​	点击多选框，按钮变为可以点选；来回切换。

​	左右连个加减按钮，中间一个li标签，初始值为1，点击两个按钮修改li中的值，为1时，不能减。



案例：选项卡



### 四、标签操作---增删改查

#### 1、获取标签：

##### 	1.1、通过选择器获取标签：

​		$("选择器")

##### 	1.2、获取儿子标签：

​		children(["选择器过滤器"])

##### 	1.3、获取父标签：

​		parent();

##### 	1.4、获取前面一个兄弟标签：

​		prev(["选择器过滤器"])

##### 	1.5、获取前面所有兄弟标签：

​		prevAll(["选择器过滤器"])

##### 	1.6、获取后面一个兄弟标签：

​		next(["选择器过滤器"])

##### 	1.7、获取后面所有兄弟标签：

​		nextAll(["选择器过滤器"])

##### 	1.8、获取前后所有兄弟标签：

​		siblings(["选择器过滤器"])

#### 2、创建标签：

​	$("标签")

#### 3、添加标签：

##### 	3.1、添加到所有儿子前面

​		JQuery对象.prepend(标签对象);

##### 	3.2、添加到所有儿子后面

​		JQuery对象.append(标签对象);

##### 	3.3、添加到某个标签的前面

​		old.before(new)

##### 	3.4、添加到某个标签的后面

​		old.after(new)

#### 4、删除标签：

​	4.1、remove();

​	4.2、empty();

#### 5、复制标签：

​	clone(true/false);

​	true：复制原有标签的事件处理程序。

#### 6、替换标签：

​	old.replaceWith(new)

#### 7、遍历JQuery对象中的元素：

​	jquery对象.each(function(index, element){

​	})

​	JQuery对象中的每个元素执行function方法。index保存元素的下标，element保存元素，即JS对象。



练习：留言板



### 五、CSS-DOM

#### 1、width()

​	宽

#### 2、height()

​	高

#### 3、offset() ：

​	距离页面的左边上边距离，返回对象。   对象中有两个属性： top   left



## 表单校验

### 一、表单校验的思路：

​	1、获取表单元素的值。

​	2、使用JS方法进行校验。

​	3、根据校验结果返回true或false。



### 二、表单选择器：

​	:input：获取所有表单元素：       

​	:text        

​	:password：获取密码框      

​	:radio  ：单选框

​	:checkbox   ：多选框

​	:submit         :image       :reset       :button     :file     

​	:hidden ：获取display=none  或 input标签type="hidden"的标签    

​	:enabled       :disabled      

​	:checked：获取所有选中的单选按钮和多选按钮。

​	:selected：获取下拉菜单中选中的选项。



### 三、通过string提供的方法进行校验：

​	校验用户名，数字字母下划线组成，6-16个字符。



### 四、正则表达式：

#### 	1、优点：

​	代码简洁   验证严谨



​	正则表达式对象：RegExp  --- regular  expression

#### 	2、创建对象：

##### 	2.1、/字符串/附加参数

##### 	2.2、new  RegExp("字符串"， "附加参数");



#### 	3、附加参数： 

​	i：忽略大小写匹配     

​	g：全局匹配     

​	m：多行匹配



#### 	4、方法成员：

​	test    exec

#### 	5、数据成员：

​	global      ignoreCase     multiline



### 五、正则表达式特殊字符：

^：匹配一行开始的缝隙。指定开始字符。

$：匹配一行结束的缝隙。指定结束字符。

[]：匹配方括号中某一个字符。如：[abc]   [a-z]  [0-9] [A-Z]

\s：空字符。如空格、\t、\n      space

\d：0-9数字。

\w：单词字符，数字、字母、下划线。

{n}：匹配n个连续的前面的表达式。

{n,}：匹配多于等于n个连续的前面的表达式。注意：逗号两边不能有空格

{n,m}：匹配多于等于n个，少于等于m个连续的前面的表达式。注意：逗号两边不能有空格

*：0个或多个连续的前面的表达式。{0,}

+：1个或多个连续的前面的表达式。{1,}

?：0个或一个连续的前面的表达式。{0,1}

.：除了 \n  \r 之外的其他任意一个字符。

|：或。(ab|123|rt)



特殊符号转义：前面加 \

范例：

用户名：数字、字母、下划线、减号；以字母开头；6-20位

邮箱：数字 字母 6-10 @ 字母 数字 2-5 . com 或 cn

​			[a-zA-Z0-9]{6,10}@[a-zA-Z0-9]{2,5}\.(com|cn)

电话号码：1 3-9 9位数字

​			1[3-9]\d{9}



### 六、使用H5方式表单校验：

### 1、required属性

必须写入数据。

### 2、pattern属性

进行正则表达式的判断。如果完全匹配则为真。

### 3、自定义错误提示信息

给提交按钮的单击事件设置事件处理程序。

对内容判断

