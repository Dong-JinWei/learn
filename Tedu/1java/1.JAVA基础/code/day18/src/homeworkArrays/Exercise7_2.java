/**
 * ѡ�񷨶�ʮ����������
 */
package homeworkArrays;

public class Exercise7_2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 3, 4, 5, 7, 8, 9, 2, 6 };

		System.out.println("����ǰ");
		printArr(arr);
	
		selectionSort(arr);
		System.out.println("�����");
		printArr(arr);
		
		
	}
	static void printArr(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	static void selectionSort(int[] arr) {
		int min = 0;

		for (int i = 0; i < arr.length; i++) {
			min = i;// ����iΪ��Сֵ
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])// �����ǰֵС����Сֵ���ͽ���ǰֵ����Ϊmin��
					min = j;
			}

			if (i != min) {// ���ֵ�������䶯���ͽ�����ֵ��λ�ý���
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}

}
