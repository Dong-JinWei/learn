# Java基础语法

> day4[2021/2/6]

## 数据类型的拓展

- 不同就进制表示10 

>二进制：`0b10`  
八进制：`010`  
十进制：`10`  
十六进制：`0x10`  

- 浮点数有误差，需要精确数字时，不使用浮点数。

## 包机制

> 类似文件夹

- 为了更好的组织类，Java提供了包机制，用于区别类名的命名空间。
- 包语句的语法格式为：  

```java
package pkg1[. pkg2[. pkg3]];
```

- 一般利用公司域名倒置作为包名；
  > www.baidu.com就可以写为com.baidu.www

- 使用`import`语句可以导入包

```java
import package1[.packge2].(classname|*);
```

## JavaDoc生成文档

```java
package com.dong.day4;

/**
 * 
 * @author Dong
 * @version 1.0
 * @since 1.8
 *
 */
public class homework {
	String name;
	
	
	/**
	 * @author Dong
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String test(String name) throws Exception{
		return name;
	}

}
```  

> @author 作者名  
@version 版本号  
@since 指明需要最早使用的jdk版本  
@param 参数名  
@return 返回值情况  
@throws 异常抛出情况

命令行下，使用`javadoc`生成文档  

```bash
javadoc -encoding UTF-8 -charset UTF-8 homework.java

#-encoding UTF-8
#-charset UTF-8  指定字符类型
```
