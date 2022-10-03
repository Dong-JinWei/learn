package com.dowei.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
//		int[] next = kmpNext("ABCDABD");
//		System.out.println(Arrays.toString(next));
		String str2 = "ABCDABCD";
		int[] kmpNext = kmpNext(str2);
		System.out.println(Arrays.toString(kmpNext));
		int index = kmpSearch(str1, str2, kmpNext);
		
		System.out.println(index);
		
	}

	/**
	 * 
	 * @param str1 ԭ��
	 * @param str2 �Ӵ�
	 * @param next ƥ���
	 * @return -1ûƥ�䵽�����򷵻ص�һ��ƥ�䵽���±�
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		for (int i = 0, j = 0; i < str1.length(); i++) {
			
			while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j - 1];
			}
			
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
		
	}

	
	//��ƥ���
	public static int[] kmpNext(String dest) {
		int[] next = new int[dest.length()];
		next[0] = 0;
		for(int i = 1, j = 0; i < dest.length(); i++) {
			
			while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}
			
			if(dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
