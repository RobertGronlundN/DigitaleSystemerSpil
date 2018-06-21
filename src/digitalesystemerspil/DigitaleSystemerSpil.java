/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalesystemerspil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Robert
 */
public class DigitaleSystemerSpil {

    /**
     * @param args the command line arguments
     */
    
    
    
    static int key = 0;
    static int p1_score = 0;
    static int p2_score = 0;
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1260,820);
        f.setBackground(Color.WHITE);
        f.setVisible(true);
        Graphics g = f.getGraphics();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Set sample rate: ");
        int sampleRate = 0;
        //sampleRate = keyboard.nextInt();
        
        g.setColor(Color.black);
        g.fillRect(620, 0, 20, 150);
        g.setColor(Color.black);
        g.fillRect(620, 310, 20, 100);
        g.setColor(Color.black);
        g.fillRect(620, 570, 20, 150);
        g.setColor(Color.black);
        g.drawLine(0, 720, 1260, 720);
        g.setColor(Color.black);        
        g.drawString("Player 1: " + p1_score, 200, 750);
        g.setColor(Color.black);        
        g.drawString("Player 2: " + p2_score, 1000, 750);
        
        new Input(sampleRate);
        PlayerOne p1 = new PlayerOne(g,  50, 50);  
        PlayerTwo p2 = new PlayerTwo(g, 1160, 50);
        
        
        f.addKeyListener(new KeyListener() {            
            @Override
            public void keyPressed(KeyEvent ke) {
                key = ke.getKeyCode();
                g.setColor(Color.white);        
                g.drawString("Player 2: " + p2_score, 1000, 750);
                g.setColor(Color.white);        
        g.drawString("Player 1: " + p1_score, 200, 750);
                gameplay(p1,p2);  
                g.setColor(Color.black);        
                g.drawString("Player 2: " + p2_score, 1000, 750);
                g.setColor(Color.black);        
                g.drawString("Player 1: " + p1_score, 200, 750);
            }

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
                
    }
    
    public static void gameplay(PlayerOne p1, PlayerTwo p2){
        //System.out.println(p1.y);
        //System.out.println(p2.y);
        
        switch (key){
            case 65:
                if ((p1.y > 125 && p1.y < 285) || (p1.y > 385 && p1.y < 545) ){ // If shot is not on wall
                    if (p1.y >= p2.y - 25 && p1.y <= p2.y + 25){                // and on other player
                        p2.dead();                                              // it's a kill                        
                        p1_score += 1;
                    }
                }
                break;
            case 76:
                if ((p2.y > 125 && p2.y < 285) || (p2.y > 385 && p2.y < 545) ){ // If shot is not on wall
                    if (p2.y >= p1.y - 25 && p2.y <= p1.y + 25){                // and on other player
                        p1.dead();                                              // it's a kills
                        p2_score += 1;
                    }
                }
                break;
            default:
                break;
        }
        
        
        
    }
    
}
