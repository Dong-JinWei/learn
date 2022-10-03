package homeworkMethods;

import java.util.Scanner;

public class Exercise8_9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str = in.nextLine();
		
		int[] num = new int[4];
		
		num = countStr(str);
		System.out.println("������ĸ��" + num[0] + "����������" + num[1] + "�����ո���" + num[2] + "���������ַ���" + num[3] + "����");
	}

	static int[] countStr(String str) {
		
		int[] temp =  new int[4];

		// ͳ���ַ���
		int ziMu = 0; // ��ĸ
		int shuZi = 0;// ����
		int kongGe = 0;// �ո�
		int other = 0;// �����ַ�

		for (int i = 0; i < str.length(); i++) {// length()�������Ի�ȡ�ַ�������
			char ch = str.charAt(i); // ���ַ���ת��Ϊ�����ַ���Ȼ���ÿ���ַ������ж�
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
		
		temp[0] = ziMu;
		temp[1] = shuZi;
		temp[2] = kongGe;
		temp[3] = other;
		
		return temp;
	}
}
