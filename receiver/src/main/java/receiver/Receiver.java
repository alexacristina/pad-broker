package receiver;

import input_output.IOInterface;
import input_output.FileIO;
import input_output.Network;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;

class Receiver {

    public static void main(String[] args) throws Exception { 
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            public void run() {
                try {
                    String location = "src/main/resources/receivedXML.xml";
                    InetAddress address= InetAddress.getByName("127.0.0.1");
                    Network networkInterface = new Network(address, 55556);
                    String receivedPacket = networkInterface.read();
                    System.out.println("Received packet:" + receivedPacket);
                    IOInterface outputInterface = new FileIO(location);
                    outputInterface.write(receivedPacket);
                    System.out.println(networkInterface.toString());
                }
                catch (IOException e) {
                    System.err.println(e);
                } 
                catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
        executorService.shutdown();
    }     
}