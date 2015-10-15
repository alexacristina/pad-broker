package broker;

import input_output.FileIO;
import input_output.FileIOInterface;
import input_output.Network;
import input_output.NetworkInterface;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.Future;


class CoreBroker { 
  
    public static void main(String[] args) {
        Broker broker = new Broker(5555);
        
        Thread thread = new Thread(broker);
        thread.start();
        System.out.println("Thread started");
        
    }

}