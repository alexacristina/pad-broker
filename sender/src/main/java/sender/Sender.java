package sender; 

import input_output.IOInterface;
import input_output.Network;
import input_output.FileIO;
import java.net.InetAddress;
        
public class Sender {
    static String host = "127.0.0.1";
    static int port = 55555;
    public static void main(String[] args) {
        try {
            String fileLocation = "src/main/resources/sendFile.xml";
            InetAddress address = InetAddress.getByName(host);
            IOInterface myio = new FileIO(fileLocation);
            Network mynetsend = new Network(address, port);
            String readString = myio.read();   
            mynetsend.write(readString);
            }
        catch(Exception e) {
            System.err.println(e.fillInStackTrace());
        }
    }
}