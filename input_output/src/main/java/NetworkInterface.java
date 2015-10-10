package input_output;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexacris
 */
public interface NetworkInterface {
    
    String receivePacket (int port, int length) throws Exception;
    void sendPacket(String args[]) throws Exception ;
    
}
