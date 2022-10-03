package hemowork;


public class 第三题 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};

        System.out.println(maxSubArr(arr));

    }

    public static int maxSubArr(int[] arr){
        int maxStart = 0, maxEnd = 0, maxValue = arr[0];
        int i , start, end, value;

        for (i = 0, start = 0, value = 0; i < arr.length; i++){
            end = i;
            value += arr[i];

            if (value > maxValue){
                maxStart = start;
                maxEnd = end;
                maxValue = value;
            }

            if (value < 0){
                start = i + 1;
                value = 0;
            }
        }
        return maxValue;
    }
}
