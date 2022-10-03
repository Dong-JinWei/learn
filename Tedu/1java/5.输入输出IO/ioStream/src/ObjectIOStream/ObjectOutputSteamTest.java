package ObjectIOStream;

import java.io.*;

public class ObjectOutputSteamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student(1001, "DIO", 88.4f, new MyDate(1958, 4, 19));

        File file = new File("a.bin");
        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);

        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("a.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Student studentRead = (Student) objectInputStream.readObject();

        System.out.println(studentRead);

        System.out.println(student == studentRead);
        System.out.println(student.birth == studentRead.birth);
    }
}

