package homework;

import java.util.Scanner;

public class Exercise6_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入一行字符串：");
		String str = in.nextLine();

		// 统计字符数
		int ziMu = 0; // 字母
		int shuZi = 0;// 数字
		int kongGe = 0;// 空格
		int other = 0;// 其他字符

		for (int i = 0; i < str.length(); i++) {// length()方法可以获取字符串长度
			char ch = str.charAt(i); // 将字符串转换为单个字符，然后对每个字符进行判断
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				ziMu++;
			} else if (ch >= '0' && ch <= '9') {
				shuZi++;
			} else if (ch == ' ') {
				kongGe++;
			} else {
				other++;
			}

		}
		System.out.println("其中字母有" + ziMu + "个，数字有" + shuZi + "个，空格有" + kongGe + "个，其他字符有" + other + "个。");
	}

}
