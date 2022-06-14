import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TP4 {
    public static void main(String[] args) {
        try {
            File dossier = new File("/Users/mac/GitechProject/cours/sysrepartis/cours");
            // flux compressé
            File ficOut = new File("src/zip/text.zip");
            FileOutputStream fos = new FileOutputStream(ficOut);
            ZipOutputStream zip = new ZipOutputStream(fos);

            if(dossier.isDirectory()){
                File[] fichiers = dossier.listFiles();
                for(File f : fichiers){
                    FileInputStream isFile = new FileInputStream(f);
                    ZipEntry z = new ZipEntry(f.getName());
                    zip.putNextEntry(z);
                    while (isFile.read() != -1){
                        zip.write(isFile.read());
                    }
                    isFile.close();
                }

            }
            zip.finish();
            zip.closeEntry();
            zip.close();
            fos.close();

        }catch (Exception e){e.printStackTrace();}

        // 2 flux => flux d'entree inputStream => files/test.txt
        // Flux de sortie OutputStream->ZipOutputStream
    }
}
