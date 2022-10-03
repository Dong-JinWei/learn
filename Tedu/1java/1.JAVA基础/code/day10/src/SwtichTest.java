
public class SwtichTest {
	public static void main(String[] args) {

		// 输入月份，判断季节
		int season = 12;

		switch (season) {
			case 3:
			case 4:
			case 5:
				System.out.println("春天");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏天");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋天");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("冬天");
				break;
			default:
				System.out.println("月份有误");

		}

		String name = "root";

		switch (name) {
			case "root":
				System.out.println("你是root");
				break;
			case "user":
				System.out.println("你是user");
				break;
			default:
				System.out.println("你是访客");
		}

	}

}
