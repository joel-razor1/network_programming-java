
// Multicasting is a useful technique to use if you need to send messages to a
// group on a periodic basis.
// It uses a UDP server and one or more UDP clients.
// Multicasting will send an identical message to every member of a group.
// A group is identifiedby a multicast address.
// Clients must join the group before they can receive any multicast messages.

import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServer {
    public static void main(String[] args) {
        System.out.println("Multicast Time Server");
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket();
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();

                InetAddress group = InetAddress.getByName("224.0.0.0");
                DatagramPacket packet;

                packet = new DatagramPacket(buffer, buffer.length, group, 8888);
                serverSocket.send(packet);
                System.out.println("Time sent: " + dateText);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SocketException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}