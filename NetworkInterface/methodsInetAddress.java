import java.io.*;
import java.net.*;
import java.util.*;

public class methodsInetAddress {

    private static void displayInetAddressInformation(InetAddress address) {
        System.out.println(address);
        System.out.println("Cannonical Host Name: " + address.getCanonicalHostName());
        System.out.println("Host Name: " + address.getHostName());
        System.out.println("Hot address: " + address.getHostAddress());
    }

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.packtpub.com");
            displayInetAddressInformation(address);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}