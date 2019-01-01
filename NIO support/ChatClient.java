import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChatClient {
    public ChatClient() {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            System.out.println("Connected to the chat server.");
            String message;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Waiting for message from the server...");
                System.out.println("Waiting for message from the server...");
                System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(socketChannel));
                System.out.print("> ");
                message = scanner.nextLine();
                if (message.equalsIgnoreCase("quit")) {
                    HelperMethods.sendFixedLengthMessage(socketChannel, "Client Terminating");
                    break;
                }
                HelperMethods.sendFixedLengthMessage(socketChannel, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}