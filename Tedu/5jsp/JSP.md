## javaSE：

 Java 基础：面向过程 面向对象

 Java 高级：异常 输入输出流 线程 集合 网络通信 反射 枚举

数据库：

 oracle mysql PL/SQL（语法、触发器、游标、视图、索引、事务、优化）

JDBC：

 java 访问数据、Druid

HTML：

 开发网页 a p img span div ol-li ul-li iframe

CSS：

 美化页面 选择器 浮动 盒子模型 定位 字体 文本 背景 列表 动画

Javascript：

 动态效果和表单校验 语法 BOM（页面跳转、定时器） DOM（标签 属性 样式 内容 事件）

JQuery：

 JS 语言程序库 $("选择器 过滤器")

jsp：servlet jsp ajax

easyUI

maven spring springMVC mybatis svn

springBoot springCloud elementUI

实战项目

# JSP 前导知识

- 作用：开发动态页面
- 概念：servlet JSP ajax

## 概念

### 一、web 开发相关概念

#### 1、什么是互联网

- internet-----互联网
- 互联网：是计算机网络，有多个服务器和局域网组成。
- 作用：信息共享。

#### 2、什么是 web

web：world wide web www 万维网。

- 是最重要的信息服务类型。（邮件服务）
- 信息服务都是以超文本标记语言（HTML）进行组织的。
- 使用超文本传输协议（HTTP）进行传输。

#### 3、URL URI

URL：

- 统一资源定位。Uniform Resource Locator
- URL 组成：协议名 主机名或域名（端口号） 路径名 文件名四部分组成。如：<https://www.sohu.com/a/b.html>

URI：

- 统一资源标识符。Uniform Resource Identifier
- URI 组成：协议名 主机名或域名（端口号） 路径名 三部分组成。

#### 4、web 程序

- 保存位置：服务器
- 运行方式：给服务器发送请求。a 标签、地址栏、JS
- 运行主体：服务器
- 处理结果：结果格式必须复合 HTML 要求

#### 5、B/S 架构和 C/S 架构

##### 5.1、B/S

B：Browser 浏览器 S：server 服务器

优点：

- 开发成本低。
- 管理维护简单。
- 产品升级便利。
- 对用户的培训费用低。
- 用户使用方便，出现故障的概率小。

缺点：

- 安全性不足。
- 客户端不能随心改变，受浏览器的限制。

##### 5.2、C/S

C：Client 客户端

S：server 服务器

### 二、tomcat 服务器

#### 1、web 服务器

- 安装了服务器程序的主机。
- 服务器用来实现网页的传递和 web 程序的执行。
- 服务器专门用来保存网页和 web 程序。
- 服务器程序：tomcat IIS Apache 等。

#### 2、服务器的命名方式

- 局域网：主机名。
- 互联网：域名。必须按照互联网方式命名。
- DNS：Domain Name System 域名系统

#### 3、tomcat 服务器

- bin：保存可执行文件。startup.bat：启动服务器 showdown.bat：关闭服务器
- conf：保存配置文件。server.xml web.xml
- lib：tomcat 运行时需要的程序库
- logs：日志文件
- temp：临时文件。
- webapps：保存 web 程序。将 web 程序部署- 到该文件夹下。
- work：jsp 文件转换为的 java 文件。

#### 4、主目录

- 主目录映射到站点的域名。
- 主目录时站点访问者的起始点。
- tomcat 默认主目录是 webapps。

#### 5、虚拟目录

在 host 标签内，添加如下代码

```xml
<Context path="/virtual" docBase="D:\\web"></Context>
```

#### 6、配置 tomcat 端口号

```xml
<Connector port="80" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```

### 三、HTTP 协议

HTTP：超文本传输协议，是请求响应式协议

请求方式：

- get：不安全；发送数据量比较小，一般在 2k 左右；速度快
- post：安全；可以发送大数据，可达到几百 mb；速度慢

版本：

- 1.0：短连接，请求响应结束之后，连接**会**断开
- 1.1：长连接，请求响应结束之后，连接**不会**断开

