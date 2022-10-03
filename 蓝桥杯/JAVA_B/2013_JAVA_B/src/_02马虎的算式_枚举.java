public class _02马虎的算式_枚举 {
	public static void main(String[] args) {
		int ans=0;
		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 10; b++) {
				if(b != a)for (int c = 1; c < 10; c++) {
					if(c != b&& c != a)for (int d = 1; d < 10; d++) {
						if (d != c && d != b && d != a)for (int e = 1; e < 10; e++) {
							if(e != d && e != c && e != b && e != a) {
								if((a*10+b)*(c*100+d*10+e) == (a*100+d*10+b)*(c*10+e)) {
									ans++;
									System.out.printf("(%d*10+%d)*(%d*100+%d*10+%d) == (%d*100+%d*10+%d)*(%d*10+%d)\n",a,b,c,d,e,a,d,b,c,e);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
