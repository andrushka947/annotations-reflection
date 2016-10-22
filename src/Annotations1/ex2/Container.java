package Annotations1.ex2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "E:\\for_java/1/saverToAnnotation.txt")
public class Container {
    String text = "hey, man";

    @Saver
    public void save(String path) {
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter printWriter = new PrintWriter(path);
                printWriter.write(text);
                printWriter.flush();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error with writing into a file");
            }
    }
}
