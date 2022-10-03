
/*
 * 
 * 判断一个数是不是质数。
 */
import java.lang.Math;

public class PrimeNumber {
	public static void main(String[] args) {
//		int i, num;
//		
//		num  = 4;
////		boolean flag = true;
//		
//		for (i = 2; i < num; i++) {
//			if(num % i == 0) {
//				System.out.println(num + "不是素数");
////				flag = false;
//				break;
//			}
//		}
//		if (i == num) {
//			System.out.println(num + "是素数");
//		}
////		if (flag) {
////			System.out.println("是素数");
////		}

		int i, n, sqrt;
		n = 19;
//		boolean flag = true;
		sqrt = (int) Math.sqrt(n);
		for (i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				System.out.println("不是素数");
//				flag = false;
				break;
			}
		}
//		if (flag) {
//			System.out.println("是素数");
//		}
		if (i > sqrt) {
			System.out.println("是素数");
		}
	}

}
