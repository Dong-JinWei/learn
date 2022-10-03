package day28;

/**
 * @author 26465
 * @create 2022-01-24 11:41
 */
//接口--方法：两个参数，返回boolean值
//类1--实现接口---重写方法：a>b  true
//类2--实现接口---重写方法：a<b  true
//类3--实现接口---重写方法：|a|>|b|  true
//类4--实现接口---重写方法：|a|<|b|  true
interface CompareRuler{
    boolean compare(int a, int b);
}
class Big implements CompareRuler{
    @Override
    public boolean compare(int a, int b) {
        return a > b;
    }
}
class Small implements CompareRuler{
    @Override
    public boolean compare(int a, int b) {
        return a < b;
    }
}
class AbsBig implements CompareRuler{
    @Override
    public boolean compare(int a, int b) {
        return Math.abs(a) > Math.abs(b);
    }
}
class AbsSmall implements CompareRuler{
    @Override
    public boolean compare(int a, int b) {
        return Math.abs(a) < Math.abs(b);
    }
}
public class 排序 {
    static void sort(int[] arr, CompareRuler compareRuler){
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                boolean compare =
                        compareRuler.compare(arr[j], arr[j + 1]);
                if (compare){
                    int t;
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
    static void display(int[] arr){
        for (int a: arr){
            System.out.print(a + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,71,7,-41,-107,411,-12,497,2,47};
        //sort(arr, new Big());
//        sort(arr, new Small());
//        sort(arr, new AbsSmall());
        sort(arr, new AbsBig());
        display(arr);
    }
}
//策略模式