/*
 * 1Ԫ�һ�5�֡�2�֡�1�ֵķ�����
 */
public class ChangeOn {
	public static void main(String[] args) {
		int five, two, one;
		int count = 0;

		for (five = 0; five <= 20; five++) {
			for (two = 0; two <= 50; two++) {
				for (one = 0; one <= 100; one++) {
					if (five * 5 + two * 2 + one == 100) {
						System.out.println("5��" + five + "����" + "2��" + two + "����" + "1��" + one + "����");
						count++;
					}
				}
			}
		}
		System.out.println("������" + count + "�һ���ʽ");
	}

}
