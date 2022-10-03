# servlet

## servlet 生命周期

1. 构造器方法
2. init 初始化方法
3. service 方法
4. destroy 方法

第一次启动时，执行构造器方法，和 init 初始化方法。  
第二部，执行service，重复执行时，也是执行 service 方法  
在程序结束时调用 destroy 方法，销毁

## servlet 与 get/post

强制转换 getMethod方法

doGet做get请求的操作  
doPost 做 post 请求的操作

## 继承HttpServlet 实现Servlet 程序

继承  
根据蛇舞需求重写  
配置web.xml

## 使用idea创建servlet

包名 new servlet

## Servlet 类的继承体系

interface Servlet
实现接口
Class GenericServlet
继承
Class HttpServlet
继承
自定义的Servlet程序

## ServletConfig类

### 三大作用

别名 getServletName()
初始化 在servlet标签中配置<init-param> 
获取servletContext对象

## ServletContext类

web 启动时创建，停止时销毁

实现接口  
获取上下文对象
一个工程只有一个对象   
是域对象

### 作用

1. 获取web.xml的上下文对象 getServletConfig().getServletContext
2. 获取工程路径 getContextPath()
3. 获取硬盘上的项目路径 getRealPath("/")
4. 像map一样存取数据 操作范围，整个工程