HTTP 协议在 OSI 参考模型的应用层

# Servlet

## servlet 技术

servlet 是使用 java 语言开发的代码。  
使用 servlet 接口或使用实现了 servlet 接口实现的类开发程序。  
servlet 提供了请求和响应服务。

## srvlet 功能

创建并返回一个包含了基于客户端请求的动态内容的完整的 HTML 页面。  
与其他服务器（数据库）资源进行通信。

## seervlet 调用方式

- a 标签、form 标签
- 浏览器地址栏输入 URL
- java 程序，使用 respone 对象

## servlt 技术实现

1. 实现 Servlet 接口

   1. 配置 classpath 环境变量
   2. 开发 servlet 程序

      1. 在 webapps 下创建 servletTest 文件夹
      2. 将 webapps 里的 WEB-INF 文件夹 拷贝到 servltTest
      3. 删除 classes 里的内容
      4. 编写 java 程序和 xml 文件

         ```java
         import javax.servlet.*;

         public class MyServlet implements Servlet {
            public void destroy() {
               System.out.println("destroy==============");
            try{
               Thread.sleep(3000);
            }catch(Exception e){}
            }

            public ServletConfig getServletConfig() {
               return null;
            }

            public String getServletInfo(){ return null;}

            public void init(ServletConfig config) throws ServletException {
               System.out.println("init=====");
            }

            public void service(ServletRequest req, ServletResponse res) throws              ServletException, java.io.IOException{
               System.out.println("service=======");
            }
         }
         ```

         ```xml
         <?xml version="1.0" encoding="UTF-8"?>

         <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                              http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1"
         metadata-complete="true">

            <servlet>
               <servlet-name>servlet</servlet-name>
               <servlet-class>MyServlet</servlet-class>
            </servlet>
            <servlet-mapping>
               <servlet-name>servlet</servlet-name>
               <url-pattern>/test</url-pattern>
            </servlet-mapping>
         </web-app>

         ```

      5. 编译 servlet 程序
         `javac MyServlet.java`
      6. 给指定的 URL 发送请求
         `localhost:8080/servletTest/Test`
         - 注意：默认访问的是 webapps 文件夹，servletTest 文件夹在 webapps 下，所以访问时直接在主机名后边输入文件夹路径
      7. 在服务器窗口中会显示 servlet 的执行结果

2. 继承 Genric 抽象类
3. 继承 HttpServlet 抽象类
   1. 创建 javaWeb 工程
   2. 添加 tomcat jar 包
   3. 继承 HttpServlet
   4. 重写 `doGet` 和 `doPost` 方法

> 解决 Tomcat 控制台乱码
> 修改 conf 文件夹下的`logging.properties`文件，将其中的 UTF8 全部改为 GBK

## servlet 生命周期\*

1. 客户端请求到达服务器,服务器创建请求对象 request 和响应对象 response。
2. 将 servlet 类加载到内存，创建 servlet 对象
3. 执行 servlet 中的 init 方法
4. 执行 servlet 中 service 方法。将请求对象和响应对象传给 service 方法。
5. 在 service 中通过请求对象获取客户端发送的数据；通过响应对象给客户端响应数据。
6. 更多客户端发送请求，仍然激活该 srvlet 对象，调用对象中的 service 方法
7. 服务器关闭，服务器调用 servlet 中的 destroy 方法销毁 servlet。
8. servlet 由 JVM 的垃圾回收器进行垃圾回收

# servlet 常用类

## HttpServletRequest

1. 获取客户端发送的数据
   - public String getParameter(String name)：获取一个数据
   - public String[] getParameterValues(String name)：获取一组数据
2. 设置接收到的客户端数据编码
   - public void setCharacterEncoding(String env)：设置编码
3. 页面跳转（转发）
   - public RequestDispatcher getRequestDispatcher(String path).forward(req,resp)：页面跳转
4. 保存获取的数据
   - public void setAttribute(String name, Object o)：将对象 o 保存到 name 中
   - public Object getAttribute(String name)：获取 name 中保存的对象

