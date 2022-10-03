/**
 * @author 26465
 * @create 2022-01-21 18:04
 */
public class No_10 {
    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(reverse(str));
    }

    public static String reverse(String str){
        String[] temp = str.split(" ");

        String res = "";

        for (int i = temp.length - 1; i >= 0; i--){
            res += temp[i] + " ";
        }
        return res.trim();
    }
}


