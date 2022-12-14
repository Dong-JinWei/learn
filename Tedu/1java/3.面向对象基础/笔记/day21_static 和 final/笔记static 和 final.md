访问权限 修饰符 类型名 方法名（形参表）{方法体}

## 1、static 静态

数据成员 方法成员 代码块 内部类

静态数据成员：通过静态数据成员实现所有对象共享资源

- 静态数据成员数据类（类加载到内存）。非静态数据成员数据对象。（创建对象）
- 访问静态数据成员：类名.数据成员名 或 对象.数据成员名。
  访问非静态数据成员：对象.数据成员名

将类加载到内存：

1. 将该类对应的字节码文件加载到内存的代码段
2. 给该类的金泰数据成员在内存的数据分配空间。默认是0、null、false、码值为0的字符。

## 静态代码块

- static {代码}
- 当类加载到内存的时候执行一次
  静态代码块的主要作用是对静态数据成员进行初始化

## 静态方法成员：

- static 类型名 方法名(形参表){方法体}。
- 本质：形参中没有默认的 this 参数。
- 静态方法成员属于类。不属于对象。
- 静态方法的调用：`类名.方法名(实参表) 或者对象名.方法名(实参表)`
- 静态方法只能访问静态成员；不可以访问非静态成员。
- 非静态方法中可以访问静态成员
- 对静态方法的调用都放到静态方法中。

## 静态内部类：

static class 类名{}



静态方法成员属于类，不属于对象



//单例模式 静态内部类 懒加载
外部类现在对内存的时候，内部类不会加载到内存。



定义静态内部类变量：外部类名.内部类名 变量名;
实例化静态内部类对象：new 外部类名.内部类名();

# final关键字

数据成员 方法成员 类

final 数据成员：常量

必须初始化。复制运算符，代码，构造方法
不能被改变。
单词大写

当数据成员的知识固定的值，则将其设为final；

好处：提高程序的可读性；有利于代码的后期维护。

