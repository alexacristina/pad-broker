package input_output;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Network implements IOInterface{
    InetAddress ip_address;
    int port;
    /**
     * @param ip_address
     * @param port
     */
    public Network(InetAddress ip_address, int port) {
        this.ip_address = ip_address; 
        this.port = port;
    }
    
    public String read () throws Exception {
        byte[] buffer = new byte[2048];
  
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        DatagramSocket socket = new DatagramSocket(null);
        socket.bind(new InetSocketAddress(this.port));
        socket.receive(packet);
        buffer = packet.getData();
        return new String(buffer);
    }
    
    public void write(String message) throws Exception {
        byte[] buffer = message.getBytes();
        InetAddress dst = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, dst, this.port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
        System.out.println(packet);
    }
}