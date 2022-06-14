package tp5.client;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class ClientTP5 {

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

            Scanner sc = new Scanner(System.in);
            String line = null;
            while (!Objects.equals(line, "exit")){
                DataOutputStream os = new DataOutputStream(new BufferedOutputStream(c.getOutputStream()));
                line = sc.nextLine();
                os.writeUTF(line);
                os.flush();
                os.close();
            }

            dif.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
