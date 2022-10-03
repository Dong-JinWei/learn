public class BF {
    public static void main(String[] args) {
        String str1 = "ABCDERFGCDR";
        String str2 = "CDR";

        int bf = bf(str1.toCharArray(), str2.toCharArray());

        System.out.println(bf);

    }

    public static int bf(char[] str1, char[] str2) {
        int i = 0;
        int j = 0;

        while (i < str1.length && j <= i) {

            if (str1[i] == str2[j]) {
                i++;
                j++;
            } else {
                j = 0;
                i++;
            }
        }

        if (j != 0) {
            return i - j;
        } else {
            return -1;
        }

    }
}