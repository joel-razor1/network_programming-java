import java.io.*;
import java.net.*;
import javax.net.ssl.SSLSocketFactory;
import java.util.*;

public class SSLClientSocket {
    public static void main(String[] args) throws Exception {
        System.out.println("SSLClientSocket started");
        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (Socket socket = sf.createSocket("localhost", 8000);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine();
                if ("quit".equalsIgnoreCase(inputLine)) {
                    break;
                }
                out.println(inputLine);
                System.out.println("Server Response: " + br.readLine());
            }
            System.out.println("SSLServerSocket Terminated.");
        }
    }
}