package com.dowei.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { 3, 9, 8, 10, 20 };
		boolean flag = false;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			if (!flag) {
				break;
			} else {
				flag = false;
			}
			System.out.println(Arrays.toString(arr));
		}

	}

}
