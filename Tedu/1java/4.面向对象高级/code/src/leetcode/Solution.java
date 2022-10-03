package leetcode;

/**
 * @author 26465
 * @create 2022-01-29 10:59
 */
class Solution {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        String temp = "";
        int right;
        for (int i = 0; i < str.length; i++) {
            for (int j = (str[i].length() - 1); j >= 0 ; j--) {
                temp = temp + str[i].charAt(j);
            }
            temp = temp + " ";
        }
        return temp;
    }
}