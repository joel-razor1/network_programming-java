import java.io.*;
import java.net.*;
import java.util.*;

public class MACaddress {
    public static String getMACIdentifier(NetworkInterface network) {
        StringBuilder identifier = new StringBuilder();
        try {
            byte[] macbuffer = network.getHardwareAddress();
            if (macbuffer != null) {
                for (int i = 0; i < macbuffer.length; i++) {
                    identifier.append(String.format("%02X%s", macbuffer[i], (i < macbuffer.length - 1) ? "-" : ""));
                }
            } else {
                return "---";
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return identifier.toString();
    }

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("IP address: " + address.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(address);
            System.out.println("MAC address: " + getMACIdentifier(network));
        } catch (IOException e) {
            System.out.print(e);
        }

    }
}