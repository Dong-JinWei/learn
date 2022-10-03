import java.util.Scanner;

public class SequentialStructure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入一个数字：");
		int num = in.nextInt();
		System.out.printf("%d\n",num);
		in.nextLine();  //读取数字之后的空行
		
		System.out.println("第一次输入name：");
		String name = in.nextLine();
		System.out.printf("%s\n",name);
		
		System.out.println("第二次输入name：");
		name = in.next();
		System.out.println(name);
		
		double d1;
		
		System.out.println("请输入一个浮点数：");
		d1 = in.nextDouble();
		System.out.printf("%.2f",d1);
		
		
		
	}
}
