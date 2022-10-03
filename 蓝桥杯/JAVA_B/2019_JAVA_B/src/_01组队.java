import java.util.Scanner;

public class _01×é¶Ó {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] team = new int[25][5];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 5; j++) {
				team[i][j] = sc.nextInt();
			}
		}
		
		int maxSum = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (i != j)for ( int k = 0; k < 20 ; k++) {
					if (k != j) for ( int h = 0; h < 20; h++) {
						if ( h != k) for(int g = 0; g < 20; g++) {
							int max = team[i][0] + team[i][1] + team[i][2] + team[i][3] + team[i][4] + team[i][5];
							if ( max > maxSum) {
								maxSum = max;
							}
						}
					}
				}
			}
		}
		System.out.println(maxSum);
	}

}
