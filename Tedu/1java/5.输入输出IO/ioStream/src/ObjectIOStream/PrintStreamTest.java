package ObjectIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream("a.txt");
        printStream.println("Hello World!");
        System.out.println("你好，世界！");
        printStream.close();

        FileInputStream fileInputStream = new FileInputStream("a.txt");
        Scanner scanner = new Scanner(fileInputStream);

        System.out.println(scanner.nextLine());
    }
}
