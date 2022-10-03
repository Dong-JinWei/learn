package hemowork;

public class 第四题 {
    public static void main(String[] args) {
        printStar(9);
        
    }
    
    public static void printStar(int line){
        int star = 1;
        int space = line - 1;
        int i;

        for (i = 1; i <= line; i++){
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < star; j++) {
                System.out.print("* ");
            }
            System.out.println();

            if (i > line / 2){
                star -= 2;
                space = line - star;
            }else{
                star += 2;
                space = line - star;
            }
        }
    }
}
