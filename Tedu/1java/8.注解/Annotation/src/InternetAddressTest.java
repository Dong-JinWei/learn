class A {
    static{
        System.out.println("A static block ");
    }
    public A(){
        System.out.println("A ");
    }
}
class B extends A{
    static{
        System.out.println("B static block ");
    }
    {
        System.out.println("B block ");
    }
    public B(){                 //line n1
        System.out.println("B ");
    }
}

class C extends B{
    static{
        System.out.println("C static block ");
    }
    public C(){                 //line n2
        System.out.println("C ");
    }
    public static void main(String[] args){
        C c = new C();
    }
}