## HttpServletResponse

1. 给客户端响应数据
   - public java.io.PrintWriter getWriter()
   - public void write(String s)
2. 设置给客户端响应的中文的编码
   - public void setContentType(String type)
3. 页面的跳转（重定向）
   - public void sendRedirect(String location)

重定向和转发的区别：

|        | 发送请求次数 | 地址栏内容 | 访问外网 | 效率 | request 有效性 |
| :----: | :----------: | :--------: | :------: | :--: | :------------: |
| 重定向 |      2       |    改变    |   可以   |  低  |      无效      |
|  转发  |      1       |   不改变   |  不可以  |  高  |      有效      |

登录范例：

1. 前端登录页面
2. 创建表、添加记录
3. 添加连接 mysql 数据库对应的 jar 包

## ServletConfig

获取 web.xml 文件中，`<servlet>` 中 `<init-param>`中配置信息
public String getInitParameter(String name)

## HttpSession

1. 获取类对象：`request.getSession()`
2. 设置获取数据：`session.setAttributer("user", "wang")`
3. 获取数据：`session.getAttributer("user")`

生命期：

request：一次请求
session：一次会话

## SerletContext

1. 获取类对象：`getServletContext()`
2. 获取 servlet 中的配置数据 `public String getInitParameter(String name)`
3. 用途：将编码配置在 web.xml 中，在所有 servlet 中获取，如编码
4. 生命期：一次服务器的启动和关闭

# JSP

## 一、概念

- JPS：java Server Page，java 服务器页面
- 作用：方便动态开发页面
- 执行：转换为 Servlet 类，编译成 class 字节码文件，执行字节码文件

## 二、JSP 脚本元素

1. `<% java 程序 %>`：在标签中定义的变量是`_jspService` 方法中的局部变量
2. `<%=java表达式%>`：末尾没有分号，完成的功能，将表达式的值替换标签
3. `<%! 定义成员变量、成员方法%>`：该标签定义的变量是 ，jsp 对应的类的全局变量
4. `<%--注释内容--%>`：不会将该注释相应给客户端

## 三、JSP 指令元素

### 1. 格式和作用

`<%@ 指令元素名 属性名="值" 属性名="值" 属性名="值"...>`

提供给服务器，用以知名如何编译生成 servlet 程序

### 2. page

- language：使用的编程语言（java，c)
- import：导包（java.util.Date）
- session：设置 session 对象是否有效（true/false)
- info：设置信息，通过 servlet 对象的 getServletInfo() 方法获取对象信息
- error Page：设置出错页面（url）
- isErrorPage：设置该 jsp 页面是否是错误页面（true/false)
  - 如果是错误页面，转换后的 java 文件会有 exception 对象
- pageEncoding：客户端发送数据的编码（UTF-8）
- auto Flush：设置页面是否自动刷新（true/false)
- content Type：服务器响应的数据编码（UTF-8）

import 可以有多个，其他只能有一个

### 3. include

在该本页面中，嵌入另一个页面

> 注意：子页面设置的样式会影响到主页面
> 操作：将子页面的原码包含的主页面，编译后只有一个 class 文件
> 子页面变了，需要重新编译后才能显示更新后内容

### 4. taglib

标签库（JSTL：JSP Tag library）

## 四、JSP 动作元素

- jsp:forward 把请求转到一个新的页面。（转发）
  - jsp:param 设置参数
- jsp:include 在页面被请求的时候引入一个文件。
  - 操作：将两个 jsp 分别编译，生成两个 java 文件在运行主页面时运行到该语句时取执行对应的 class 文件
  - 注意：子页面的**样式**不会影响到主页面
  - 子页面变了，只需要编译子页面，不需要编译子页面
- jsp:useBean 寻找或者实例化一个 JavaBean。
  - 创建一个类对象，将该对象添加到指定到域对象中
