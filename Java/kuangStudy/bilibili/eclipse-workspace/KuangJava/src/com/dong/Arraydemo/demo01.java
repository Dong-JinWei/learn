package com.dong.Arraydemo;

public class demo01 {
	public static void main(String[] atgs) {
		int[][] array1 = new int [11][11];
		array1[1][2] = 1;
		array1[2][3] = 2;
		//���ԭʼ����
		System.out.println("���ԭʼ���飺");
		
		for (int[] ints : array1) {
			for(int anInt : ints) {
				System.out.print(anInt+"\t");
			}
			System.out.println();
		}
		
		//רΪϡ�����鱣��
		
		System.out.println("===================");
		//1.��ȡ��Чֵ�ĸ���
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (array1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("��Чֵ�ĸ�����" + sum);
		
		
		//2.����һ��ϡ�����������
		int[][] array2 = new int [sum+1][3];
		
		array2[0][0] = 11;
		array2[0][1] = 11;
		array2[0][2] = sum;
	
	int count = 0;
	for (int i = 0; i < array1.length; i++) {
		for (int j = 0; j < array1[i].length; j++) {
			if (array1[i][j] != 0) {
				count++;
				array2[count][0] = i;
				array2[count][1] = j;
				array2[count][2] = array1[i][j];
			}
		}
	}
	//���ϡ������
	System.out.println("ϡ�����飺");
	
	for (int i = 0; i < array2.length; i++) {
		System.out.println(array2[i][0] + "\t"
				+ array2[i][1] + "\t"
				+ array2[i][2] + "\t");
	}
	System.out.println("===================");
	
	//ϡ�����黹ԭ
	//1.��ȡϡ������
	int[][] array3 = new int[array2[0][0]][array2[0][1]];
	
	//2.�����е�Ԫ�ػ�ԭ����ֵ
	for (int i = 1; i < array2.length; i++) {
		array3[array2[i][0]][array2[i][1]] = array2[i][2];
	}
	
	//3.��ӡ
	System.out.println("�����ԭ���飺");
	
	for (int[] ints : array3) {
		for(int anInt : ints) {
			System.out.print(anInt+"\t");
		}
		System.out.println();
	}
	
	
  }

}
