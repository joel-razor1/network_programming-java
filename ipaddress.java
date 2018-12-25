import java.io.*;
import java.net.*;

import javax.print.event.PrintJobListener;

public class ipaddress {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.packtpub.com");
            System.out.println(ip);
            System.out.println("Cannonical Host Name: " + ip.getCanonicalHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
            System.out.println("Host Name: " + ip.getHostName());
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

}

// The host name is the real name the server has. A canonical name is a name
// that the host is known by, but that the host is not actually called.