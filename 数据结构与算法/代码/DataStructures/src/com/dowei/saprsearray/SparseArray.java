package com.dowei.saprsearray;

public class SparseArray {
	public static void main(String[] args) {
		/*
		 * 二维数组转稀疏数组的思路：
		1. 遍历原始的数组，得到有效数据的个数sum
		2. 根据sum就可以创建稀疏数组`sparseAr int[sum+1][3]`
		3. 将二维数组的有效数据存入到稀疏数组中
		 */
		//1、创建原始的二维数组，默认没有棋子=0，黑子=1，白子=2
		int[][] chessMap1 = new int[11][11];
		chessMap1[1][2] = 1;
		chessMap1[2][3] = 2;
		chessMap1[3][4] = 1;
		
		//2、输出二维数组
		System.out.println("原始的二维数组是：");
		for(int[] chessRow:chessMap1) {
			for(int chessCol:chessRow) {
				System.out.printf("%d  ",chessCol);
			}
			System.out.println();
		}
		
		//3、转换稀疏数组
		//3.1、获取有效的元素个数
		int sum = 0;
		for(int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessMap1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("sum="+sum);
		//3.2、创建稀疏数组
		int[][] sparseArray = new int[sum + 1][3];
		//3.3、为稀疏数组第一行赋值
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		//3.4、遍历原始数组，将有效的值插入稀疏数组
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
		
		//3.5、输出稀疏数组
		System.out.println("转换后的稀疏数组是：");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
		}
		
		//4、还原稀疏数组
		
		/*
		 * 1. 读取稀疏数组的第一行，该剧第一行数据时，将建原始数组
		 * 2. 读取稀疏数组后几行的数据，并赋给原始的二维数组
		 */
		
		
		//4.1、创建原始的二维数组
		int[][] chessMap2 = new int[sparseArray[0][0]][sparseArray[0][1]];
		
		for(int i = 1; i < sparseArray.length; i++) {
			chessMap2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		//输出二维数组
		System.out.println("还原后的二维数组是：");
		for(int[] chessRow:chessMap2) {
			for(int chessCol:chessRow) {
				System.out.printf("%d  ",chessCol);
			}
			System.out.println();
		}
		
	}

}
