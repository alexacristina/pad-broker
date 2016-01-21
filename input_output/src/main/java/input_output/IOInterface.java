package input_output; 

import java.io.BufferedInputStream;

public interface IOInterface {
    
    
    public String read() throws Exception;
        
    public void write(String receivedpacket) throws Exception;
}