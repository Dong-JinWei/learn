/*
 * 十进制转二进制
 */
public class DecimalToBinary {
	public static void main(String[] args) {
		int n = 100;
		String str = "";
		int a;

		//除2取余倒计
		do {
			a = n % 2;
			str = a + str;
			n = n / 2;
		} while (n != 0);
		System.out.println(str);
	}
}
