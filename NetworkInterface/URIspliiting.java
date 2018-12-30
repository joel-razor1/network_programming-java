import java.io.*;
import java.net.*;
import java.util.*;

public class URIspliiting {

    private static void displayURI(URI uri) {
        System.out.println("getAuthority: " + uri.getAuthority());
        System.out.println("getScheme: " + uri.getScheme());
        System.out.println("getSpecificPart: " + uri.getSchemeSpecificPart());
        System.out.println("getHost: " + uri.getHost());
        System.out.println("getPath: " + uri.getPath());
        System.out.println("getQuery: " + uri.getQuery());
        System.out.println("getFragment: " + uri.getFragment());
        System.out.println("getUserInfo: " + uri.getUserInfo());
        System.out.println("normalize: " + uri.normalize());
    }

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.packtpub.com/books/content/support");
            displayURI(uri);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }
}