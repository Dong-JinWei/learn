/*
 * ����Խ��ߵĺ�
 */

package homeworkArrays;

public class Exercise7_3 {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 3, 2 } };
		
		System.out.println("�ҶԽ��ߵĺ�Ϊ��" + diagonalRight(arr));
		System.out.println("���Խ��ߵĺ�Ϊ��" + diagonalLeft(arr));
	}

	static int diagonalRight(int[][] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];// �Խ��ߣ�0��0������1��1������2��2��
		}
		return sum;
	}

	static int diagonalLeft(int[][] arr) {
		int sum = 0;
		for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
			sum += arr[i][j];// �Խ��ߣ�0��2������1��1������2��1��
		}
		return sum;
	}
}
