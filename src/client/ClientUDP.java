package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket client = new DatagramSocket();
            byte[] msg = "bonjour Serveur".getBytes(StandardCharsets.UTF_8);
            InetAddress adresseServeur = InetAddress.getByName("localhost");
            DatagramPacket paquet = new DatagramPacket(msg, 0, msg.length, adresseServeur, 8090);
            client.send(paquet);

            byte[] msgRetour = new byte[50];
            DatagramPacket paquetEntrant = new DatagramPacket(msgRetour, msgRetour.length);
            client.receive(paquetEntrant);
            System.out.println(new String(msgRetour));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
