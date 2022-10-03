# day3 作业

> 2021/2/5

- 写一个计算器，要求实现加减乘除功能，并且能够循环接收新的数据，通过用户交互实现。  

- 思路推荐：

  - 写四个方法：加减乘除

  - 利用循环+switch进行用户交互
  - 传递需要操作两个数
  - 输出结果



```java
package Day3;

import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		System.out.print("输入1开始计算，输入其他数字退出：");
		Scanner scan = new Scanner(System.in);
		int m;
		m = scan.nextInt();
		
		Homework.menu(m);
	}

	
	public static double cslc(double a, int x, double b) {
		double result = 0;
		switch (x) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		}

		return result;
	}
	public static void menu(int x) {
		int y = x;
		while(y == 1) {
			System.out.print("输入算式，中间用空格分隔：");
			Scanner scan = new Scanner(System.in);
			double a, b;
			int m;
			a = scan.nextDouble();
			m = scan.next().charAt(0);
			b = scan.nextDouble();
			
			System.out.println("计算结果是：" + Homework.cslc(a, m, b));
			
			System.out.print("输入1开始计算，输入其他数字退出：");
			y = scan.nextInt();
			
	}
}
}
```

## 问题总结

1. 不熟悉Java基础语法，导致不会用输入语句