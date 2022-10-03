
public class LoopTest2 {
	public static void main(String[] args) {
		
		//打印乘法表
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//打印直角三角形
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

		//打印等腰三角形
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

		//打印等腰三角型2
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
