/*
 * 二分查找
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int findNum = 0;
		int left = 0;
		int right = arr.length - 1;
		int mid;
		boolean flag = false;

		do {
			mid = (left + right) / 2;

			if (findNum == arr[mid]) {
				flag = true;
				break;
			} else if (findNum > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		} while (left <= right);

		System.out.println("你要找的数是" + findNum);
		if (flag) {
			System.out.println("他的下标是" + mid);
		} else {
			System.out.println("没找到");
		}

	}

}
