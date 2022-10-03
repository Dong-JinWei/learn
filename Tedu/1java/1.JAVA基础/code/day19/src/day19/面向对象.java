package day19;

public class 面向对象 {
	public static void main(String[] args) {
		Clock clock1 = new Clock();
		
		clock1.createTime(19, 20, 49);
		clock1.showTime();
		clock1.computingTime();
		clock1.showTime();
	}

}

class Clock{
	int h;
	int m;
	int s;
	
	void showTime() {
		System.out.println(h + ":" + m + ":" + s);
	}
	
	void computingTime() {
		s++;
		if (s >= 60) {
			m++;
			s = 0;
		}
		if (m >= 60) {
			h++;
			m = 0;
		}
	}
	
	void createTime(int h, int m, int s) {
		this.h = h;
		this.m = m;
		this.s = s;
	}
}
