package homework;

public class Exercise6_10 {

	public static void main(String[] args) {
		int peach = 1;
		for (int i = 0; i < 9; i++) { // �����һ������ӣ�����������9��
			// ����Ļ��� peach / 2 - 1�����Ե��������ƾ��� (peach + 1) * 2
			peach = (peach + 1) * 2; 
		}
//		System.out.println("���Ϲ���"+ peach+"������");
//		peach = peach / 2 - 1;  //��������������Ϲ��е�������
//		 Ȼ����������������һ��ժ�˵ģ��������ֻ���9��������������һ���ġ�
		System.out.println("��һ��ժ��" + peach + "������");

	}

}
