# 第一题
```java

/**
 * 
 * 5.4 有3个整数a、b、c,由键盘输入,输出其中最大的数。

 * @author 26465
 *
 */

import java.util.Scanner;

public class Homework5_4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入第一个数：");
		int num1 = in.nextInt();

		System.out.println("请输入第二个数：");
		int num2 = in.nextInt();

		System.out.println("请输入第三个数：");
		int num3 = in.nextInt();

		if (num1 >= num2 && num1 >= num3) {
			System.out.println("最大的数是：" + num1);
		} else if (num2 >= num1 && num2 >= num3) {
			System.out.println("最大的数是：" + num2);
		} else if (num3 >= num1 && num3 >= num2){
			System.out.println("最大的数是：" + num3);
		}
		
	}

}

```

运行结果：

![](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211216212853931.png)

# 第二题

![image-20211216213544949](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211216213544949.png)

```java
/**
 * 计算函数
 */
public class Homework5_5 {
	public static void main(String[] args) {
		int x = 11;
		int y;

		if (x < 1) {
			y = x;
			System.out.println("当x =" + x + " 时，y = " + y);
		} else if (x >= 1 && x < 10) {
			y = 2 * x - 1;
			System.out.println("当x =" + x + " 时，y = " + y);
		}else {
			y = 3 * x - 11;
			System.out.println("当x =" + x + " 时，y = " + y);
		}
	}
}

```

运行结果；

![image-20211216213606909](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211216213606909.png)

# 第三题

![image-20211216213627943](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211216213627943.png)

```java
/**
 * 5.6给出-百分制成绩,要求输出成绩等级'A'、'B、'C'、'D'、'E'。90分以上为'A'，80～89分为'B',70～79分为'C',60～69分为'D',60分以下为'E'。
 * 
 * 
 * @author 26465
 *
 */
public class Homework5_6 {
	public static void main(String[] args) {
		int score = 80;

		if (score >= 90) {
			System.out.println('A');
		} else if (score >= 80 && score < 90) {
			System.out.println('B');
		} else if (score >= 70 && score < 80) {
			System.out.println('C');
		} else if (score >= 60 && score < 70) {
			System.out.println('D');
		} else
			System.out.println('E');
	}

}
```

运行结果：

![image-20211216214150422](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211216214150422.png)

# 第四题

![image-20211216222146067](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211216222146067.png)

```java

/**
 * 5.7给一个不多于5位的正整数,要求: 求出它是几位数﹔ 分别输出每一位数字; .按逆序输出各位数字,例如原数为321,应输出123。
 * 
 * @author 26465
 *
 */
import java.util.Scanner;

public class Homework5_7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入一个小于五位的数字；");
		int num = in.nextInt();
		int w;
		int q;
		int b;
		int s;
		int g;

		if (num / 100000 > 0) {
			System.out.println("输入无效，请输入一个不多于五位的整数数。");
			return;
		}

		int flag = 0; // 表示这是数字是几位数。

		if (num > 10000) { // 大于10000是5位数。下边以此类推
			flag = 5;
		} else if (num > 1000) {
			flag = 4;
		} else if (num > 100) {
			flag = 3;
		} else if (num > 10) {
			flag = 2;
		} else if (num > 1) {
			flag = 1;
		}
		System.out.println("是一个" + flag + "位数");

		w = num / 10000; // 提取万位的数字
		q = num / 1000 % 10; // 提取千位的数字
		b = num / 100 % 10; // 提取百位的数字
		s = num / 10 % 10; // 提取10位的数字
		g = num % 10; // 提取个位的数字

		switch (flag) {
		case 5:
			System.out.println("万位数是" + w);
		case 4:
			System.out.println("千位数是" + q);
		case 3:
			System.out.println("百位数是" + b);
		case 2:
			System.out.println("十位数是" + s);
		case 1:
			System.out.println("个位数是" + g);
		}

		// 根据位数不同，反向输出。
		String str = "";
		switch (flag) {
		case 5:
			str = str + g + s + b + q + w;
			break;
		case 4:
			str = str + g + s + b + q;
			break;
		case 3:
			str = str + g + s + b;
			break;
		case 2:
			str = str + g + s;
			break;
		case 1:
			str = str + g;
			break;
		}
		System.out.println(str);

	}
}

```

运行结果：

![image-20211217082116893](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211217082116893.png)

# 第五题

![image-20211217085257635](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211217085257635.png)

```java

/**
 * 
 * 5.8企业发放的奖金根据利润提成。利润Ⅰ低于或等于100 000元的,奖金可提10%;利润高于100 000元,低于200 000元(100
 * 000<I≤200 000)时,低于100 000元的部分按10%提成,高于100 000元的部分,可提成7.5%;200 000<I≤400
 * 000时,低于200 000元的部分仍按上述办法提成(下同)。高于200 000元的部分按5%提成;400 000<I≤600 000元时,高于400
 * 000元的部分按3%提成;600 000<I≤1000 000时,高于600 000元的部分按1.5%提成;I>1000 000时,超过100
 * 0000元的部分按1%提成。从键盘输人当月利润Ⅰ,求应发奖金总数。
 * 
 * @author 26465
 *
 */
import java.util.Scanner;

public class Homework5_8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double i; // 利润
		double m = 0;
		System.out.println("请输入你的利润：");
		i = in.nextDouble();

		if (i <= 100000) {
			m = i * 0.1; // 利润提高10%
		} else if (i > 100000 && i <= 200000) {// 100000 < i <= 200000
			m = 100000 * 0.1 + (i - 100000) * 0.075;
		} else if (i > 200000 && i <= 400000) {// 200000 < i <= 400000
			m = 100000 * 0.1 + 100000 * 0.075 + (i - 200000) * 0.05;
		} else if (i > 400000 && i <= 600000) {// 400000 < i <= 600000
			m = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (i - 400000) * 0.03;
		} else if (i > 600000 && i <= 10000000) {// 600000 < i <= 10000000
			m = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (i - 600000) * 0.015;
		} else if (i > 10000000) {
			m = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 400000 * 0.015 + (i - 10000000) * 0.01;
		}

		System.out.println("利润为" + i + "时，应发奖金数为：" + m);
	}

}

```

运行结果：

![image-20211217085320858](https://gitee.com/DongJinWei/picgo-imgs/raw/master/images/image-20211217085320858.png)

