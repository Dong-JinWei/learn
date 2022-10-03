
public class test {
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(str + 1 + 2 + 3); //hello123
		System.out.println(str + " world");  //hello world
		System.out.println(str + (1 + 2) + 4);  // hello34
		System.out.println();
		
		System.out.println(5/2); //2
		System.out.println(5.0 / 2.0);  //2.5
		System.out.println();
		
		
		System.out.println(15%6);  //3
		System.out.println(15%-6); //3
		System.out.println(-15%6); //-3
		System.out.println(-15%-6); //-3
		System.out.println();
		
		int a = 10;
		System.out.println(a++); //10
		System.out.println(a);  //11
		System.out.println(++a); //12
		System.out.println(a);  //12
		System.out.println();
		
		char i = 'i';
		//i = i + 1;  自动类型提升
		i += 1;
		System.out.println(i);
		System.out.println();
		
	}
}
