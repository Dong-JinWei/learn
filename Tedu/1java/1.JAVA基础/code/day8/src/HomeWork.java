
public class HomeWork {
	public static void main(String[] args) {
		// 1、5/4.0 结果为：
		System.out.println("第一题：" + (5 / 4.0));

		// 2、a、b、c 三个变量保存三个边的值，判断是直角三角形：
		int a, b, c;
		a = 3;
		b = 4;
		c = 5;
		System.out.printf("第二题：\n当a = %d, b = %d, c = %d时：", a, b, c);
		if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
			System.out.println("是直角三角形");
		} else {
			System.out.println("不是直角三角形");
		}

		// 3、a=1 b=2，要求输出：”a的值是1”，”b的值是2”，”a+b=3”
		System.out.println("第三题：");
		a = 1;
		b = 2;
		System.out.println("\"a的值是" + a + "\", \"b的值是" + b + "\", a+b=" + (a + b) + "\"");

		// 4、year保存年份，判断是闰年。
		int year = 2000;

		System.out.println("第四题：");
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("是闰年");
		} else {
			System.out.println("不出闰年");
		}

		// 5、& 和 && 的区别？
		/*
		 * 
		 * && 逻辑与 & 按位与,不同：& 可以计算整数和布尔类型，&&只可以计算布尔类型。&
		 * 计算整数时，两边同为1，表达式的结果为1，否则为0。&&存在短路问题，当符号右边为false时，符号左边就不进行计算。 相同：&与&&
		 * 计算布尔类型时，结果是一样的，两边同时为true，表达式的值为true。
		 * 
		 */

		// 6、a=a+b 和 a+=b 的区别？
		/*
		 * 两个表达式计算的结果是一样的。
		 * 但是，当计算的结果是byte，char，short时，a=a+b需自己强制转换为int类型，而a+=b可以自动转换类型。
		 * */

	}

}
