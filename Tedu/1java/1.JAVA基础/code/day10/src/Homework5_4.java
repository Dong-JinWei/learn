
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
