package com.dowei.saprsearray;

public class SparseArray {
	public static void main(String[] args) {
		/*
		 * ��ά����תϡ�������˼·��
		1. ����ԭʼ�����飬�õ���Ч���ݵĸ���sum
		2. ����sum�Ϳ��Դ���ϡ������`sparseAr int[sum+1][3]`
		3. ����ά�������Ч���ݴ��뵽ϡ��������
		 */
		//1������ԭʼ�Ķ�ά���飬Ĭ��û������=0������=1������=2
		int[][] chessMap1 = new int[11][11];
		chessMap1[1][2] = 1;
		chessMap1[2][3] = 2;
		chessMap1[3][4] = 1;
		
		//2�������ά����
		System.out.println("ԭʼ�Ķ�ά�����ǣ�");
		for(int[] chessRow:chessMap1) {
			for(int chessCol:chessRow) {
				System.out.printf("%d  ",chessCol);
			}
			System.out.println();
		}
		
		//3��ת��ϡ������
		//3.1����ȡ��Ч��Ԫ�ظ���
		int sum = 0;
		for(int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessMap1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("sum="+sum);
		//3.2������ϡ������
		int[][] sparseArray = new int[sum + 1][3];
		//3.3��Ϊϡ�������һ�и�ֵ
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		//3.4������ԭʼ���飬����Ч��ֵ����ϡ������
		int count = 0;
		for(int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessMap1[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessMap1[i][j];
					
				}
			}
		}
		
		//3.5�����ϡ������
		System.out.println("ת�����ϡ�������ǣ�");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
		}
		
		//4����ԭϡ������
		
		/*
		 * 1. ��ȡϡ������ĵ�һ�У��þ��һ������ʱ������ԭʼ����
		 * 2. ��ȡϡ��������е����ݣ�������ԭʼ�Ķ�ά����
		 */
		
		
		//4.1������ԭʼ�Ķ�ά����
		int[][] chessMap2 = new int[sparseArray[0][0]][sparseArray[0][1]];
		
		for(int i = 1; i < sparseArray.length; i++) {
			chessMap2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		//�����ά����
		System.out.println("��ԭ��Ķ�ά�����ǣ�");
		for(int[] chessRow:chessMap2) {
			for(int chessCol:chessRow) {
				System.out.printf("%d  ",chessCol);
			}
			System.out.println();
		}
		
	}

}
