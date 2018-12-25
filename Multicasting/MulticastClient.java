
// In order to receive a message, the client must use the same group address and
// port number.
// Before it can receive messages,it must join the group using the joinGroup
// method.

import java.io.*;
import java.net.*;

public class MulticastClient {
    public static void main(String[] args) {
        System.out.println("Multicast Time client");
        try (MulticastSocket socket = new MulticastSocket(8888)) {
            InetAddress group = InetAddress.getByName("224.0.0.0");
            socket.joinGroup(group);
            System.out.println("Multicast group Joined.");
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            for (int i = 0; i < 5; i++) {
                socket.receive(packet);
                String received = new String(packet.getData());
                System.out.println(received.trim());
            }

            socket.leaveGroup(group);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Multicast Time client Terminated.");
    }
}