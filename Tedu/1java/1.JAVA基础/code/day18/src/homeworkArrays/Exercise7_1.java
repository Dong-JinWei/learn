package homeworkArrays;

public class Exercise7_1 {
	public static void main(String[] args) {

		// ���100���ڵ�����
		primeNumbers();
	}

	static void primeNumbers() {
		// java���鶨���Ĭ��ֵΪ0����ô�Ͱ�0 ����Ϊ������1��������
		int[] array = new int[100];
		// 0,1 ��������
		array[0] = 1;
		array[1] = 1;
		for (int i = 0; i < Math.sqrt(200); i++) {
			if (array[i] == 0) {
				for (int j = i * i; j < 100; j += i) {
					array[j] = 1;
				}
			}
		}
		for (int x = 0; x < 100; x++) {
			if (array[x] == 0) {
				System.out.println(x);
			}
		}
	}

}
