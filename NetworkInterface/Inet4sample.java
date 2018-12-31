import java.io.*;
import java.net.*;
import java.util.*;

public class Inet4sample {
    public static void main(String[] args) {
        try {
            Inet4Address address;
            address = (Inet4Address) InetAddress.getByName("www.google.com");
            System.out.println(address);
            address = (Inet4Address) Inet4Address.getByName("www.google.com");
            System.out.println(address);
            // Special IPv4 address
            // Unspecified IPv4
            address = (Inet4Address) Inet4Address.getByName("0.0.0.0");
            System.out.println(address.isAnyLocalAddress());
            // Loopback adrress
            address = (Inet4Address) Inet4Address.getByName("127.0.0.1");
            System.out.println(address.isLoopbackAddress());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}