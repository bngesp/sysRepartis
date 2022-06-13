package client;

import java.io.*;
import java.net.Socket;

public class ClientCaractere {
    public static void main(String[] args) {
        try {
            // Etablissement de la connexion
            Socket c = new Socket("localhost", 8080);

            // transmission
            InputStream is = c.getInputStream();
            BufferedInputStream bif = new BufferedInputStream(is);
            DataInputStream dif = new DataInputStream(bif);

            String msg = dif.readUTF();
            System.out.println(msg);
            // envoyer un msg au serveur -> merci pour le service
            //fermeture de la connexion
            dif.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
