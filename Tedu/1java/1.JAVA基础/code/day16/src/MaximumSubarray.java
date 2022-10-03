/*
 * ���������
 */
public class MaximumSubarray {
	public static void main(String[] args) {
		int[] arr = { 620, -2, 3, -4, -5, -6, -7, -8, -9, -9, -10 };

		int maxBegin = 0, maxEnd = 0, max = arr[0];

		int begin, end, value;
		int i;

		for (i = 0, begin = 0, value = 0; i < arr.length; i++) {
			end = i;
			value = value + arr[i];

			if (value > max) {
				maxBegin = begin;
				maxEnd = end;
				max = value;
			}

			if (value < 0) {
				begin = i + 1;
				value = 0;
			}
		}
		System.out.println("���������ʼ�±���" + maxBegin + "��������Ľ����±���" + maxEnd);
		System.out.println("���������ĺ��ǣ�" + max);

	}

}
