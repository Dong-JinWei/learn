/**
 * ָ����ʼ�·ݺͽ����·ݣ���ӡ��������֮���������
 */

package homework;

import java.util.Scanner;

public class Homework4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //��ʼ�����飬��12���£�ÿ���µ������������顣
		
		
		
		System.out.println("��������ʼ���·ݣ�");
		int start = in.nextInt();
		if (start > 12 || start < 0) {
			System.out.println("���벻�Ϸ���");
			return;
		}
		
		System.out.println("������������·ݣ�");
		int end = in.nextInt();
		if (end > 12 || end < 0) {
			System.out.println("���벻�Ϸ���");
			return;
		}

		int sumDays = 0;
		for(int i = start - 1; i <= end - 1; i++) {
			sumDays = sumDays + days[i];
		}
		
		System.out.println("�� "+start+" �µ� "+end+ "�£��ڼ乲�� "+sumDays+" ��");
		
		
	}

}
