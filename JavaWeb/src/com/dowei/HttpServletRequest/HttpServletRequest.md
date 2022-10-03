# HttpServletRequest 类

## HttpServletRequest类有什么用。

每次只要有请求进入 Tomcat 服务器，Tomcat 夫区其就会把请求过来的HttP协议信息解析好，
封装到Request对象中。每次传递到 service方法（doGet 和doPost）中给我们使用。
我们可以通过HttpServletRequest对象，获取所有请求的信息。

## HttpServletRequest 类的常用方法

1. getRequestURI()  ：获取统一资源标识符URI
2. getRequestURL()  ：获取统一资源定位符
3. getRemoteHost()  :获取客户端的ip地址
4. getHeader()      :获取请求头User-Agent
5. getParameter()   :获取请求参数
6. getParameterValues()：获取请求参数（参数多的时候用）
7. getMethod()      :获取当前的请求方式
8. serAttribute(key, value); ：设置数据域
9. getAttribute(key);   ：获取数据域
10. getRequestDispatcher()  ：获取请求转发对象

## 如何获取客户端发送的数据

