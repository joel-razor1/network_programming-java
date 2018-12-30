import java.net.*;
import java.rmi.*;

public class AddServer {
    public static void main(String args[])
    {
        try{
            AddServerImpl addServerImpl=new AddServerImpl();
            Naming.rebind("abcd",addServerImpl);

        }
        catch(Exception e){
            System.out.prinltn("Exception: "+e)
        }
    }
}