package com.dong.day5;

import java.util.Scanner;

public class demo1 {
	public static void main(String[] arges) {
		
		//����һ��ɨ�����������ڽ��ռ�������
		Scanner scan = new Scanner(System.in);
		
		System.out.println("ʹ��next��������: ");
		
		if (scan.hasNext()) {
			String str = scan.next();
			System.out.println("�������Ϊ: " + str);
		}
		
		//��������IO������������رգ���һֱռ����Դ��Ҫ���ɺ�ϰ�ߣ�����͹ص���
		scan.close();
	}
}
