
public class IfAndSwitch {
	public static void main(String[] args) {
		int score = 80;

		if (score >= 60) {
			System.out.println("����");
		} else {
			System.out.println("������");
		}

		// if���ֻ���ߵ������
		if (score > 60) // ���±ߵ�if�����
			if (score >= 80) // ��Ϊ����һ������壬���ԣ�����ִ������if-else��������ִֻ��if��
				System.out.println("����");
			else
				System.out.println("����");
		else
			System.out.println("������");

		// ���������ϵ���д������д��������ʾ
		if (score > 60) { // д���������������Ķ��ͺ���ά��
			if (score >= 80) {
				System.out.println("����");
			} else {
				System.out.println("����");
			}
		} else {
			System.out.println("������");
		}
		

	}

}
