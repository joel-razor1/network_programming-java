import java.io.*;
import java.net.*;
import java.util.*;
import com.sun.net.httpserver.*;

static class IndexHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println(exchange.getRemoteAddress());
        String response = getResponse();
        exchange.sendResponseHeaders(200, response.length());
        OutputStream out = exchange.getResponseBody();
        out.write(response.toString().getBytes());
        out.close();
    }

    public String getResponse() {
        StringBuilder responseBuffer = new StringBuilder();
        responseBuffer.append("<html><h1>HTTPServer Home Page....</h1><br>")
                .append("<b>Welcome to the new and improved web" + "server!</b><BR>").append("</html>");
        return responseBuffer.toString();
    }
}