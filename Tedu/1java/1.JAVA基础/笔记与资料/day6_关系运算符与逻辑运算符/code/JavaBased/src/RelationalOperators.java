
public class RelationalOperators {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println("a = 1; b = 2; \na > b：" + (a > b));
		System.out.println("a < b：" + (a < b));
		System.out.println("a == b：" + (a == b));
		System.out.println("a != b：" + (a != b));
		System.out.println();

		float f1 = 12.2f;
		float f2 = 12.1f;
		float f3 = f1 - f2;

		System.out.println("f1 = " + f1 + "; f2 = " + f2);
		System.out.println("f3 == 0.1: " + (f3 == 0.1));
		System.out.println();

		int a1 = 1;
		int b1 = 2;

		System.out.println("(a1 = 3) == 4 && (b1 = 4) == 4: " + ((a1 = 3) == 4 && (b1 = 4) == 4));
		System.out.println("a1 = " + a1 + "; b1 = " + b1);
		System.out.println();

		int year = 2000;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year + "年是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
		System.out.println();

		int num = -2;

		if (num < -5 || num > 5) {
			System.out.println(num + "的绝对值大于 " + 5);
		} else {
			System.out.println(num + "的绝对值小于 " + 5);
		}
		System.out.println();

		int h1, h2, h3;
		h1 = 1;
		h2 = 1;
		h3 = 1;

		if (h1 == h2 && h2 == h3 && h3 == h1 && h1 > 0) {
			System.out.println("是等边三角形");
		} else {
			System.out.println("不是等边三角形");
		}
		System.out.println();

		int a, b, c;
		a = 1;
		b = 1;
		c = 3;

		System.out.println((a == b) || (c = 4) == 4);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}

}
