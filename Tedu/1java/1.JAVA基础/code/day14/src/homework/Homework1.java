/**
 * 从键盘给数组元素赋值，打印出最大值和最小值。
 */

package homework;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

		System.out.println("请输入数组的长度：");
		int n = in.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("请输入第" + (i + 1) + "个值");
			arr[i] = in.nextInt();
			
		}
		
		int max, min;
		max = arr[0];
		min = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}
			if (arr[i] <= min) {
				min = arr[i];
			}
		}

		System.out.println("最大值为：" + max + "，最小值为：" + min);
	}

}
