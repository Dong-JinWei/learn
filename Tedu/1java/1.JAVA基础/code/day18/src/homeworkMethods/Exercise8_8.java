package homeworkMethods;

import java.util.Scanner;

public class Exercise8_8 {
	public static void main(String[] args) {
		input();
	}
	
	static void input() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入四位数：");
		int num = in.nextInt();
		
		int q,b,s,g;
		q = num / 1000;
		b = num / 100 % 10;
		s = num / 10 % 10;
		g = num % 10;
		
		System.out.println(q + " " + b + " " + s + " " + g);
	}

}
