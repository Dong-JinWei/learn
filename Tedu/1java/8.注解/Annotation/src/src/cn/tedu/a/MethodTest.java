package cn.tedu.a;

import com.sun.media.sound.SoftTuning;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Student> c = (Class<Student>)Class.forName("cn.tedu.a.Student");
        Method method = c.getMethod("f", float.class, String.class);
        System.out.println(method.getReturnType());
        System.out.println(method.getName());
        Class<?>[] types = method.getParameterTypes();
        for (Class tc: types){
            System.out.println(tc.getName());
        }
        Student s = new Student();
        //method.invoke(s, 23, "abc");
        testMethod(method, 23, "abc", s);
        method = c.getMethod("g", float.class, String.class);
        testMethod(method, 23, "abc", s);
    }

    static void testMethod(Method method, float f, String str, Object obj) throws InvocationTargetException, IllegalAccessException {
        method.invoke(obj, f, str);
    }
}
