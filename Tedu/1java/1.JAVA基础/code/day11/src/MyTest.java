public class MyTest {
	public static void main(String[] args) {
		int i, j;

		System.out.println("ÔÄ¶ÁÌâ1==========");
		i = 0;
		j = 0;
		for (i = 0, j = 0; ++i < 4; j++, i++) {
			System.out.println(i + " " + j);
		}
		//1 0
		//3 1	

		System.out.println("ÔÄ¶ÁÌâ2============");
		i = 012;
		do {
			System.out.println(i--);
		} while (--i > 0);
		//10
		//8
		//6
		//4
		//2

		System.out.println("ÔÄ¶ÁÌâ3================");
		for (i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				i++;
				break;
			case 1:
				System.out.println("aaa");
			case 2:
				i++;
				continue;
			case 3:
				System.out.println("bbb");
			}
			System.out.println("ccc");
		}
		System.out.println(i);
		//ccc
		//ccc
		//5
	}
}
