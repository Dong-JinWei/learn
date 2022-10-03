package day0408;

public class A {
    private int a = 10;
    public class B{//B类定义在A类的内部，把B称为内部类
        private int a = 100;
        public void show(){
            System.out.println("a=" + a);
        }

        public void show1(){
            System.out.println("a=" + A.this.a);
        }
    }
}
