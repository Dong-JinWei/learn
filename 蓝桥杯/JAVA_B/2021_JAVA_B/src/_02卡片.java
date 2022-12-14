import java.util.Arrays;

/*
小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。

小蓝准备用这些卡片来拼一些数，他想从 1 开始拼出正整数，每拼一个， 就保存起来，卡片就不能用来拼其它数了。

小蓝想知道自己能从 1 拼到多少。

例如，当小蓝有 30 张卡片，其中 0 到 9 各 3 张，则小蓝可以拼出 1 到 10， 但是拼 11 时卡片 1 已经只有一张了，不够拼出 11。

现在小蓝手里有 0 到 9 的卡片各 2021 张，共 20210 张，请问小蓝可以从 1 拼到多少？
 */
public class _02卡片 {
	public static void main(String[] args) {
        int[] chs = new int[10];
        Arrays.fill(chs, 2021);

        for (int i = 1; ; i++) {
            for (char c : String.valueOf(i).toCharArray()) {
                if (chs[c - '0'] == 0) {
                    System.out.println(i-1);
                    return;
                }
                chs[c - '0']--;
            }
        }
    }
}
