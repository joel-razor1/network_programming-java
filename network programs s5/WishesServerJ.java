import java.net.*;
import java.io.*;

public class WishesServerJ {
    public static void main(String args[]) throws Exception {
        ServerSocket serverSock = new ServerSocket(4000);
        System.out.println("Server is ready.");
        Socket sock = serverSock.accept();
        InputStream istream = sock.getInputStream();
        DataInputStream dstream = new DataInputStream(istream);
        String message2 = dstream.readLine();
        System.out.println(message2);
        dstream.close();
        istream.close();
        sock.close();
        serverSock.close();
    }

}
