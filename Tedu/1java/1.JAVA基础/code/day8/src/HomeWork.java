
public class HomeWork {
	public static void main(String[] args) {
		// 1��5/4.0 ���Ϊ��
		System.out.println("��һ�⣺" + (5 / 4.0));

		// 2��a��b��c �����������������ߵ�ֵ���ж���ֱ�������Σ�
		int a, b, c;
		a = 3;
		b = 4;
		c = 5;
		System.out.printf("�ڶ��⣺\n��a = %d, b = %d, c = %dʱ��", a, b, c);
		if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
			System.out.println("��ֱ��������");
		} else {
			System.out.println("����ֱ��������");
		}

		// 3��a=1 b=2��Ҫ���������a��ֵ��1������b��ֵ��2������a+b=3��
		System.out.println("�����⣺");
		a = 1;
		b = 2;
		System.out.println("\"a��ֵ��" + a + "\", \"b��ֵ��" + b + "\", a+b=" + (a + b) + "\"");

		// 4��year������ݣ��ж������ꡣ
		int year = 2000;

		System.out.println("�����⣺");
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("������");
		} else {
			System.out.println("��������");
		}

		// 5��& �� && ������
		/*
		 * 
		 * && �߼��� & ��λ��,��ͬ��& ���Լ��������Ͳ������ͣ�&&ֻ���Լ��㲼�����͡�&
		 * ��������ʱ������ͬΪ1�����ʽ�Ľ��Ϊ1������Ϊ0��&&���ڶ�·���⣬�������ұ�Ϊfalseʱ��������߾Ͳ����м��㡣 ��ͬ��&��&&
		 * ���㲼������ʱ�������һ���ģ�����ͬʱΪtrue�����ʽ��ֵΪtrue��
		 * 
		 */

		// 6��a=a+b �� a+=b ������
		/*
		 * �������ʽ����Ľ����һ���ġ�
		 * ���ǣ�������Ľ����byte��char��shortʱ��a=a+b���Լ�ǿ��ת��Ϊint���ͣ���a+=b�����Զ�ת�����͡�
		 * */

	}

}
