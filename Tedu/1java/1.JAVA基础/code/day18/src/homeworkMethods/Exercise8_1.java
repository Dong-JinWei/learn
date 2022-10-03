/**
 * 函数 最大公约数，最小公倍数
 */
package homeworkMethods;

import java.util.Scanner;
public class Exercise8_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入第一个数：");
		int n = in.nextInt();
		System.out.println("请输入第二个数：");
		int m = in.nextInt();
		
		System.out.println("最小公倍数是：" + lcm(n,m));
		System.out.println("最大公约数：" + gcd(n,m));
		
	}

	// 最小公倍数
	static int lcm(int n, int m) {
		if (n < m) {
			int temp = n;
			n = m;
			m = temp;
		}
		for (int i = n; i < n * m; i++) {
			if (i % n == 0 && i % m == 0) {
				return i;
			}
			
		}
		return n * m;

	}

	// 最大公约数
	static int gcd(int n, int m) {
		int c;
		while (m % n != 0) {//辗转相除法
			c = m % n;
			m = n;
			n = c;
		}
		return n;
	}
}
