package annotation;

import java.util.ArrayList;
import java.util.List;

//什么是注解
public class Test01 extends Object{

    //重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated //不推荐使用，但是可以使用，或者存在更好的方式
    public static void test(){
        System.out.printf("Deprecated");
    }

    @SuppressWarnings("all")//镇压警告，可以传参
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
