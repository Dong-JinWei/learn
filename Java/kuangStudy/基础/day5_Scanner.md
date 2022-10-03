# Java流程控制

> day5[2021/2/7]



## Scanner对象

- Java提供了可以获取用户输入的类。java.util.Scanner，可以通过Scanner类来获取用户的输入。

- 基本语法：

  ```java
  Scanner s = new Scanner(Syatem.in);
  ```

- 通过scanner类的next()与nextLine()方法获取输入的字符串，在读取前我们一般需要使用hasNext()与hasNextLine()判断是否还有输入的数据。

  ```java
  package com.dong.day5;
  
  import java.util.Scanner;
  
  public class demo1 {
  	public static void main(String[] arges) {
  		
  		//创建一个扫描器对象，用于接收键盘数据
  		Scanner scan = new Scanner(System.in);
  		
  		System.out.println("使用next方法接收: ");
  		
  		if (scan.hasNext()) {
  			String str = scan.next();
  			System.out.println("输出内容为: " + str);
  		}
          //凡是属于IO流的类如果不关闭，会一直占用资源。要养成好习惯，用完就关掉。
  		scan.close();
  	}
  }
  
  ```

- next()与nextLine()的区别：

  - next():

    - 一定要读取到有效字符后才可以结束

    - 对输入有效字符之前遇到的空白，next()方法会自动将其去掉。

    - 只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。

    - **next()不能得到带有空格的字符串。**

  - nextLine():
    - 以Enter为结束符，也就是说nextLine()方法返回的是输入回车之前的所以字符。
    - 可以获得空白。