import java.net.*;
import java.io.*;

public class WishesClientJ {
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket("localhost", 4000);
        String message1 = "Accept best wishes, Server Anton!";
        OutputStream ostream = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ostream);
        dos.writeBytes(message1);
        dos.close();
        ostream.close();
        sock.close();
    }
}