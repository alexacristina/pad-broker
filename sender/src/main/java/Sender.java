package Sender; 

import input_output.IOInterface;
import input_output.NetworkInterface;
import input_output.Network;
import input_output.IO;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

        
public class Sender {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            IOInterface myio = new IO();
            NetworkInterface mynetsend = new Network(addr, 5555);
            BufferedInputStream inputstream = myio.read();   
            mynetsend.sendPacket(new String[]{inputstream.toString()});
            }
        catch(Exception e) {
            System.out.println("The file couldn't be read or it doesn't exist");
            System.err.println(e);
        }
    }
}