/**
 * 
 */
package homework;

/**
 * @author 26465
 *
 */

import java.util.Scanner;

public class Exercise6_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("�������һ����������");
		int m = in.nextInt();
		System.out.println("������ڶ�����������");
		int n = in.nextInt();
		int mul = m * n; //����������ĳ˻�
		
		int max = (m > n) ? m : n;//��С�������϶����������еĴ�����Ҫ�����Խ������ŵ�max�

//		for (int i = max; i < m * n; i++) {// ��max��ʼ����С�����������ܴ��������ĳ˻���
//			if (i % m == 0 && i % n == 0) {// ѭ���жϣ���������Ա���������������ô�������������������С��������
//				System.out.println("��С�������ǣ�" + i);
//				break;
//			}
//		}

		int c;

		while (m % n != 0) {//շת�����
			c = m % n;
			m = n;
			n = c;
		}
		System.out.println("���Լ���ǣ�" + n);
		
		//��С�������� �����ĳ˻�/���Լ��
		
		System.out.println("��С��������" + (mul / n));


	}

}
