package homeworkArrays;

public class Exercise7_8 {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 3, 2 }, { 1, 5, 2 }, { 1, 6, 2 } };

		printArrays(arr);
		saddlePoint(arr);
	}

	//���ҳ�ÿһ���������֣�Ȼ����������ǲ���������Ӧ�е���С��һ�����顣
	static void saddlePoint(int[][] arr) {
		
		int minIndex = 0;
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			maxIndex = 0;
			minIndex = 0;

			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > arr[i][maxIndex]) {
					maxIndex = j;// ѭ������ÿһ�У��ҳ���һ�е����ֵ
					for (int k = 0; k < arr.length; k++) {
						// �������ֵ����һ�У��ж����ǲ�ʱ��С��
						if (arr[i][maxIndex] > arr[k][maxIndex]) {
							// ����һ�еĵ��κ�һ�����ִ󣬾�break
							break;
						} else {
							// ��������������
							minIndex = i;
							System.out.println("(" + minIndex + ", " + maxIndex + ")");
							break;
						}
					}
				}
			}

		}
	}
	static void printArrays(int[][] arr) {
		for (int[] n : arr) {
			for (int m : n) {
				System.out.print(m + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
