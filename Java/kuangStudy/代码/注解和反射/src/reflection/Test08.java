package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.User");

        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        System.out.println("++++++++++++++++++++++++++++++++++");
        Field[] fields = c1.getFields();//只能找到public属性

        fields = c1.getDeclaredFields(); //找到全部属性
        for(Field field:fields){
            System.out.println(field);
        }

        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("+++++++++++++++=+++++++++++++");
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods:" + method);
        }
    }
}
