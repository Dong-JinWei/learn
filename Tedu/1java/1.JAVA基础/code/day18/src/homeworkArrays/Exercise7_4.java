/*
 * ��������
 * 
 */
package homeworkArrays;

public class Exercise7_4 {

	public static void main(String[] args) {
		int max = 10;
		int[] arr = new int[max];

		int j = creatArrays(arr);//�������飬����ȡ�±�
		System.out.println("ԭʼ�����ǣ�");
		printArrays(arr);
		
		arr[j] = 2;
		System.out.println("����������ǣ�" + arr[j]);
		
		insertArrays(arr, j);
		System.out.println("�������ݺ�������ǣ�");
		printArrays(arr);

	}

	static int creatArrays(int[] arr) {
		int j = 0;
		// ��������
		for (int i = 1; i < arr.length; i += 2) {
			arr[j] = i;
			j++;
		}
		return j;// �������һ����ЧԪ�ص��±�
	}

	static void printArrays(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	static void insertArrays(int[] arr, int j) {
		// ���������ǰһ����С��ʱ�򣬽�����������λ��
		for (int i = j; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				int temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			} else {
				break;
			}
		}
	}

}
