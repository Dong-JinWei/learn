/*
 * ��������
 */

package homeworkArrays;

public class Exercise7_5 {
	public static void main(String[] args) {
		int[] arr = new int[] { 8, 6, 5, 4, 1 };

		System.out.println("ԭ����Ϊ��");
		printArrays(arr);

		turnArrays(arr);
		
		System.out.println("������Ϊ��");
		printArrays(arr);
		
	}

	static void turnArrays(int[] arr) {
		for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
	}

	static void printArrays(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
