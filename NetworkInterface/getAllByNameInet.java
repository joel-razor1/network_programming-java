import java.io.*;
import java.net.*;
import java.util.*;

public class getAllByNameInet {
    public static void main(String[] args) {
        try {
            InetAddress names[] = InetAddress.getAllByName("www.google.com");
            for (InetAddress element : names) {
                System.out.println(element);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}