package receiver;

import input_output.IOInterface;
import input_output.FileIO;
import input_output.Network;
import input_output.NetworkInterface;

import java.net.InetAddress;

class Receiver {

	public static void main(String[] args) { 
            System.out.println("Hello, I am receiver");
        while(true) {
            try {
                InetAddress address= InetAddress.getByName("127.0.0.1");
                NetworkInterface myinterface = new Network(address, 5555);
                String receivedpacket = myinterface.receivePacket(5555);
                System.out.println("Received packet:" + receivedpacket);
                IOInterface output = new FileIO();
                output.write(new String[] {myinterface.toString()});
                System.out.println(myinterface.toString());
            }
            catch (Exception e) {

            }
        }
    }
        
}