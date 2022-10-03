/**
 * 47.创新工场：
 * 求一个数组的最长递减子序列 比如{9，4，3，2，5，4，3，2}的最长递减子序列为{9，5，4，3，2}
 */
public class No_47xxxx {
    public static void main(String[] args) {

        int[] arr = new int[]{9,4,3,2,5,4,3,2};

        int[] index = longestSubArrays(arr);

        for(int i = index[0]; i < index[1]; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static int[] longestSubArrays(int[] arr){
        int maxCount = 0, maxEnd = 0;
        int i = 0, count = 0;

        for (i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i + 1]){
                ++count;
            }else{
                if (count > maxCount){
                    maxCount = count + 1;
                    maxEnd = i;
                }
                count = 0;
            }
        }

        if (count > maxCount){
            maxCount = count;
            maxEnd = i - 1;
        }
        System.out.println(maxCount);
        System.out.println(maxEnd);

        return new int[]{maxEnd + 1 - maxCount, maxCount};


    }

}
