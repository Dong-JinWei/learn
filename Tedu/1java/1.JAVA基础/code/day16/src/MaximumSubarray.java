/*
 * 最大子数组
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
		System.out.println("子数组的起始下标是" + maxBegin + "，子数组的结束下标是" + maxEnd);
		System.out.println("最大子数组的和是：" + max);

	}

}
