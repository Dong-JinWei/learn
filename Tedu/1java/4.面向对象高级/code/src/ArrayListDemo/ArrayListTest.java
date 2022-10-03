package ArrayListDemo;

import java.util.ArrayList;
import java.util.Objects;


public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<A> list01 = new ArrayList<A>(10);
        list01.add(new A(1));
        list01.add(new A(2));
        list01.add(new A(3));
        list01.add(new A(4));
        list01.add(new A(5));
        list01.add(new A(6));
        System.out.println(list01);
        System.out.println(list01.size());
        list01.remove(new A(6));
        System.out.println(list01.size());
        System.out.println(list01.contains(new A(6)));
        System.out.println(list01);
    }
}

class A{
    int a;

    public A(int a){
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a1 = (A) o;
        return a == a1.a;
    }

}
