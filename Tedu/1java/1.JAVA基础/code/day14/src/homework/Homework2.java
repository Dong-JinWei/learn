/*
 * 
 * �Զ������飬������Ԫ�ؽ��г�ʼ������ӡ���ڶ����ֵ��
 */

package homework;

public class Homework2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 6, 9, 0, -1, 8 };
		int max1 = arr[0]; // ��ŵ�һ���ֵ
		int max2 = arr[0]; // ��ŵڶ����ֵ

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max2) {
				max2 = arr[i]; // ���������ȵڶ����������ô�Ͱ������浽max2��
			}
			if (max2 > max1) { // ����ڶ�������ȵ�һ�����������ô�ͽ���λ��
				int temp = max1;
				max1 = max2;
				max2 = temp;
			}
		}

		System.out.println("�ڶ����ֵ�ǣ�" + max2);
	}

}
