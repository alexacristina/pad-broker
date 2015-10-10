package input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
        
public class IO implements IOInterface {
    
    public IO(){
        
    }
    
    public BufferedInputStream read() throws Exception {
        
        File xmlFile = new File("sendFile.xml");
        FileInputStream finputstr = new FileInputStream(xmlFile);
        BufferedInputStream binputstr = new BufferedInputStream(finputstr);
        return binputstr;
    }
    
    public void write(String[] args) throws Exception {
        File xmlFile = new File("receiveFile.xml");
        FileOutputStream foutstr = new FileOutputStream(xmlFile);
        BufferedOutputStream bufoutstr = new BufferedOutputStream(foutstr);
        bufoutstr.write(args[0].getBytes());
        bufoutstr.close();
        
    }
    

 
}