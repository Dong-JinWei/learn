package com.dowei.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

public class MergetSort {
	public static void main(String[] args) {
		int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
		
		//测试快排的执行速度
		// 创建要给80000个的随机的数组
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}
//		System.out.println("排序前");
//		Date data1 = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date1Str = simpleDateFormat.format(data1);
//		System.out.println("排序前的时间是=" + date1Str);
		
		int temp[] = new int[arr.length]; //归并排序需要一个额外空间
 		mergeSort(arr, 0, arr.length - 1, temp);
// 		
// 		Date data2 = new Date();
//		String date2Str = simpleDateFormat.format(data2);
//		System.out.println("排序前的时间是=" + date2Str);
 		
 		System.out.println("归并排序后=" + Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else {
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		
		while (i <= mid) {
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while (j <= right) {
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		
		t = 0;
		int tempLeft = left;;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}
