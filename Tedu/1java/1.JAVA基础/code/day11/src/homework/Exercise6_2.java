package homework;

import java.util.Scanner;

public class Exercise6_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("������һ���ַ�����");
		String str = in.nextLine();

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
		System.out.println("������ĸ��" + ziMu + "����������" + shuZi + "�����ո���" + kongGe + "���������ַ���" + other + "����");
	}

}
