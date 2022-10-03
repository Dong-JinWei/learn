

public class ConditionalOperator {
	
	public static void main(String[] args) {
		
		int a = 1, b = 2, c = 3, d = 4;
		System.out.println( a > b?c: d);
		System.out.println();
		
		a = 123;
		b = 234;
		c = 345;
		
		d = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println(d);
		
		
	}
	
	
	
	

}
