
public class LoopTest3 {
	public static void main(String[] args) {
		out1:
			for (int i = 1; i < 10; i++) {
			System.out.println("��һ��ѭ��");
			for (int j = 1; j < 10; j++) {
				System.out.println("�ڶ���ѭ��");
				if (j == 4) {
					break out1;
				}
			}
		}
		System.out.println("����ѭ��");

		System.out.println();

		// ��������ѭ��
		for (int i = 1; i <= 3; i++) {
			System.out.println("��1��ѭ�� " + i);
			for (int j = 1; j <= 10; j++) {
				System.out.println("��2��ѭ�� " + j);
				if (j == 2) {
					break;
				}
			}
		}
		System.out.println("����ѭ��");

		System.out.println();

		// ��������ѭ��
		for (int i = 1; i <= 3; i++) {
			System.out.println("��1��ѭ�� " + i);
			for (int j = 1; j <= 5; j++) {
				System.out.println("��2��ѭ�� " + j);
			}
			if (i == 2) {
				break;
			}
		}
		System.out.println("����ѭ��");

	}

}
