package hemowork;

public class 第二题 {
    public static void main(String[] args) {
        int i, j, k;

        for(i = 1; i <= 4; i++){
            for(j = i + 1; j <= 5; j++){
                for(k = j + 1; k <= 6; k++){
                    System.out.print("" + i + j + k + " ");
                }
            }
            System.out.println();
        }
    }
}
