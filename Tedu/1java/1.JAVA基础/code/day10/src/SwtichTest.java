
public class SwtichTest {
	public static void main(String[] args) {

		// �����·ݣ��жϼ���
		int season = 12;

		switch (season) {
			case 3:
			case 4:
			case 5:
				System.out.println("����");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("����");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("����");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("����");
				break;
			default:
				System.out.println("�·�����");

		}

		String name = "root";

		switch (name) {
			case "root":
				System.out.println("����root");
				break;
			case "user":
				System.out.println("����user");
				break;
			default:
				System.out.println("���Ƿÿ�");
		}

	}

}
