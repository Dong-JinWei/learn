
/*
 * 
 * �ж�һ�����ǲ���������
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
//				System.out.println(num + "��������");
////				flag = false;
//				break;
//			}
//		}
//		if (i == num) {
//			System.out.println(num + "������");
//		}
////		if (flag) {
////			System.out.println("������");
////		}

		int i, n, sqrt;
		n = 19;
//		boolean flag = true;
		sqrt = (int) Math.sqrt(n);
		for (i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				System.out.println("��������");
//				flag = false;
				break;
			}
		}
//		if (flag) {
//			System.out.println("������");
//		}
		if (i > sqrt) {
			System.out.println("������");
		}
	}

}
