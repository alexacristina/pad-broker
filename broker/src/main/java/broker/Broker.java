/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import input_output.FileIO;
import input_output.IOInterface;
import input_output.Network;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexacris
 */
public class Broker {
    public static int port;
    
    public Broker(int port) { 
        Broker.port = port;
    }
    
    public static void main(String[] args) throws IOException {
        
        final Broker broker = new Broker(55555); 
        ExecutorService executorservice = Executors.newCachedThreadPool();
        executorservice.execute(new Runnable() {
            public void run() {
                try {
                    broker.receiveMessage();
                    broker.sendMessage();
                } catch (IOException ex) {
                    Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        executorservice.shutdown();
    }
    
    public void receiveMessage() throws IOException {
        try {
            InetAddress ip_address = InetAddress.getByName("127.0.0.1");
            String fileLocation = "src/main/resources/fileToSend.xml";
            IOInterface writeToFileInterface = new FileIO(fileLocation);
            Network receiveNetwork = new Network(ip_address, port);
            String receivedPacket = receiveNetwork.read();
            writeToFileInterface.write(receivedPacket);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    public void sendMessage() throws IOException {
        try {
            InetAddress ip_address = InetAddress.getByName("127.0.0.1");
            String fileToSend = "src/main/resources/fileToSend.xml";
            IOInterface readFromFile = new FileIO(fileToSend);
            Network sendNetwork = new Network(ip_address, 55556);
            String stringRead = readFromFile.read();
            System.out.println("Read string" + stringRead);
            sendNetwork.write(stringRead);
        }
        catch (Exception ex) {
             Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
