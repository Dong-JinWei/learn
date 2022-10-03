/**
 * ���� ���Լ������С������
 */
package homeworkMethods;

import java.util.Scanner;
public class Exercise8_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("�������һ������");
		int n = in.nextInt();
		System.out.println("������ڶ�������");
		int m = in.nextInt();
		
		System.out.println("��С�������ǣ�" + lcm(n,m));
		System.out.println("���Լ����" + gcd(n,m));
		
	}

	// ��С������
	static int lcm(int n, int m) {
		if (n < m) {
			int temp = n;
			n = m;
			m = temp;
		}
		for (int i = n; i < n * m; i++) {
			if (i % n == 0 && i % m == 0) {
				return i;
			}
			
		}
		return n * m;

	}

	// ���Լ��
	static int gcd(int n, int m) {
		int c;
		while (m % n != 0) {//շת�����
			c = m % n;
			m = n;
			n = c;
		}
		return n;
	}
}
