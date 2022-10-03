package day23;

/**
 * @author 26465
 * @create 2022-01-18 9:33
 */
public class JiCheng {
    public static void main(String[] args) {
        new Z();
    }
}
/*
Y
X
Y
Z
 */
class X {
    public static int a = 1;
    Y b = new Y();
    X() {
        System.out.print("X");
    }
}

class Y {
    Y() {
        System.out.print("Y");
    }
}

class Z extends X {
    Y y = new Y();
    Z() {
        System.out.print("Z");
    }
}




