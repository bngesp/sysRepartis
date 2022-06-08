import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("src/files/test.txt");
        try {
            int i = 0;
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Hello World! "+(i++));
            bw.newLine();
            bw.write("Hello World!"+(i++));
            bw.newLine();
            bw.write("Hello World!"+(i++));
            bw.newLine();
            bw.write("Hello World!"+i);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
