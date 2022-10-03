package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println();

        File f1 = new File(".\\test\\a.txt");
        File f2 = new File("test");

        if (!f2.exists()) {
            f2.mkdir();
        }
        if (!f1.exists()) {
            f1.createNewFile();
        }
        System.out.println(f1.getName());
        System.out.println(f1.getPath());
        System.out.println(f1.getAbsolutePath());
        System.out.println();

        File[] files = File.listRoots();
        for (File file : files) {
            System.out.print(file + " ");
        }
        System.out.println();

        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());
        System.out.println();

        File f3 = new File(".");

        if (f3.isDirectory()) {
            for (String s : f3.list()) {
                System.out.print(s + " ");
            }
        }
        System.out.println();

        if (f3.isDirectory()) {
            String[] list = f3.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith("t");
                }
            });
            for (String str : list) {
                System.out.print(str + " ");
            }
        }
        System.out.println();

        if (f3.isDirectory()) {
            File[] listFiles = f3.listFiles();
            for (File ls : listFiles) {
                System.out.print(ls + " ");
            }
        }
    }
}
