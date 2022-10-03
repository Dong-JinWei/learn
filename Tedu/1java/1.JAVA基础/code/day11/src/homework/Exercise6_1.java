/**
 * 
 */
package homework;

/**
 * @author 26465
 *
 */

import java.util.Scanner;

public class Exercise6_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入第一个正整数：");
		int m = in.nextInt();
		System.out.println("请输入第二个正整数：");
		int n = in.nextInt();
		int mul = m * n; //存放两个数的乘积
		
		int max = (m > n) ? m : n;//最小公倍数肯定比两个数中的大数还要大，所以将大数放到max里。

//		for (int i = max; i < m * n; i++) {// 从max开始，最小公倍数不可能大于两数的乘积。
//			if (i % m == 0 && i % n == 0) {// 循环判断，这个数可以被两个数整除，那么这个数就是两个数的最小公倍数。
//				System.out.println("最小公倍数是：" + i);
//				break;
//			}
//		}

		int c;

		while (m % n != 0) {//辗转相除法
			c = m % n;
			m = n;
			n = c;
		}
		System.out.println("最大公约数是：" + n);
		
		//最小公倍数是 两数的乘积/最大公约数
		
		System.out.println("最小公倍数是" + (mul / n));


	}

}
