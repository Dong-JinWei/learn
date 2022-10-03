package day19;

public class ³ÔÌÒ {
	public static void main(String[] args) {
		System.out.println(monkey(1));
	}

	
	static int monkey(int day) {
		if(day == 10) return 1;
		return (monkey(day + 1) + 1) * 2;
	}
}
