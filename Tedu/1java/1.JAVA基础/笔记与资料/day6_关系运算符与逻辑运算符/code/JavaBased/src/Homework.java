
public class Homework {
	public static void main(String[] args) {
		int a, b, c;

		a = 10;
		b = 11;
		c = 11;

		System.out.printf("当三边分别为：%d, %d, %d\n", a, b, c);

		if (a > 0 && b > 0 && c > 0) {
			if (a + b > c && a + c > b && b + c > a) {
				System.out.println("是三角形");
				if (a == b || a == c || b == c) {
					System.out.println("也是等腰三角形");
				} else {
					System.out.println("不是等腰三角形");
				}
			} else {
				System.out.println("不是三角形");
			}
		}

	}

}
