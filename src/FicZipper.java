import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FicZipper {
    public static void main(String[] args) {
        // prendre le fichier files/test.txt
        // compresser et le mettre zip/text.zip
        try {
            File fic = new File("src/files/test.txt");
            FileInputStream is = new FileInputStream(fic);

            // flux compressé
            File ficOut = new File("src/zip/text.zip");
            FileOutputStream fos = new FileOutputStream(ficOut);
            ZipOutputStream zip = new ZipOutputStream(fos);
            ZipEntry z = new ZipEntry("src/zip/text.zip");
            zip.putNextEntry(z);
            while (is.read() != -1){
                zip.write(is.read());
            }
            zip.close();
            fos.close();
            is.close();

        }catch (Exception e){e.printStackTrace();}

        // 2 flux => flux d'entree inputStream => files/test.txt
        // Flux de sortie OutputStream->ZipOutputStream
    }
}
