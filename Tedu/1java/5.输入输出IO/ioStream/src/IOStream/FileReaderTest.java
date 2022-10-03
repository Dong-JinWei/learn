package IOStream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(".\\test\\a.txt");
        char[] chars = new char[1024];

        if (fileReader.ready()){
            //fileReader.skip(2);
            int read = fileReader.read(chars);
            String s = new String(chars, 0, read);
            System.out.println(s);
        }


    }
}
