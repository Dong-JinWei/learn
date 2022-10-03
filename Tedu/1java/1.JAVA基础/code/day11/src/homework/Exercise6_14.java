package homework;

public class Exercise6_14 {
	public static void main(String[] args) {
		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int m = 1; m <= 2 * i - 1; m++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j <= i; j++) {
				System.out.print("  ");
			}
			
			for (int j = 0; j < n + (n - 3) - i * 2; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		

	}

}
