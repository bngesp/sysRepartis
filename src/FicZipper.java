import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FicZipper {
    public static void main(String[] args) {
        // prendre le fichier files/test.txt
        // compresser et le mettre zip/text.zip
        try {
            File fic = new File("src/files/test.txt");
            File fic2 = new File("src/files/test_file.txt");

            FileInputStream is = new FileInputStream(fic);
            FileInputStream is2 = new FileInputStream(fic2);

            // flux compressé
            File ficOut = new File("src/zip/text.zip");
            FileOutputStream fos = new FileOutputStream(ficOut);
            ZipOutputStream zip = new ZipOutputStream(fos);

            ZipEntry z = new ZipEntry("sortie_fichier_test.txt");
            zip.putNextEntry(z);
            while (is.read() != -1){
                zip.write(is.read());
            }

            ZipEntry z2 = new ZipEntry("sortie_fichier_test_clair.txt");
            zip.putNextEntry(z2);
            while (is2.read() != -1){
                zip.write(is2.read());
            }

            zip.finish();
            zip.closeEntry();
            zip.close();
            fos.close();
            is.close();

        }catch (Exception e){e.printStackTrace();}

        // 2 flux => flux d'entree inputStream => files/test.txt
        // Flux de sortie OutputStream->ZipOutputStream
    }
}
