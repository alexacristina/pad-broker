package input_output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Scanner;
        
public class FileIO implements IOInterface {
    String location;
    public FileIO(String location){
        this.location = location;
    }
    
    public String read() throws Exception {
        String strFile="";
        strFile = new Scanner(new File(this.location)).useDelimiter("\\Z").next();
        return strFile;
    }
    
    public void write(String receivedpacket) throws Exception {
        File xmlFile = new File(this.location);
        if (!xmlFile.exists()) {
            xmlFile.getParentFile().mkdirs();
            xmlFile.createNewFile();
        }
        FileOutputStream foutstr = new FileOutputStream(xmlFile);
        FileWriter fileWriter = new FileWriter(xmlFile);
        fileWriter.write(receivedpacket);
        fileWriter.close();
        System.out.println("Done");
    }
}