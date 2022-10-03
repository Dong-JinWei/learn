package day19;

public class 全局变量与局部变量 {
	int a;
	
	void f() {
		a = 100;
		while(true) {
			int i = 0;
			while(true) {
				System.out.println(i);
			}
		}
	}
	
	
}
