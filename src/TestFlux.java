import java.io.*;

public class TestFlux {
    public static void main(String[] args) {
        File fichier = new File("src/files/test_file.txt");
        // ecrire dans le fichier
        try {
            FileOutputStream fos = new FileOutputStream(fichier); // recuperation du flux

            //2. utilisation du flux
            fos.write(0);
            fos.write(1);
            fos.write(2);

            // 3. fermeture du flux
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // flux => sortie = OutputStream : octet ,  Writter : caractere

        // lire le fichier
        try{
            // 1. recuperation du flux
            FileInputStream fis = new FileInputStream(fichier);

            // 2. utilisation du flux
            while ( fis.read() != -1){
                System.out.println(fis.read());
            }

            // 3. fermeture du flux
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
