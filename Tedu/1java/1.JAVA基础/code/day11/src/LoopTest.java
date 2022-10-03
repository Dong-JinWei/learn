
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
			System.out.println("请第" + i + "次输入用户名密码：");
			userName = in.next();
			userPwd = in.next();

		} while (i < 3 && !name.equals(userName) && !pwd.equals(userPwd));

		if (i == 3) {
			System.out.println("登录失败");
		} else {
			System.out.println("登录成功");
		}

//		do {
//			boolean j;
//			System.out.println("123");
//			
//		}while(j);//变量定义在内部无法使用
		
		int sum = 0;
		for (i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("100以内，所有偶数的和是：" + sum);
	}

}
