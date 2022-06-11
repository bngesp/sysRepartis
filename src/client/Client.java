package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            //etablissement
            Socket c = new Socket("localhost", 8080);


            // communication
            InputStream is = c.getInputStream();
            int x = is.read();
            System.out.println(x);
            OutputStream os = c.getOutputStream();
            os.write(x+1);

            os.close();
            is.close();
            c.close();

        }catch (Exception e){e.printStackTrace();}
    }
}
