import java.io.*;
import java.net.*;
import java.util.*;

public class HttpURLConnectionExample {
    public static void main(String[] args) throws Exception {
        HttpURLConnectionExample http = new HttpURLConnectionExample();
        http.sendGet();
    }

    private void sendGet() throws Exception {
        String query = "http://www.google.com/search?=q=java+sdk&ie=utf-8&oe=utf-8";
        URL url = new URL(query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code:" + responseCode);
        if (responseCode == 200) {
            String response = getResponse(connection);
            System.out.println("response: " + response.toString());
        } else {
            System.out.println("Bad response Code:" + responseCode);
        }
    }

    private String getResponse(HttpURLConnection connection) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}