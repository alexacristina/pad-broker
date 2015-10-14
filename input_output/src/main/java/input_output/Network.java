package input_output;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.lang.String;


/**
 *
 * @author alexacris
 */
public class Network implements NetworkInterface{

    /**
     * @param args the command line arguments
     */
    public Network(InetAddress ip_address, int port) {
        
    }
    
    public String receivePacket (int port) throws Exception {
        byte[] buffer = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        DatagramSocket socket = new DatagramSocket(port);
        socket.receive(packet);
        buffer = packet.getData();
        return new String(buffer);
    }
    
    public void sendPacket(String message) throws Exception {
        byte[] buffer = message.getBytes();
        InetAddress dst = InetAddress.getLocalHost();
        int port = 5555;
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, dst, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }
    
    
        // TODO code application logic here
    
}