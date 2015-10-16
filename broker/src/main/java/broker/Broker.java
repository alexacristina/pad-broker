/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import input_output.FileIO;
import input_output.FileIOInterface;
import input_output.Network;
import input_output.NetworkInterface;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexacris
 */
public class Broker implements Runnable {
    public static int port;
    
    public Broker(int port) {
        this.port=port;
    }
    
    public void receiveMessage() throws IOException {
        try {
            InetAddress ip_address = InetAddress.getByName("127.0.0.1");
            String fileLocation = "src/main/resources/fileToSend.xml";
            FileIOInterface writeToFileInterface = new FileIO();
            NetworkInterface receiveNetwork = new Network(ip_address, port);
            String receivedPacket = receiveNetwork.receivePacket();
            System.out.println("received packet =" + receivedPacket);
            writeToFileInterface.write(receivedPacket, fileLocation);
            System.out.println("Done printing here");
        } catch (Exception ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage() throws IOException {
        try {
            InetAddress ip_address = InetAddress.getByName("127.0.0.1");
            String fileToSend = "src/main/resources/fileToSend.xml";
            FileIOInterface readFromFile = new FileIO();
            NetworkInterface sendNetwork = new Network(ip_address, port);
            String stringRead = readFromFile.read(fileToSend);
            sendNetwork.sendPacket(stringRead);
        }
        catch (Exception ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            this.receiveMessage();
        } catch (IOException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
