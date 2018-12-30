import java.io.*;
import java.net.*;
import java.net.Scanner;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        byte buf[] = null;
        while (true) {
            String inp = sc.nextLine();
            buf = inp.getBytes();
            DatagramPacket Dpsend = new DatagramPacket(buf, buf.length, "localhost", 4000);
            ds.send(DpSend);
            if (inp.equals("bye"))
                break;
        }
    }
}