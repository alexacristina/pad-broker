package input_output; 

import input_output.IO;
import java.io.BufferedInputStream;

public interface IOInterface {
    
    
    public BufferedInputStream read() throws Exception;
        
    public void write(String[] args) throws Exception;
}