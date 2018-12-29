import java.io.*;
import java.net.*;
import java.util.*;

public class NetworkInterfacejava {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();
            System.out.printf("Name      Display name\n");
            for (NetworkInterface element : Collections.list(interfaceEnum)) {
                System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
            }
        } catch (SocketException e) {
            System.out.println(e);
        }

    }
}
