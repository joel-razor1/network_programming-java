import java.io.*;
import java.net.*;

public class ClientJo1 {
    public static void main(String args[]) throws Exception {
        Socket cs = new Socket("localhost", 4000);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
        System.out.println("Enter text...");
        System.out.println("If client 'quit'type exit.");
        String s1, s4 = null;
        while (!(s1 = kb.readLine()).equals("exit")) {
            dos.writeBytes(s1 + "\n");
            s4 = br.readLine();
            System.out.println("Server said: " + s4);
            System.out.println("Enter text");
        }
        System.out.println("Terminated");
        cs.close();
        dos.close();
        kb.close();
    }
}
