import java.io.*;
import java.net.*;
import java.util.*;
import com.sun.net.httpserver.*;

public class MyHTTPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("MyHTTPServer Started");
        HttpServer server = new HttpServer.create(new InetSocketAddress(3000), 0);
        server.createContext("/index", new IndexHandler());
        server.start();
    }
}