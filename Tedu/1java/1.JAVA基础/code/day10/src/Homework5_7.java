
/**
 * 5.7��һ��������5λ��������,Ҫ��: ������Ǽ�λ���r �ֱ����ÿһλ����; .�����������λ����,����ԭ��Ϊ321,Ӧ���123��
 * 
 * @author 26465
 *
 */
import java.util.Scanner;

public class Homework5_7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("������һ��С����λ�����֣�");
		int num = in.nextInt();
		int w;
		int q;
		int b;
		int s;
		int g;

		if (num / 100000 > 0) {
			System.out.println("������Ч��������һ����������λ����������");
			return;
		}

		int flag = 0; // ��ʾ���������Ǽ�λ����

		if (num > 10000) { // ����10000��5λ�����±��Դ�����
			flag = 5;
		} else if (num > 1000) {
			flag = 4;
		} else if (num > 100) {
			flag = 3;
		} else if (num > 10) {
			flag = 2;
		} else if (num > 1) {
			flag = 1;
		}
		System.out.println("��һ��" + flag + "λ��");

		w = num / 10000; // ��ȡ��λ������
		q = num / 1000 % 10; // ��ȡǧλ������
		b = num / 100 % 10; // ��ȡ��λ������
		s = num / 10 % 10; // ��ȡ10λ������
		g = num % 10; // ��ȡ��λ������

		switch (flag) {
		case 5:
			System.out.println("��λ����" + w);
		case 4:
			System.out.println("ǧλ����" + q);
		case 3:
			System.out.println("��λ����" + b);
		case 2:
			System.out.println("ʮλ����" + s);
		case 1:
			System.out.println("��λ����" + g);
		}

		// ����λ����ͬ�����������
		String str = "";
		switch (flag) {
		case 5:
			str = str + g + s + b + q + w;
			break;
		case 4:
			str = str + g + s + b + q;
			break;
		case 3:
			str = str + g + s + b;
			break;
		case 2:
			str = str + g + s;
			break;
		case 1:
			str = str + g;
			break;
		}
		System.out.println(str);

	}
}
