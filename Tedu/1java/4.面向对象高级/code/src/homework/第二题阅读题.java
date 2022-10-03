package homework;


/*
1
 */
public class 第二题阅读题 {
    static int a=0;
    static void f1(){
        try{
            a++;  // 1. a = 1;
            a = f2(a-1); // 2. 异常
            a++;
            return;
        }catch (Exception e){
            a++; //3. a = 2;
            return; //4. 放入共享区域，因为没有返回值，所以没有东西放入共享区域 6. 结束方法
        }finally {
            a--; // 5. a = 1
        }
    }
    static int f2(int a){
        return 100/a;
    }
    public static void main(String[] args) {
        f1();
        System.out.println(a); // 7. a = 1;
    }
}
