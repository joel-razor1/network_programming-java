import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import javax.net.ssl.SSLServerSocketFactory;

public class SSLServerSocket {
    public static void main(String[] args) {
        try {
            SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket serversocket = ssf.createServerSocket(8000);
            System.out.println("SSLServersocket started");
            try (Socket socket = serversocket.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Client Socket created.");
                String line = null;
                while (((line = br.readLine()) != null)) {
                    System.out.println(line);
                    out.println(line);
                }
                br.close();
                System.out.println("SSLServerSocket Terminated");
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}