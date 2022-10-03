/**
 实现一个挺高级的字符匹配算法：
 给一串很长字符串，要求找到符合要求的字符串，例如目的串：123
 1******3***2 ,12*****3这些都要找出来
 */
public class No_33 {
    public static void main(String[] args) {
        String str1 = "1*****1*3***2";
        String str2 = "12*****4";
        String matchStr = "111111";
        System.out.println(matching(str1, matchStr));
        System.out.println(matching(str2, matchStr));


    }

    public static boolean matching(String strings, String matchStr){
        int count = 0;

        //保存字符串strings的匹配情况
        Boolean[] strFlag = new Boolean[strings.length()];
        //初始化为false
        for (int i = 0; i < strFlag.length; i++) {
            strFlag[i] = false;
        }
        for (int i = 0; i < matchStr.length(); i++){
            for (int j = 0; j < strings.length(); j++){
                // 如果这个值为false， 代表他没有被匹配过
                if (!strFlag[j]){
                    if (strings.charAt(j) == matchStr.charAt(i)){
                        strFlag[j] = true; // 如果匹配成功，就把他设置为true，下次就不进行匹配了
                        ++count;
                        break;
                    }
                }

            }
        }
        return count == matchStr.length();
    }
}
