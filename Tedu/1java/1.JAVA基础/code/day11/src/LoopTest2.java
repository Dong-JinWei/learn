
public class LoopTest2 {
	public static void main(String[] args) {
		
		//��ӡ�˷���
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//��ӡֱ��������
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

		//��ӡ����������
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j ++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

		//��ӡ����������2
		for(int i = 1; i <= 9; i++) {
			for(int m = 1; m <= 9-i; m++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
