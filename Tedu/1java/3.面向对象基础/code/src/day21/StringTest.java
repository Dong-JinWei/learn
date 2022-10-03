package day21;

/**
 * @author 26465
 * @create 2022-01-15 11:36
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "programming";  //常量池 "programming"
        String s2 = new String("programming");//堆区 "programming"
        String s3 = "program";  //常量池 ”program“
        String s4 = "ming";  //常量池 ”ming“
        String s5 = "program" + "ming"; //s5="programming" 常量池 ”programming“
        //(new StringBuilder("program")).append(s4).toString(); 堆区 "programming"
        String s7 = "program" + s4;     //return new String(this)
        //(new StringBuiler(s3)).append(s4).toString();  堆区 ”programming“
        String s6 = s3 + s4;

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s5);  // true
        System.out.println(s1 == s6);     //false
        System.out.println(s1 == s6.intern());   // true
        System.out.println(s2 == s2.intern()); //false
        System.out.println(s6 == s7);   //false
        System.out.println(s1 == s7.intern());  // true
    }
}
