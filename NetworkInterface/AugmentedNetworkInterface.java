import java.io.*;
import java.net.*;
import java.util.*;

public class AugmentedNetworkInterface {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.printf("Name   Display Name\n");
            for (NetworkInterface element : Collections.list(interfaceEnum)) {
                System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
                Enumeration<InetAddress> addresses = element.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(addresses)) {
                    System.out.printf("   InetAddress: %s\n", inetAddress);
                }
            }
        } catch (SocketException e) {
            System.out.println(e);
        }
    }
}