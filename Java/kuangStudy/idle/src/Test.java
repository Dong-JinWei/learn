class Father{
    private String name="zhangjun";

    class Child{
        public void introFather(){
            System.out.println("Father's name is "+name);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Father.Child c1 = new Father().new Child();
        c1.introFather();
    }
}