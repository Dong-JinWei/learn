package leetCode;

/**
 * @author 26465
 * @create 2022-01-21 14:39
 */
class Solution {
    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        int end = s.length() - 1;
        int start = 0;

        while (start < end){
            char ch = s.charAt(start);
            if(ch == '('){
                if (s.charAt(start) != (s.charAt(end) - 1)){
                    return false;
                }else{
                    start++;
                    end--;
                }
            }else{
                if (s.charAt(start) != s.charAt(end) + 2){
                    return false;
                }else{
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}
