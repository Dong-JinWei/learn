package homeworkMethods;

import java.util.Scanner;

public class Exercise8_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("�������ַ�����");
		String str = in.next();
		System.out.println("ԭ�ַ���Ϊ��" + str);
		
		str = reverse(str);
		System.out.println("��ת����ַ���Ϊ��" + str);

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
