import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.*;

public class TimeClient {
    public static void main(String[] args) {
        SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int bytesRead = socketChannel.read(byteBuffer);
            while (bytesRead > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                System.out.println();
                bytesRead = socketChannel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}