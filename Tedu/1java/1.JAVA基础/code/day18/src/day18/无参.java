package day18;

public class 无参 {
	public static void main(String[] args) {
		pritMulTable();
		System.out.println();

		printTriangle();
		System.out.println();

		printTriangles(6, 'D');
		System.out.println();

		System.out.println(factor(5));
		System.out.println();
		
		System.out.println(primeNumber(6));

	}

	static void pritMulTable() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
	}

	static void printTriangle() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void printTriangles(int line, char charctor) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(charctor + " ");
			}
			System.out.println();
		}
	}

	static int factor(int num) {
		int total = 1;
		for (int i = 2; i <= num; i++) {
			total = total * i;

		}
		return total;
	}

	//判断一个数是否是素数，是质数，返回true，否则返回false。
	static boolean primeNumber(int num) {
		int sqrt = (int) Math.sqrt(num);

		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;

	}
}
