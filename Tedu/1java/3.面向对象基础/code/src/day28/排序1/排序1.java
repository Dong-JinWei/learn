package day28.排序1;


/**
 * @author 26465
 * @create 2022-01-24 11:46
 */
public class 排序1 {
    public static void main(String[] args) {
        int[] arr = {10,71,7,-41,-107,411,-12,497,2,47};
        sort(arr, new Big());
        show(arr);
        sort(arr, new Small());
        show(arr);
    }



    static void sort(int[] arr, CompareRuler compareRuler){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                boolean compare = compareRuler.compare(arr[j], arr[j - 1]);
                if (compare){
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
    }

    public static void show(int[] arr){
        for (int a: arr
             ) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}

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


