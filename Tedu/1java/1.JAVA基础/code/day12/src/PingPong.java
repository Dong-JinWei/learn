
public class PingPong {
	public static void main(String[] args) {
		int i, j, k;

			for (i = 1; i <= 3; i++) {
				for (j = 1; j <= 3; j++) {
					if (i != j) {
						for (k = 1; k <= 3; k++) {
							if (i != k && j != k) {
								if (i != 1 && k != 1 && k != 3) {
									System.out.println(i + "---A " + j + "---B " + k + "---C");
								switch (i) {
								case 1:
									System.out.println("张三---A");
									break;
								case 2:
									System.out.println("李四---A");
									break;
								case 3:
									System.out.println("王五---A");
									break;									
								}
								
								switch (j) {
								case 1:
									System.out.println("张三---B");
									break;
								case 2:
									System.out.println("李四---B");
									break;
								case 3:
									System.out.println("王五---B");
									break;	
								}
								
								switch (k) {
								case 1:
									System.out.println("张三---C");
									break;
								case 2:
									System.out.println("李四---C");
									break;
								case 3:
									System.out.println("王五---C");
									break;	
								}
							}
						}
					}
				}
			}
		}
	}

}
