package cn.tedu.a;

import com.sun.media.sound.SoftTuning;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c = (Class<Student>)Class.forName("cn.tedu.a.Student");
        Constructor<Student> constructor = c.getConstructor(int.class, String.class, float.class);
        System.out.println(constructor.getName());

        Class<?>[] cs = constructor.getParameterTypes();
        for (Class tc: cs){
            System.out.println(tc.getName());
        }

        Student aa = constructor.newInstance(1001, "aa", 99.5f);
        System.out.println(aa);
    }
}
