package serveur;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try{
            // Demarrage du serveur
            ServerSocket s = new ServerSocket(8080);
            try {
                while (true){

                    // Etablissement de la communication
                    Socket leClient = s.accept();

                    // communication
                    OutputStream out = leClient.getOutputStream();
                    out.write(2);
                    InputStream in = leClient.getInputStream();
                    System.out.println(in.read());

                    out.close();
                    in.close();
                    leClient.close();
                }

            } finally {
                s.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
