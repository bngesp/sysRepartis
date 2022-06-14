package tp5.serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Declaration du serveur
            ServerSocket s = new ServerSocket(8080);
            while (true){

                // etablissement de la connexion
                Socket c = s.accept();

                // transmission
                // client -> input => serveur->output
                // serveur -> input <= client->output
                OutputStream out = c.getOutputStream();
                BufferedOutputStream bout = new BufferedOutputStream(out);
                DataOutputStream dout = new DataOutputStream(bout);

                dout.writeUTF("Bonjour le client");
                dout.flush();
                // afficher le msg du client
                DataInputStream is = new DataInputStream(new BufferedInputStream(c.getInputStream()));
                while (is.read() != -1 ){
                    System.out.println(is.readUTF());
                }

                is.close();
                // fermeture de la connexion
                dout.close();
                c.close();
            }

            //s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
