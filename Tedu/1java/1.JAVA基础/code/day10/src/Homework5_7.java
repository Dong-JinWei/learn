
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
