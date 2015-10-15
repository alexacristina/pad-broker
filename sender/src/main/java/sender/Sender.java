package sender; 

import input_output.FileIOInterface;
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
            String fileLocation = "src/main/resources/sendFile.xml";
            InetAddress address = InetAddress.getByName("127.0.0.1");
            FileIOInterface myio = new FileIO();
            NetworkInterface mynetsend = new Network(address, 5555);
            String readString = myio.read(fileLocation);   
            mynetsend.sendPacket(readString);
            }
        catch(Exception e) {
            System.err.println(e.fillInStackTrace());
        }
    }
}