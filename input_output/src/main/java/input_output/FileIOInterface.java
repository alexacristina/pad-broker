package input_output; 

import java.io.BufferedInputStream;

public interface FileIOInterface {
    
    
    public String read(String location) throws Exception;
        
    public void write(String receivedpacket, String location) throws Exception;
}