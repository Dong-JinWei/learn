
import java.util.Scanner;

public class LoopTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = 18;
		int b = 20;
		int c;

		while (a % b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		System.out.println(b);

		String name = "root";
		String pwd = "root";
		int i = 0;

		String userName, userPwd;

		do {
			i++;
			System.out.println("���" + i + "�������û������룺");
			userName = in.next();
			userPwd = in.next();

		} while (i < 3 && !name.equals(userName) && !pwd.equals(userPwd));

		if (i == 3) {
			System.out.println("��¼ʧ��");
		} else {
			System.out.println("��¼�ɹ�");
		}

//		do {
//			boolean j;
//			System.out.println("123");
//			
//		}while(j);//�����������ڲ��޷�ʹ��
		
		int sum = 0;
		for (i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("100���ڣ�����ż���ĺ��ǣ�" + sum);
	}

}
