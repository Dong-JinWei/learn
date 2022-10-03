/*
 * 1元兑换5分、2分、1分的方法。
 */
public class ChangeOn {
	public static void main(String[] args) {
		int five, two, one;
		int count = 0;

		for (five = 0; five <= 20; five++) {
			for (two = 0; two <= 50; two++) {
				for (one = 0; one <= 100; one++) {
					if (five * 5 + two * 2 + one == 100) {
						System.out.println("5分" + five + "个，" + "2分" + two + "个，" + "1分" + one + "个。");
						count++;
					}
				}
			}
		}
		System.out.println("共有种" + count + "兑换方式");
	}

}
