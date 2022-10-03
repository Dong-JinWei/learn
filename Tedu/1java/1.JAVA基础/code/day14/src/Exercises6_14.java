//´òÓ¡ÁâÐÎ

public class Exercises6_14 {
	public static void main(String[] args) {
		/*
		 * 7ÐÐ
		 * 6¿Õ¸ñ 1ÐÇ  line - star = 7 - 1 = 6 space
		 * 4¿Õ¸ñ 3ÐÇ  7 - 3 = 4 space 
		 * 2¿Õ¸ñ 5ÐÇ  7 - 5 = 2 space
		 * 0¿Õ¸ñ 7ÐÇ
		 * 2¿Õ¸ñ 5ÐÇ
		 * 4¿Õ¸ñ 3ÐÇ
		 * 6¿Õ¸ñ 1ÐÇ
		 */
		int line, space, star;
		int sumStar;
		line = 11;
		star = 1;
		space = line - star;

		for (int i = 1; i <= line; i++) {
			
			
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
				
			}
			
			for (int k = 0; k < star; k++) {
				System.out.print("* ");
			}
			System.out.println();
			
			if (i > line / 2) {
				star -= 2;
				space = line - star;
			}else {
				star += 2;
				space = line - star;
			}
		}
		
	}

}
