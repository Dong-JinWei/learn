package homework;

import java.util.Scanner;

public class Exercise6_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("������������ֵ�λ����");
		int n = in.nextInt();
		int a = 0;
		int sum = 0;

		// ÿ��һλ����ѭ��һ��
		for (int i = 0; i < n; i++) {
			a = a * 10 + 2; // ��2Ϊ����2 22 222 2222 ���Է��ֹ��� a*10+2
			System.out.print(a + " ");
			sum = sum + a; // �����еĽ��������
		}
		System.out.println("\n" + sum);
	}

}