- jsp:setProperty 设置 JavaBean 的属性。
- jsp:getProperty 输出某个 JavaBean 的属性。
- jsp:plugin 根据浏览器类型为 Java 插件生成 OBJECT 或 EMBED 标记。
- jsp:element 定义动态 XML 元素
- jsp:attribute 设置动态定义的 XML 元素属性。
- jsp:body 设置动态定义的 XML 元素内容。
- jsp:text 在 JSP 页面和文档中使用写入文本的模板

# JSP 的九大内置对象

## 一、九大内置对象

本质：将 jsp 转换为 servlet 时，在`_jspService` 方法中，由系统创建的对象

## 二、request：HttpServletRequest 类

1. 获取客户端发送的数据
   - `public String getParameter(String name)`
2. 设置编码
   - `public void setCharacterEncoding(String env)`
3. 域对象保存获取数据
   - `public void setAttribute(String name, Object o)`
4. 页面跳转（转发）
   - `public RequestDispatcher getRequestDispatcher(String path)`
     - `public void forward(ServletRequest request, ServletResponse response)`
5. 获取请求头中的数据
   - `public java.util.Enumeration<E> getHeaderNames()`
   - `public String getHeader(String name)`
   - referer：属性，值是前一个页面的 URL
6. 获取客户端的主机名和 ip 地址
   - `public String getRemoteHost()`
   - `public int getRemotePort()`
7. 获取请求方式
   - `public String getMethod()`
8. 获取 cookie 对象
   - `public Cookie[] getCookies()`
9. 获取客户端请求的 URL
   - `public String getRequestURI()`
   - `public StringBuffer getRequestURL()`
10. 获取上下文路径
    - `public String getContextPath()`

## 三、response：HttpServletResponse 类

1. 页面跳转（重定向）
   - `public void sendRedirect(String location)`
2. 设置编码
   - `public void setContentType(String type)`
3. 给客户端响应数据
   - `public java.io.PrintWriter getWriter()`
     - `public void write(String s)`
4. 设置页面自动刷新
   - 在响应头中设置：`public void setHeader(String name, String value)` `refresh, 35`
5. 设置定时跳转页面
   - `public void setHeader(String name, String value)` `"refresh", "5;/builtInObjects_war_exploded/ok.jsp"`
6. 添加 cookie，将 cookie 响应给客户端
   - Cookie 类：保存键值对
   - 生命期：服务器端创建，Cookie 对象在客户端上保存
   - 客户端发送请求会将该服务器对应保存的 cookie 发送给服务器端
   - 服务器端通过 request 获取 cookie 对象
   - `public Cookie(String name, String value)`
   - `public void setMaxAge(int expiry)` 设置 cookie 的最大生存时间，以秒为单位。
   - `public void setPath(String uri)`
   - `public String getValue()`
   - `public void addCookie(Cookie cookie)`

## 四、session：HttpSession 类

1. 保存获取域数据
   - `public void setAttribute(String name, Object value)`
   - `public Object getAttribute(String name)`
2. 设置 session 生命期
   - `public void setMaxInactiveInterval(int interval)` 指定在 servlet 容器使此会话失效之前客户端请求之间的时间间隔，以秒为单位。负数时间指示会话永远不会超时
3. 清除 session 对象
   - `public void invalidate()`
4. sessionID
   - `public String getId()`
   - sessionId 保存在 cookie 中

> 面试题：session 和 cookie 的区别
> ||数据类型|存储位置|客户端是否可以阻止|
> |:-----:|:-------:|:-------:|:-------:|
> |session|object|服务器|不可以|
> |cookie|String|客户端|可以|

## 五、application：ServletContext 类

1. 获取 servlet 中 context-param 标签中配置的数据
2. 域对象，保存获取数据
   - `public void setAttribute(String name, Object object)`
   - `public Object getAttribute(String name)`
   - 生命期：一起服务器的启动和关闭
   - 创建时间：服务器启动时创建
   - 销毁时间：服务器关闭时销毁
   - 应用：显示页面浏览总次数
3. 获取工程文件在主机中的绝对路径
   - `public String getRealPath(String path)`
   - path：该路径为上下文路径开始的路径

## 六、out：jspWrite 类

