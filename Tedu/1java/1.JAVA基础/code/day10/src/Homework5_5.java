/**
 * ���㺯��
 */
public class Homework5_5 {
	public static void main(String[] args) {
		int x = 5;
		int y;

		if (x < 1) {
			y = x;
			System.out.println("��x =" + x + " ʱ��y = " + y);
		} else if (x >= 1 && x < 10) {
			y = 2 * x - 1;
			System.out.println("��x =" + x + " ʱ��y = " + y);
		}else {
			y = 3 * x - 11;
			System.out.println("��x =" + x + " ʱ��y = " + y);
		}
	}
}
