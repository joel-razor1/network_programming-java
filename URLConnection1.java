
// The ReadeableByteChannel instance allows us to read from the site using its read method.
// A ByteBuffer instance receives data from the channel and is used as the argument of the read method.
// The buffer created holds 64 bytes at a time.
// The read method returns the number of bytes read.
// The ByteBuffer class array method returns an array of bytes, which is used as the argument of the string class constructor
// The clear method is used to reset the buffer so that it can be used again.
// The following program is not executable. It will be rectified soon.

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;

public class URLConnection1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection urlconnection = url.openConnection();
            InputStream inputstream = urlconnection.getInputStream();
            ReadableByteChannel channel = Channels.newChannel(InputStream);
            ByteBuffer buffer = ByteBuffer.allocate(64);
            String line = null;
            while (channel.read(buffer) > 0) {
                System.out.println(new String(buffer.array()));
                buffer.clear();
            }
            channel.close();
        } catch (IOException e) {
            println(e);
        }
    }
}
