import java.io.IOException;
import java.io.InputStream;

public class LsCommande {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("ls /");
            InputStream is = p.getInputStream();
            while (is.read() != -1){
                System.out.print((char)is.read());
            }
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