1. 将服务器的数据响应给客户端
   - write print
2. 获取缓冲区的大小
   - `public int getBufferSize()`
3. 刷新缓冲区
   - `abstract public void flush()`
4. 判断是否是自动刷新
   - `public boolean isAutoFlush()`

## 七、page：this，当前类对象

## 八、exception

1. 获取出错页面的错误信息
   - `getMessage()`：必须设置：`<@page isErrorPage="true">`

## 九、pagContext：PageContext 类

1. 创建部分内置对象
   - application
   - out
   - config
   - session：`abstract public HttpSession getSession()`
   - request：`abstract public ServletRequest getRequest()`
2. 域对象
   - `abstract public Object getAttribute(String name)`
     - 作用域：当前页面
   - `abstract public Object getAttribute(String name)`
   - `abstract public void removeAttribute(String name)`

## 十、config：ServletConfig 类

1. 重定向到指定的 URL
2. 获取配置信息

# 文件上传与下载

## 一、下载

```xml
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>下载</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/DownloadServlet?file=1.png">下载图片</a>
        <a href="<%=request.getContextPath()%>/DownloadServlet?file=图片.jpg">下载壁纸</a>
    </body>
</html>
```

```java
// 获取需要下载的文件名
        String file = request.getParameter("file");
        // 弹出窗口，显示下载的文件名，选择保存文件的目录
        response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(file,"utf-8"));
        // 根据文件名创建输入流对象
        FileInputStream in = new FileInputStream("D:\\ACGN\\Wallpaper\\" + file);
        // 根据response创建输入了对象
        ServletOutputStream out = response.getOutputStream();
        // 通过输入流对象从文件读数据
        // 通过输出流对象，将读取的数据发送给客户端
        // 循环操作，直到将文件的数据发送完成
        byte[] b = new byte[1024];
        while (true){
            int len = in.read(b);
            if (len <= 0){
                break;
            }else {
                out.write(b, 0, len);
            }
        }
        // 关闭资源
        out.close();
        in.close();
```

## 二、上传

```xml
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>上传</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" value="添加图片" name="f1">
            <input type="file" value="添加图片" name="f2">
            <input type="submit" value="上传">
        </form>
    </body>
</html>
```

```java
 request.setCharacterEncoding("UTF-8");
        // 检查客户端发送的是否是多媒体文件
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter out = response.getWriter();
            out.print("Error:表单必须包含文件");
            out.flush();
            out.close();
            return;
        }
        try {
            // 创建磁盘工厂对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 创建文件上传工具对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 通过上传工具接收request对象中的内容
            List<FileItem> list = upload.parseRequest(request);

            //从list中读取文件内容
            for (FileItem item: list){
                String filename = item.getName();
                if (filename == null || filename.length() == 0){
                    System.out.println("没有上传");
                    continue;
                }
                File f = new File("D:\\Project\\Tedu\\jsp\\upload\\" + filename);
                item.write(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
```

# EL表达式语言

## 一、EL概念、好处、基本语法

- EL：Expression Language 表达式语言
- 使用：在JSP文件、JSTL中使用
- 作用：从内置对象中读取数据。不能写入数据
- 好处：代码简练
- 开关：`<%@page isELIgnored="false"`
- 语法：`${表达式}`

## 二、运算符

- 算数运算符：+，-，*，/（div），%（mod）
  - +：运算符不能进行字符串拼接，将字符串转换为数值，并进行相加
  - /：结果为商的整数和小数。整除0会显示infinity
- 关系运算符：>, <, >=, <-, -- , !=, eq, ne, gt, lt, le, ge
  - lt：less than 小于
  - le：less than or equal to 小于等于
  - eq：ealto 等于
  - ne：not equal to 不等于
  - ge：greater than or equal to 大于等于
  - gt：greater than 大于
- 逻辑运算符：||, &&, ! , or, and, not
- 条件运算符：表达式1？表达式2：表达式3
- 空运算符：empty 表达式，not empty 表达式
  - 表达式结果为null或者`“”`，都为true

