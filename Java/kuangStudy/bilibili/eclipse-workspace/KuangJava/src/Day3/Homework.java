package Day3;

import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		System.out.print("����1��ʼ���㣬�������������˳���");
		Scanner scan = new Scanner(System.in);
		int m;
		m = scan.nextInt();
		
		Homework.menu(m);
	}

	
	public static double cslc(double a, int x, double b) {
		double result = 0;
		switch (x) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		}

		return result;
	}
	public static void menu(int x) {
		int y = x;
		while(y == 1) {
			System.out.print("������ʽ���м��ÿո�ָ���");
			Scanner scan = new Scanner(System.in);
			double a, b;
			int m;
			a = scan.nextDouble();
			m = scan.next().charAt(0);
			b = scan.nextDouble();
			
			System.out.println("�������ǣ�" + Homework.cslc(a, m, b));
			
			System.out.print("����1��ʼ���㣬�������������˳���");
			y = scan.nextInt();
			
	}
}
}