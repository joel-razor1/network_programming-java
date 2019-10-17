/* It is possible for more than one server to be running on a machine at any
   given time.
   When OS receives a request for service on a machine, it will also receive a
   port number.
   The port number will identify the server to where the request should be
   forwarded.
   A server is, thus, identified by its combination of ip address and port
   number.
   Typically, a client will issue a request to a server.
   The server will receive a requestand send back a response.
   The nature of request or response and the protocol used for communication is
   dependent on client or server.
   Sometimes a well documented protocol, such as HTTP is used.*/

import java.io.*;
import java.net.*;

public class echoserver {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4000);
            System.out.println("Server is ready");

            Socket socket = ss.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());

            dis.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
