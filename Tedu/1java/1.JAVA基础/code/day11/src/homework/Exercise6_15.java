package homework;

public class Exercise6_15 {
	public static void main(String[] args) {
		// 定义两队队员
//		String[] first = { "A", "B", "C" }; // 甲队
//		String[] second = { "X", "Y", "Z" };// 乙队
//
//		
//		// 循环便利数组
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				String game = first[i] + second[j]; // 将比赛的队员放到一起
//				if (game.equals("AX") || game.equals("CX") || game.equals("CZ")) {
//					// 应为A不和X大，C不和X，Y打，所以，如果条件成立的话，就返回执行，不打印输出
//					continue;
//				}
//				System.out.println("甲队队员" + first[i] + " 对阵 " + "乙队队员" + second[j]);
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
