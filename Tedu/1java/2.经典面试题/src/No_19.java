/**
 第19题：
 题目：定义Fibonacci数列如下：
 / 0 n=0
 f(n)= 1 n=1
 \ f(n-1)+f(n-2) n=2

 输入n，用最快的方法求该数列的第n项。
 分析：在很多C语言教科书中讲到递归函数的时候，都会用Fibonacci作为例子。
 因此很多程序员对这道题的递归解法非常熟悉，但....呵呵，你知道的。。

 */
public class No_19 {
    public static void main(String[] args) {

        //1 1 2 3 5 8 13 21 34 55
        //递归
        System.out.println(funRecursive(10));

        //非递归
        System.out.println(fun(10));
    }

    //非递归实现
    public static int fun(int i){
        int[] arr = new int[i];
        int num1 = 1;
        int num2 = 1;
        int f = 0;
        arr[0] = 1;
        arr[1] = 1;
        for (int j = 2; j < i; j++) {
            arr[j] = arr[j-1] + arr[j - 2];
        }
        return arr[i - 1];
    }

    //递归实现
    public static int funRecursive(int i){
        if(i == 1 || i == 2){
            return 1;
        }else{
            return funRecursive(i - 2) + funRecursive(i - 1);
        }
    }
}

