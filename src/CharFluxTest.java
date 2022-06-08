import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class CharFluxTest {
    public static void main(String[] args) {
        File fichierClair = new File("src/files/test_clear.txt");
        // flux sorti : Reader; Writer
        try {
            // 1. recuperation
            FileWriter fwrite = new FileWriter(fichierClair);

            // 2 utilisation du flux
            fwrite.write("bonjour je suis un text");
            fwrite.write( " du texte");

            // 3. fermeture du flux
            fwrite.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            FileReader fread = new FileReader(fichierClair);

            while (fread.read() != -1){
                System.out.println((char)fread.read());
            }

            fread.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