## 三、内置对象

- 对象类型
  - bean对象：内置对象名.属性名.成员变量名
  - 数组：内置对象名.属性名[下标]
  - List集合：内置对象名.属性名[下标]
  - Map集合：内置对象.属性名.key名
  - 如果属性前没有设置域对象，则先从作用域小的域对象中取数据如果没有再去作用域大的域对象中取数据

- pageContext
  - `${pageContext.request.contextPath}`
  - 等同于：`pageContext.getRequest().getContextPath()`

- pageScope

- requestScope

- sessionScope

- applicationScope
  - 语法：内置对象名.属性名 内置对象名["属性名"] 
  - 如果属性前没有设置域对象，则先从作用域小的域对象中取数据，如果没有再去作用域大的域对象中取数据
- param
  - param.参数名：获取客户端发送的参数
  - 等同：request.gerParameter("参数名")
- paramValues
  - paramValues.参数名：获取客户端发送的参数。
  - 等同：request.getParameterValues("参数名");
- header
  - header.属性名：获取客户端发来的属性
  - request.getHeaderValues(" 属性名")
- headerValues
  - headerValues.属性名：获取请求头中的数据。
  - 等同：request.getHeaderVaules("属性名");
- cookie
  - cookie.属性名：获取名字为属性名的Cookie对象
  - Cookie.属性名.value：获取Cookie对象中的value值
- initParam
  - initParam.参数名：获取`<context-param>`中配置的数据
  - 等同：servletContext.getInitParameter("参数名");

# JSTL

## 一、概念，好处，功能

- JSTL：JSP Standard Tag （Library JSP标准标签库）

- 好处：简化JSP和WEB程序开发；提高web应用程序在各个服务器之间移值
- 功能：条件处理、迭代处理、国际化、数据库访问、xml文件的访问
- 添加jar包 `<%@taglib>`
- JSTL引入EL表达式，属性值可以是EL表达式

## 二、显示数据到页面：

### 1、c:out：在JSP文件中显示数据。

- 功能等同于：`<%= 表达式%>` `${表达式}`

- value：显示的数据

- default：如果value中的EL表达式的值为空，则显示default的属性值

- escapeXml：true：value属性值中的标签作为普通字符输出；false：value属性值中的标签被解析显示；

## 三、给域对象中设置数据

#### 1、`c:set`给域对象中设置数据

##### 1.1、添加数据：

- var：设置需要保存信息的属性名。

- value：设置保存的数据。

- scope：设置域对象。

##### 1.2、修改对象中的成员变量：

- target：设置需要修改的域对象中的属性名。值为EL表达式，EL表达式的结果 为对象。

- property：设置需要修改是成员变量名。

- value：设置修改的值

## 四、分支

#### 1、`c:if`

```jsp
<c:if test="EL表达式">
	代码：html标签、JSTL标签、<%java程序%>
</c:if>
```

#### 2、`c:choose`

```jsp
<c:choose>
	<c:when test="EL表达式">代码</c:when>
	<c:when test="EL表达式">代码</c:when>
	.....
	<c:otherwise>代码</c:otherwise>
</c:choose>
```

## 五、循环

#### 1、`<c:forEach>`

##### 1.1、指定循环次数：

- var：保存值的变量

- begin：指定开始值

- end：指定结束值

- step：步长

##### 1.2、对数组或List集合进行变量：

- var：保存值的变量

- item：需要遍历的数组或集合

- varStatus：保存状态。
  - index：从 begin 到 end 之间的取值。
  - count：从 1 开始计数的计数器。
  - first：boolean，如果是第一次进入标签体执行，则为true
  - last：boolean，如果是最后一次进入标签体执行，则为true

# 监听器和过滤器

## 一、监听器

设置监听器的过程：

1. 创建类，继承某个接口
2. 在`web.xml`文件中配置`listener`标签

### 1. application

1. 创建销毁
   - 实现接口：通过重写方法中的参数，可以获取`application`对象
   - 配置`web.xml`：`<listener>`标签
2. 属性操作

