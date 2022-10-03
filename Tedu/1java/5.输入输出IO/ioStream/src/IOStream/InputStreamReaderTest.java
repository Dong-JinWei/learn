package IOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        System.out.println(inputStreamReader.getEncoding());
        System.out.println();

        char[] chars = new char[1024];
        int read = inputStreamReader.read(chars);

        for(int i = 0; i < read; i++){
            System.out.print(chars[i]);
        }
        System.out.println();

        inputStreamReader.close();
        fileInputStream.close();


    }
}
