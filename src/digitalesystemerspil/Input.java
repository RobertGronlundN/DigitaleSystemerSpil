/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalesystemerspil;

import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Robert
 */
public class Input implements Runnable {
    
    SerialPort comPort = SerialPort.getCommPorts()[0];
    static int data_I   = 0;
    static int data_II  = 0;
    int sampleRate = 0;
    
    public Input(int rate)
    {
        sampleRate = rate;
        Thread t = new Thread(this);
        t.start();
    }
    
    public void run()
    {
        comPort.openPort();
        comPort.setBaudRate(19200);
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
        InputStream in = comPort.getInputStream();
        OutputStream out = comPort.getOutputStream();
        try
        {
            for (int i = 0 ; i < 1000000 ; i++) {
                out.write(1);
                
                data_I = ((int)in.read());
                    
                out.write(2);
                
                data_II = ((int)in.read());
                
                try { Thread.sleep(sampleRate); } catch (Exception e) {};
                
            }
           in.close();
           out.close();
        } catch (Exception e) { e.printStackTrace(); }
        comPort.closePort();
    }
    
    
    
}
