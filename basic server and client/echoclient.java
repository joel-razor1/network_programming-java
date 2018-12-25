
import java.io.*;
import java.net.*;

public class echoclient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 4000);
        System.out.println("connected to server");

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("Message to Server");

        dos.close();
        socket.close();

    }
}