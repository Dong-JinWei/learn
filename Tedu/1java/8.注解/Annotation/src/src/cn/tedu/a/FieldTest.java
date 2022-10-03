package cn.tedu.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FieldTest {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Student> c = (Class<Student>)Class.forName("cn.tedu.a.Student");
        Field field = c.getField("name");
        System.out.println(field.getType());
        System.out.println(field.getName());

        //根据名字生成setter方法名，调用setter方法给对象赋值。
        Student student = c.newInstance();
        String fieldName = "name";  //setName
        char first = fieldName.charAt(0);
        if (first >= 'a' && first <= 'z'){
            first = (char)(first - ('a' - 'A'));
        }
        String methodName;
        methodName = "set" + first + fieldName.substring(1);
        System.out.println(methodName);
        Method method = c.getMethod(methodName, String.class);
        method.invoke(student, "张三");
        System.out.println(student);
        
    }
}
