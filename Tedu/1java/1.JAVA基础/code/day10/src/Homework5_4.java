
/**
 * 
 * 5.4 ��3������a��b��c,�ɼ�������,���������������

 * @author 26465
 *
 */

import java.util.Scanner;

public class Homework5_4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("�������һ������");
		int num1 = in.nextInt();

		System.out.println("������ڶ�������");
		int num2 = in.nextInt();

		System.out.println("���������������");
		int num3 = in.nextInt();

		if (num1 >= num2 && num1 >= num3) {
			System.out.println("�������ǣ�" + num1);
		} else if (num2 >= num1 && num2 >= num3) {
			System.out.println("�������ǣ�" + num2);
		} else if (num3 >= num1 && num3 >= num2){
			System.out.println("�������ǣ�" + num3);
		}
		
	}

}
