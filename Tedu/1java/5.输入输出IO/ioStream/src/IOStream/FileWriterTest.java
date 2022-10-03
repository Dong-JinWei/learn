package IOStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter(".\\test\\a.txt");
        writer.write("我很好！");
        writer.close();
    }
}
