package ObjectIOStream;

import java.io.*;

public class 深复制 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student(1001, "DIO", 88.4f, new MyDate(1958, 4, 19));

        Student studentCopy = (Student) deepCopy(student);
        System.out.println(student);
        System.out.println(studentCopy);
        System.out.println(studentCopy == student);
        System.out.println(studentCopy.birth == student.birth);


    }

    public static Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);

        byte[] bytes = outputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();

    }

}
