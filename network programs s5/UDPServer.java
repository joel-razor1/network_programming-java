import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket ds = new DatagramSocket(4000);
        byte[] receive = new byte[65535];
        while (true) {
            DatagramPacket DPReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DPReceive);
            System.out.println("Client" + data(receive));
            if (data(receive).toString().equals("bye"))
                System.out.println("Client says bye.....terminating");
            receive = new byte[65535];
        }
    }

    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;

        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}