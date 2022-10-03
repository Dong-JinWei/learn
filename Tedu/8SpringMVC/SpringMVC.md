# SprigMVC

## 一、概念

1. SpringMVC是Sping框架的一个模块，是一个基于MVC的**web框架**，可以与 Spring 无缝集成

2. 可以解决 web 开发中的常见问题，如参数接收、页面跳转、文件上传下载等。
3. 是单例模式，线程不安全，不要使用成员变量

## 二、工作原理



## 三、测试hello world

## 方式一

1. 创建maven的web工程
2. 导入依赖
3. 创建类，实现Controller接口
4. 配置applicationContext.xml 文件
5. 创建 JPS 文件
6. 测试 hello world

## 方式二

（实现HttpRequestHandler接口）

## 方式三

普通类

# 接收数据、页面跳转、传递数据

## 一、拦截的url格式

```xml
<url-pattern>/</url-pattern>
```



## 二、接收参数

1. 方法的参数名和客户端传递的参数名保持一致
2. 方法的参数是 bean 类型参数，bean 对象中的数据成员和客户端传递的参数保持一致
3. 方法中添加HttpServletRques的形参
4. RESTful 风格：url/值/值/值
   1. @RequestMapping("/url/{name1}/{name2}/{name3}")
   2. 方法的形参格式：@PathVariable("名字") 形参1

## 三、页面跳转

1. 返回字符串转发
2. 返回字符串重定向
3. 返回ModelAndView对象转发：
4. 增加request和response参数

## 四、传递参数

1. 在url后使用？名字=值&名字=值
2. 返回ModelAndView对象
3. 增加request和session参数

## 五、响应数据

```java
@ResponseBody
```



设置金泰资源和页面跳转url时，一定要使用绝对路径，前面加斜线。

金泰资源的第一个斜线表示主机名，上下文路径/路径/文件名

url前的第一个斜线表示上下文路径，/路径/文件名

# 上传和下载

## 一、文件下载

1. 前端页面
2. 添加jar文件commons-io，commons-fileupload
3. 配置文件解析器