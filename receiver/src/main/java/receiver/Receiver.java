package receiver;

import input_output.FileIOInterface;
import input_output.FileIO;
import input_output.Network;
import input_output.NetworkInterface;

import java.net.InetAddress;

class Receiver {

	public static void main(String[] args) { 
            System.out.println("Hello, I am receiver");
        while(true) {
            try {
                String location = "src/main/resources/receivedXML.xml";
                InetAddress address= InetAddress.getByName("127.0.0.1");
                NetworkInterface networkInterface = new Network(address, 5555);
                String receivedPacket = networkInterface.receivePacket();
                System.out.println("Received packet:" + receivedPacket);
                FileIOInterface outputInterface = new FileIO();
                outputInterface.write(receivedPacket, location);
                System.out.println(networkInterface.toString());
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
    }
        
}