package homeworkMethods;

import java.util.Scanner;

public class Exercise8_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入字符串：");
		String str = in.next();
		System.out.println("原字符串为：" + str);
		
		str = reverse(str);
		System.out.println("反转后的字符串为：" + str);

	}

	static String reverse(String str) {

		char[] chars = str.toCharArray();

		String temp = "";

		for (int i = chars.length - 1; i >= 0; i--) {
			temp += chars[i];
		}
		return temp;
	}
}
