/**
 * �Ӽ��̸�����Ԫ�ظ�ֵ����ӡ�����ֵ����Сֵ��
 */

package homework;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

		System.out.println("����������ĳ��ȣ�");
		int n = in.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("�������" + (i + 1) + "��ֵ");
			arr[i] = in.nextInt();
			
		}
		
		int max, min;
		max = arr[0];
		min = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}
			if (arr[i] <= min) {
				min = arr[i];
			}
		}

		System.out.println("���ֵΪ��" + max + "����СֵΪ��" + min);
	}

}
