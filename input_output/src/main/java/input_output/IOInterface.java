package input_output; 

import java.io.BufferedInputStream;

public interface IOInterface {
    
    
    public String read(String location) throws Exception;
        
    public void write(String[] args) throws Exception;
}