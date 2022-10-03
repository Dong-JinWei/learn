//package day26;
//
///**
// * @author 26465
// * @create 2022-01-20 11:04
// */
//public class EqualsTest {
//    public static void main(String[] args) {
//        day26.cloneTest.Person dio = new day26.cloneTest.Person("DIO", 200, "The World");
//        day26.cloneTest.Person dio2 = new day26.cloneTest.Person("DIO", 200, "The World");
//
//        System.out.println(dio.equals(dio2));
//        System.out.println();
//        System.out.println(dio.equals(dio));
//
//    }
//dio
//}
//
//class Person{
//    private String name;
//    private int age;
//    private String stand;
//
//    Person(String name, int age, String stand){
//        this.name = name;
//        this.age = age;
//        this.stand = stand;
//    }
//
//    public boolean equals(Object otherObject){
//        if (this == otherObject) {
//            System.out.println("this == otherObject");
//            return true;
//        }
//
//        if (otherObject == null) {
//            System.out.println("otherObject == null");
//            return false;
//        }
//
//        if (getClass() != otherObject.getClass()) {
//            System.out.println("getClass() != otherObject.getClass()");
//            return false;
//        }
//
//        day26.cloneTest.Person other = (day26.cloneTest.Person) otherObject;
//
//        return age == other.age && name.equals(other.name) && stand.equals(other.stand);
//
//    }
//}
