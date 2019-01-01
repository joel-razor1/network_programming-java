import java.io.*;
import java.net.*;
import java.util.*;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChatServer {
    public ChatServer() {
        System.out.println("Chat Server Started.");
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(5000));
            boolean running = true;
            while (running) {
                System.out.println("Waiting for request.....");
                SocketChannel socketChannel = serverSocketChannel.accept();

                System.out.println("Connected to Client.");
                String message;
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("> ");
                    message = scanner.nextLine();
                    if (message.equalsIgnoreCase("quit")) {
                        HelperMethods.sendFixedLengthMessage(socketChannel, "Server Terminating");
                        running = false;
                        break;
                    } else {
                        HelperMethods.sendFixedLengthMessage(socketChannel, message);
                        System.out.println("Waiting for message from client...");
                        System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(socketChannel));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}