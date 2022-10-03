package com.danei.lesson01;

/**
 * 二分查找
 */
public class find {

    public static int findX(int[] args, int n){
        int left = 0;
        int right = args.length - 1;

        while( left <= right){
            int mid = (right - left) / 2 + left;

            if(args[mid] == n){
                return mid;
            }else if(args[mid] > n){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbs = {2,4,6,7,8,10,12,24,28};
        int x = 28;
        System.out.println("你要找的数字是：" + x);
        int num = find.findX(numbs, x);
        System.out.println("他的下标是："+num);
    }

}
