package serveur;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.*;

public class ServeurCaractere {

    public static void main(String[] args) {
        try {
            // Declaration du serveur
            ServerSocket s = new ServerSocket(8080);
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

            // fermeture de la connexion
            dout.close();
            c.close();
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
