package input_output;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.util.Scanner;
        
public class FileIO implements IOInterface {
    
    public FileIO(){
        
    }
    
    public String read(String location) throws Exception {
        
        String strFile="";
        strFile = new Scanner(new File(location)).useDelimiter("\\Z").next();
        return strFile;
        
    }
    
    public void write(String[] args) throws Exception {
        File xmlFile = new File("receiveFile1.xml");
        FileOutputStream foutstr = new FileOutputStream(xmlFile);
        BufferedOutputStream bufoutstr = new BufferedOutputStream(foutstr);
        bufoutstr.write(args[0].getBytes());
        bufoutstr.close();
    }
}