
// A simply way of accessing a server is to use the URLConnection class.
// This class represents a connection between an applicant and a URL instance.
// A URL represents a resource on the internet.
import java.io.*;
import java.net.*;

public class URLinstance {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection urlconnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
