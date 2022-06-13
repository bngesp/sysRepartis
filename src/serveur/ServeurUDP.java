package serveur;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServeurUDP {

    public static void main(String[] args) {
        try {
            DatagramSocket serveur = new DatagramSocket(8090);
            byte[] msg = new byte[20]; // le message à recuperer
            DatagramPacket paquetEntrant = new DatagramPacket(msg, msg.length);  // formatage du paquet
            serveur.receive(paquetEntrant); // appel bloquant
            System.out.println(new String(msg));

            byte[] msgRetour = "Bien recu client".getBytes();
            InetAddress addressClient  = paquetEntrant.getAddress();
            int portClient = paquetEntrant.getPort();
            DatagramPacket paquetSortant = new DatagramPacket(msgRetour, 0, msgRetour.length, addressClient , portClient );
            serveur.send(paquetSortant);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
