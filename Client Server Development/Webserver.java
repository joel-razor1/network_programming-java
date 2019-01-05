import java.io.*;
import java.util.*;
import java.net.*;

public class Webserver {
    public Webserver() {
        System.out.println("Webserver started");
        try (ServerSocket serversocket = new ServerSocket(3000)) {
            while (true) {
                System.out.println("Waiting for the client request");
                Socket remote = serversocket.accept();
                System.out.println("Connection made");
                new Thread(new ClientHandler(remote)).start();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Webserver();
    }
}