import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // Date
        Map<Character, Integer> need, window;
        need = new HashMap<>();
        window = new HashMap<>();

        String s = "hello world";

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(need.containsKey(c)){
                int n = need.get(c);
                n++;
                need.put(c, n);
            }else {
                need.put(c, 1);
            }
        }
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
        System.out.println(need.get('o') == need.get('o'));

        String s1 = need.toString();
        System.out.println(s1);
    }

}
