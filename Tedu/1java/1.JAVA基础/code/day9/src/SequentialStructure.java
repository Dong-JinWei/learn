import java.util.Scanner;

public class SequentialStructure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("������һ�����֣�");
		int num = in.nextInt();
		System.out.printf("%d\n",num);
		in.nextLine();  //��ȡ����֮��Ŀ���
		
		System.out.println("��һ������name��");
		String name = in.nextLine();
		System.out.printf("%s\n",name);
		
		System.out.println("�ڶ�������name��");
		name = in.next();
		System.out.println(name);
		
		double d1;
		
		System.out.println("������һ����������");
		d1 = in.nextDouble();
		System.out.printf("%.2f",d1);
		
		
		
	}
}
