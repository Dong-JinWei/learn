[TOC]

# 面向对象编程

> 2021/2/10

## 面向过程与面向对象

- 面向过程思想
  - 步骤清晰，第一步做什么，第二步做什么。
  - 面向过程适合处理一些较为简单的问题。
- 面向对象思想
  - 物以类聚，**分类的思维模式**，思考问题首先会解决问题需要哪些分类，然后对这些分类进行单独思考。最后才对某个分类下的细节进行面向过程的思索。
  - 面向对象适合处理复杂的问题，适合处理需要多人协作的问题。
- 对于描述复杂的事物，为了宏观上把握、从整体上合理分析，我们需要使用面向对象的思路来分析整个系统。但是，具体到微观操作，仍然需要面向过程的思路去去处理。

## 什么是面向对象

- 面向对象编程（Object-Oriented Programming，OOP）
- 面向对象编程的本质就是：**以类的方式组织代码，以对象的组织（封装）数据。**
- 抽象
- 三大特性
  - 封装
  - 继承
  - 多态
- 从认识的角度考虑是先有对象后有类。**对象**是具体的事物，**类**是抽象的，是对 对象的抽象。
- 从代码运行的角度考虑是先有类后有对象。类是对象的模板。

## 类与对象的关系

- 类是一种抽象的数据类型，他是对某一类事物整体描述/定义，但是不能代表某一个具体的事物。
- 对象是抽象概念的具体实例。

```java
package com.dong.classDemo;

public class Application{
	public static void main(String[] atgs) {
		
		//类: 抽象的,实例化
		
		Persion xm = new Persion();
		Persion xh = new Persion();
		
		xm.name = "小明";
		xm.age = 3;
		
		System.out.println(xm.name);
		System.out.println(xm.age);
		
		xh.name = "小红";
		xh.age = 3;
		
		System.out.println(xh.name);
		System.out.println(xh.age);
		
		
	}

}

```

```java
package com.dong.classDemo;

//类

public class Persion {
	
	//属性: 字段
	String name;
	int age;
	
	//方法
	public void study(){
		System.out.println(this.name + "在学习");
	}

}
```

## 构造体

特点：

1. 和类名相同
2. 没有返回值

作用：

1. new 本质是调用构造器方法
2. 初始化对象的值

## 小结

> 1. 类与对象：类是一个模板，抽象；对象是一个具体的实例
> 2. 方法的定义与调用
> 3. 对应的引用
引用类型：基本类型（8）
对象是通过引用来操作的：栈--->堆
> 4. 属性：字段Field 成员变量
默认初始化：
数字： 0 0.0
char： u0000
boolean：false
引用： null
> 5. 对象的创建和使用
>
>> - 必须是用new关键字创造对象，构造器 Person dong = new Person();
>> - 对象的属性 dong.name
>> - 对象的方法 dong.sleep()
>>
> 6. 类：静态的属性 属性
动态的方法 方法

***
## 封装

