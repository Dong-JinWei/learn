package homework;

public class Exercise6_15 {
	public static void main(String[] args) {
		// �������Ӷ�Ա
//		String[] first = { "A", "B", "C" }; // �׶�
//		String[] second = { "X", "Y", "Z" };// �Ҷ�
//
//		
//		// ѭ����������
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				String game = first[i] + second[j]; // �������Ķ�Ա�ŵ�һ��
//				if (game.equals("AX") || game.equals("CX") || game.equals("CZ")) {
//					// ӦΪA����X��C����X��Y�����ԣ�������������Ļ����ͷ���ִ�У�����ӡ���
//					continue;
//				}
//				System.out.println("�׶Ӷ�Ա" + first[i] + " ���� " + "�ҶӶ�Ա" + second[j]);
//			}
//
//		}
		
		int i, j, k;
		
		for (i = 'X'; i <= 'Z'; i++) {
			for (j = 'X'; j <= 'Z'; j++) {
				if (i != j) {
					for (k = 'X'; k <= 'Z'; k++) {
						if (i != k && j != k) {
							if (i != 'X' && k != 'X' && k != 'Z') {
								System.out.printf("%c---A %c---B %c---C", i ,j ,k);
							}
						}
					}
				}
			}
		}

	}

}
