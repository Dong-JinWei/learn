import java.util.Collections;
import java.util.LinkedList;

public class Leetcode394 {
    static int ptr;

    public static void main(String[] args) {

    }

    public static String decodeStreing(String s) {
        ptr = 0;
        LinkedList<String> stk = new LinkedList<String>();

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while (repTime-- > 0) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    private static String getString(LinkedList<String> sub) {
        StringBuffer ret = new StringBuffer();
        for (String s : sub){
            ret.append(s);
        }
        return ret.toString();
    }

    private static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }
}