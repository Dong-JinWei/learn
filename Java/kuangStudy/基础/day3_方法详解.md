# 方法

> day3 [2020/2/5]

## 什么是方法  

`System.out.println()`  
调用`System`类中的标准输出对象`out`中的`println`方法其中，`System`是类，`out`是对象，`println()`是方法

- 方法是语句的集合
  - 方法是解决一类问题的步骤的有序集合  
  - 方法包含于类或对象中  
  - 方法在程序中被创建，在其他地方被引用  

- 方法的设计原则： 方法的本意是功能块，就是实现某个功能的语句快的集合。设计方法的时候最好保持方法的原子性，**就是一个方法只完成一个功能，这样有利于我们后期的扩展。**  

## 方法的定义  

```java
修饰符 返回值类型 方法名(参数类型 参数名){
    ···
    方法体
    ···
    return 返回值;
}
```

- 方法包含一个方法头和一个方法体。  
  - 修饰符：定义了方法的访问类型。
  - 返回值类型：没有返回值的时候返回的关键字是`void`。
  - 方法名：方法的实际名称，需遵守驼峰命名法。
  - 参数类型：类似占位符。
    - 形式参数：用来定义作用。
    - 实参：实际调用传递给方法的参数。
  - 方法体：方法具体包含的语句，定义该方法的功能。

拓展了解：值传递（Java）和引用传递

## 方法的调用

- 静态方法
  - 带有static的方法
- 非静态方法
  - 不带有static的方法
- 形参和实参
- 值传递和值引用
- this关键字

## 方法的重载

- 重载就是在一个类中，有相同的函数名称，但形式参数不同的函数。
- 方法重载的规则。
  - 方法名称必须相同。
  - 参数列表必须不同（个数不同、类型不同、参数排列顺序不同等）。
  - 方法的返回值类型可以相同也可以不同。
  - 仅仅返回值类型不同不足以成为方法的重载。

实现理论

> 方法名称相同时，编译器会根据调用方法的参数个数、参数类型等去逐个匹配，以选择对应的方法，如匹配失败，则编译器报错。

```java
//方法重载练习

public class Day3 {
	public static void main(String[] args) {
		System.out.println(add(1,2,3));
		System.out.println(add(1.5,2.5,3.5));
	}
	
	public static int add(int m, int n, int x) {
		int sum = 0;
		sum = m + n + x;
		return sum;
	}
	public static double add(double m, double n, double x) {
		double sum = 0;
		sum = m + n + x;
		return sum;
	}

}

```

## 命令行传参

```java
//main函数的参数是一个数组，循环打印这个数组

public class Day3 {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]: " + args[i]);
		}
	}

}

```

- 命令行传参步骤
  1. 找到Java源文件（eclipse：右键文件->Show In -> System Explorer）。
  2. 使用`javac`进行编译。
  3. 返回到src目录下使用包名打开编译文件(java 包名.编译文件名 参数)。

## 可变参数

- 在方法声明中，在指定参数类型后加一个省略号（...）。
- 一个方法中只能有一个可变参数，他必须是方法的最后一个参数。任何普通参数必须在他之前声明。

## 递归

- 递归就是自己调用自己。
- **递归结构包括两个部分：**
  - **递归头：什么时候不调用自身方法。如果没有头，将陷入死循环。**
  - **递归体：什么时候需要调用自身方法。**

```java
//计算阶乘

public class Day3 {
	public static void main(String[] args) {
		System.out.println(f(5));

	}
	public static int f(int n) {
		
		if (n == 1) {
			return 1;
		}else {
			return n * f(n - 1);
		}
	}

}        
```