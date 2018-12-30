import java.rmi.*;
import java.io.*;

public class AddClient {
    public static void main(String args[]) {
        try {
            String addServerURL = "rmi://localhost/abcd";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the first number: ");
            Double d1 = Double.parseDouble(br.readLine());
            System.out.prinltn("Enter  the second number: ");
            Double d2 = Double.parseDouble(br.readLine());
            System.out.println("The sum is: " + addServerIntf.add(d1 + d2));
        } catch (Exception e) {
            System.out.prinltn("Exception: " + e);
        }
    }
}