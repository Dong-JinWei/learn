
public class Homework {
	public static void main(String[] args) {
		int a, b, c;

		a = 10;
		b = 11;
		c = 11;

		System.out.printf("�����߷ֱ�Ϊ��%d, %d, %d\n", a, b, c);

		if (a > 0 && b > 0 && c > 0) {
			if (a + b > c && a + c > b && b + c > a) {
				System.out.println("��������");
				if (a == b || a == c || b == c) {
					System.out.println("Ҳ�ǵ���������");
				} else {
					System.out.println("���ǵ���������");
				}
			} else {
				System.out.println("����������");
			}
		}

	}

}
