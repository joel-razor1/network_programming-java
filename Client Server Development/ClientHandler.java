import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void sendResponse(Socket socket, int statusCode, String responseString) {
        String statusLine;
        String serverHeader = "Server: Webserver\r\n";
        String contentTypeHeader = "Content-Type: text/html\r\n";

        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {
            if (statusCode == 200) {
                statusLine = "HTTP/1.0 200 OK" + "\r\n";
                String contentlengthHeader = "Content-Length: " + responseString.length() + "\r\n";

                out.writeBytes(statusLine);
                out.writeBytes(serverHeader);
                out.writeBytes(contentTypeHeader);
                out.writeBytes(contentLengthHeader);
                out.writeBytes("\r\n");
                out.writeBytes(responseString);

            } else if (statusCode == 405) {
                statusLine = "HTTP/1.0 405 Method not allowed" + "\r\n";
                out.writeBytes("\r\n");

            } else {
                statusLine = "HTTP/1.0 404 Not Found" + "\r\n";
                out.writeBytes(statusLine);
                out.writeBytes("\r\n");
            }
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void handleRequest(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            String headerLine = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(headerLine);
            String httpMethod = tokenizer.nextToken();
            if (httpMethod.equals("GET")) {
                System.out.println("Get method processed");
                String httpQueryString = tokenizer.nextToken();
                StringBuilder responseBuffer = new StringBuilder();
                responseBuffer.append("<html><h1>WebServer Home Page...</h1><br>")
                        .append("<b>Welcome to my web server!</b><br>").append("<html>");
                sendResponse(socket, 200, responseBuffer.toString());
            } else {
                System.out.println("The HTTP method is not recognised.");
                sendResponse(socket, 405, "Method not allowed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("\nClientHandler Started for" + this.socket);
        handleRequest(this.socket);
        System.out.println("ClientHandler Terminated for" + this.socket + "\n");
    }
}