### 2. session对象

1. 创建销毁
2. 属性操作

### 3. request对象

1. 创建销毁
2. 属性操作

## 二、过滤器

## 1. 过滤器的好处

- 过滤器是实现了`Filter`接口的类

- 工作过程：先执行过滤器，然后在执行rul所映射的web程序
- 应用：设置编码；检测是否登陆过

## 2. 创建过滤器的步骤

- 创建实现了`Filter`接口的过滤器

- 配置web.xml文件

- `<url-pattern>映射路径</url-pattern>`
  - 精确匹配：/路径/文件名，如`/a/index.jsp`
  - 目录匹配：`/路径/*`，如`/a/*`
  - 拓展匹配：带有通配符的文件名，如`*.jsp`
- 设置参数、获取参数

## 3. 过滤器链

在web.xml 中可以配置多个过滤器。当请求的url和dogefilter-mapping标签中的url-urlpattern匹配，则执行多个过滤器，执行顺序是按照配置先后顺序执行的

## 4. 过滤器的生命周期

1. 启动服务器时，服务器自动创建过滤器对象
2. 调用init方法
3. 客户端给服务器发送请求，请求的URL和url-pattern中的url匹配，执行doFilter方法
4. 服务器关闭，执行destroy方法，销毁过滤器对象

# AJAX

## 一、AJAX的概念、功能

- AJAX：Asynchronous JavaScript And Xml（异步的JS和XML）
- 功能：页面不刷新，只刷新页面的局部

## 二、AJAX工作原理

- AJAX引擎世纪之时一个JS对象或函数。当客户端给服务器端发送请求时，由AJAX引擎发送请求，发出的请求是异步完成的，也就是说，不用等到接收到响应后就可以执行后续代码。服务器端给AJAX引擎的数据格式没有要求，可以纯文本，xml，json等，只要AJAX引擎可以理解和翻译这些数据就可以。当AJAX引擎收到来自服务器等响应时，会触发一些完成数据解析的操作

## 三、通过JS实现AJAX操作

```jsp
<%--
  Created by IntelliJ IDEA.
  User: dowei
  Date: 2022/7/22
  Time: 15:08
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
                    document.getElementById("span1").style.color = xmlHttp.responseText;
                    //console.log(xmlHttp.responseText);
                }
            }

            //设置发送请求的url，以及请求方式。
            //url的第一个斜线表示服务器名

            xmlHttp.open("GET", "${pageContext.request.contextPath}/AjaxServlet", true);

            //给指定的url方式请求。可以传递参数。
            xmlHttp.send(null);
        }
    </script>
    <body>
        <span id="span1" style="font-size: 30px">Hello world</span>
        <input type="button" onclick="ajaxFunction()" value="ajax">
    </body>
</html>
```

```java
@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("red");
    }
}
```

### 四、响应JSON格式数据

通过 eval() 方法将JSON格式的字符串转换为JS对象，通过JS对象读取JSON中的数据。

  ```jsp
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
  
  ```

```java
@WebServlet(name = "EvalServlet", value = "/EvalServlet")
public class EvalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("{id:1001,name:'dowei',age:23}");
    }
}
```

## 五、通过JQuery实现AJAX操作

```jsp
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

```

```java
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JQueryServlet", value = "/JQueryServlet")
public class JQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println(user + " " + pwd);

        response.getWriter().write("{name:'dowei', age:99}");
    }
}
```

# MVC

## 一、概念，好处

- MVC：Mode View Controller

- Mode：模型；java类，数据处理类，bean（实体类），逻辑处理类
- Controller：控制器；Servlet类，接受客户端发送的请求，响应数据，页面跳转
- View：视图；前端页面，html，jsp



- 好处：实现程序低耦合，可维护性提高，有利于软件的后期管理。

- 分层：

- Controller层：servlet类

- Service层：逻辑处理

- Dao层：Database  Access  Object  访问数据库

## 二、登陆范例

1. 数据库
2. 前端页面
3. 创建包，在工程中添加jar包
4. dao
5. service
6. controller
