package com.dong.day5;

import java.util.Scanner;

public class demo1 {
	public static void main(String[] arges) {
		
		//创建一个扫描器对象，用于接收键盘数据
		Scanner scan = new Scanner(System.in);
		
		System.out.println("使用next方法接收: ");
		
		if (scan.hasNext()) {
			String str = scan.next();
			System.out.println("输出内容为: " + str);
		}
		
		//凡是属于IO流的类如果不关闭，会一直占用资源。要养成好习惯，用完就关掉。
		scan.close();
	}
}
