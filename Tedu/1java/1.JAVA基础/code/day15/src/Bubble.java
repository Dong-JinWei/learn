
public class Bubble {
	public static void main(String[] args) {
		int[] arr = { 97, 42, 1, 620, 7, 74, 0, 41, 104, 106, 224 };

		System.out.println("ԭ����Ϊ��");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					/*
					 * ֻ������������������
					 * ���磺a = 6�� b = 3��
					 * a = a+b; a = 6+3 = 9;
					 * b = a-b = 9-3 = 6;
					 * a = a-b = 9-6 = 3;
					 * 
					 * ��� a = 3��b = 6��
					 */
					
					arr[j] = arr[j] + arr[j + 1]; 
					arr[j + 1] = arr[j] - arr[j + 1];
					arr[j] = arr[j] - arr[j + 1];
				}
			}
		}


		System.out.println("��С��������Ϊ��");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] < arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("�Ӵ�С����Ϊ��");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

}
