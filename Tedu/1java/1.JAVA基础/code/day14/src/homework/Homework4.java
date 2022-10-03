/**
 * 指定开始月份和结束月份，打印这两个月之间的天数。
 */

package homework;

import java.util.Scanner;

public class Homework4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //初始化数组，将12个月，每个月的天数放入数组。
		
		
		
		System.out.println("请输入起始的月份：");
		int start = in.nextInt();
		if (start > 12 || start < 0) {
			System.out.println("输入不合法。");
			return;
		}
		
		System.out.println("请输入结束的月份：");
		int end = in.nextInt();
		if (end > 12 || end < 0) {
			System.out.println("输入不合法。");
			return;
		}

		int sumDays = 0;
		for(int i = start - 1; i <= end - 1; i++) {
			sumDays = sumDays + days[i];
		}
		
		System.out.println("从 "+start+" 月到 "+end+ "月，期间共有 "+sumDays+" 天");
		
		
	}

}
