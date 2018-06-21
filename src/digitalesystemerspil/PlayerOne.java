/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalesystemerspil;
import java.awt.*;
/**
 *
 * @author Robert
 */
public class PlayerOne implements Runnable 
{
    int x, y;
    Graphics g;
    
    
    public PlayerOne (Graphics g1, int x1, int y1 )
    {
        g = g1;
        x = x1;
        y = y1;
       
        Thread t = new Thread(this);
        t.start();
        
    }
    
    public void run()
    {
        while(true)
            {
                    // Tegn bolden over med hvid på den gamle position
                    g.setColor(Color.WHITE);                    
                    g.drawRect((int) x, (int) y, 50, 50);
                    g.drawRect((int) x + 50, (int) y + 20, 10, 10);

                    //System.out.println("Joy:  " + Input.data_I);
                                        
                    // Opdater positionen med farten
                    double move = 0.1*(Input.data_I - 126);
                    y = y + (int)move;

                    if (y >= 645) {
                        y = 645;
                    }
                    if (y <= 50){
                        y = 50;
                    }
                    
                    // Tegn bolden med sort på den nye position
                    g.setColor(Color.BLACK);
                    g.drawRect((int) x, (int) y, 50, 50);
                    g.drawRect((int) x + 50, (int) y + 20, 10, 10);
                    
                    
                    // Vent lidt
                    try { Thread.sleep(10); } catch (Exception e) {}
            }
    } 
    
    public void dead(){
        g.setColor(Color.WHITE);                    
        g.drawRect((int) x, (int) y, 50, 50);
        g.drawRect((int) x + 50, (int) y + 20, 10, 10);
        
        y = 310;
        
    }
        
}
