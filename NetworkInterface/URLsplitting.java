import java.io.*;
import java.net.*;
import java.util.*;

public class URLsplitting {

    private static void displayURL(URL url) {
        System.out.println("URL: " + url);
        System.out.printf("    Protocol: %-32s Host: %-32s\n", url.getProtocol(), url.getHost());
        System.out.printf("    Port: %-32d     Path: %-32s\n", url.getPort(), url.getPath());
        System.out.printf("    Reference %-32s     File: %-32s \n", url.getRef(), url.getFile());
        System.out.printf("    Authority: %-32s    Query: %-32s \n", url.getAuthority(), url.getQuery());
        System.out.println("    UserInfo: " + url.getUserInfo());
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.packtpub.com/books/content/support");
            displayURL(url);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}