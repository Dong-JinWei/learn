package com.dowei.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
	public static void main(String[] args) {
		int arr[] = { 53, 3, 542, 748, 14, 214 };

		// 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		radixSort(arr);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);

		System.out.println("基数排序后 " + Arrays.toString(arr));
	}

	public static void radixSort(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();

		int[][] bucket = new int[10][arr.length];
		int[] bucketElementCounts = new int[10];

		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}

			int index = 0;

			for (int k = 0; k < bucketElementCounts.length; k++) {
				if (bucketElementCounts[k] != 0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				bucketElementCounts[k] = 0;
			}
		}
	}

}
