
public class DataTest {
	public static void main(String[] args) {
		
		System.out.println("byte�����ֵ��"+Byte.MAX_VALUE);
		System.out.println("int�����ֵ��"+Integer.MAX_VALUE);
		System.out.println("Long�����ֵ��"+Long.MAX_VALUE);
		System.out.println();
		
		//����һ���ж��ٺ���
		System.out.println("365*24*60*60*1000 = "+(365*24*60*60*1000));//���ݳ���int�����Χ
		System.out.println("365L*24L*60L*60L*1000L = "+ (365L*24L*60L*60L*1000L));
		System.out.println();
		
		//�������ľ���
		float f1 = 12.3f;
		float f2 = 12.4f;
		float f3 = f2 - f1;
		System.out.println("12.4f-12.3f �Ƿ���� 0.1f��" + (f3 == 0.1f));
		System.out.println();
		
		//���Ƶ�ת��
		System.out.println("0b10ת��Ϊʮ�����ǣ�" + 0b10); //2
		System.out.println("010ת��Ϊʮ�����ǣ�" + 010); //8
		System.out.println("10ת��Ϊʮ�����ǣ�" + 10); //10
		System.out.println("0x10ת��Ϊʮ�����ǣ�" + 0x10); //16
		System.out.println();
		
	}

}
