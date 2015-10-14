package sender; 

import input_output.IOInterface;
import input_output.NetworkInterface;
import input_output.Network;
import input_output.FileIO;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

        
public class Sender {
    public static void main(String[] args) {
        System.out.println("just entered Sender");
        try {
            String location = "src/main/resources/sendFile.xml";
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            IOInterface myio = new FileIO();
            NetworkInterface mynetsend = new Network(addr, 5555);
            String readString = myio.read(location);   
            mynetsend.sendPacket(readString);
            }
        catch(Exception e) {
            System.out.println("The file couldn't be read or it doesn't exist");
            System.err.println(e);
        }
    }
}