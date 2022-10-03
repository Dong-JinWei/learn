
public class LoopTest3 {
	public static void main(String[] args) {
		out1:
			for (int i = 1; i < 10; i++) {
			System.out.println("第一次循环");
			for (int j = 1; j < 10; j++) {
				System.out.println("第二次循环");
				if (j == 4) {
					break out1;
				}
			}
		}
		System.out.println("结束循环");

		System.out.println();

		// 跳出本层循环
		for (int i = 1; i <= 3; i++) {
			System.out.println("第1次循环 " + i);
			for (int j = 1; j <= 10; j++) {
				System.out.println("第2次循环 " + j);
				if (j == 2) {
					break;
				}
			}
		}
		System.out.println("结束循环");

		System.out.println();

		// 跳出本层循环
		for (int i = 1; i <= 3; i++) {
			System.out.println("第1次循环 " + i);
			for (int j = 1; j <= 5; j++) {
				System.out.println("第2次循环 " + j);
			}
			if (i == 2) {
				break;
			}
		}
		System.out.println("结束循环");

	}

}
