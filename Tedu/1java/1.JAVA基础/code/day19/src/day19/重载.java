package day19;

public class жиди {
	public static void main(String[] args) {
		add(1, 2);
		add(1.1f, 1.2f);
		add(1.1, 1.2);
		add(1.1f, 1.2);

	}

	static int add(int a, int b) {
		System.out.println("int add");
		return a + b;
	}

	static float add(float a, float b) {
		System.out.println("float add");
		return a + b;
	}

	static double add(double a, double b) {
		System.out.println("double add");
		return a + b;
	}

}
