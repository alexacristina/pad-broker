package input_output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Scanner;
        
public class FileIO implements FileIOInterface {
    
    public FileIO(){
        
    }
    
    public String read(String location) throws Exception {
        
        String strFile="";
        strFile = new Scanner(new File(location)).useDelimiter("\\Z").next();
        return strFile;
        
    }
    
    public void write(String receivedpacket, String location) throws Exception {
        File xmlFile = new File(location);
        if (!xmlFile.exists()) {
            xmlFile.createNewFile();
        }
        FileOutputStream foutstr = new FileOutputStream(xmlFile);
        FileWriter fileWriter = new FileWriter(xmlFile);
        fileWriter.write(receivedpacket);
        fileWriter.close();
        System.out.println("Done");
    }
}