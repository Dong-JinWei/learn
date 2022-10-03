package homework;

import java.util.Scanner;

public class Exercise6_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入这个数字的位数：");
		int n = in.nextInt();
		int a = 0;
		int sum = 0;

		// 每有一位，就循环一次
		for (int i = 0; i < n; i++) {
			a = a * 10 + 2; // 以2为例，2 22 222 2222 可以发现规律 a*10+2
			System.out.print(a + " ");
			sum = sum + a; // 将所有的结果加起来
		}
		System.out.println("\n" + sum);
	}

}
