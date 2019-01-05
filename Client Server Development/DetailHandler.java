import java.io.*;
import java.net.*;
import java.util.*;
import com.sun.net.httpserver.*;

static class DetailHandler implements HttpHanddler {

    @Override
    public void handle(HttpExchange exchange) throws Exception {
        server.createContext("/index", new DetailHandler());
        Headers requestHeaders = exchange.getRequestHeaders();
        Set<String> keySet = requestHeaders.keySet();
        for (String key : keySet) {
            List values = requestHeaders.get(key);
            String header = key + "=" + values.toString() + "\n";
            System.out.print(header);
        }
    }
}