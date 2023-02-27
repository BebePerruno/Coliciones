/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Rafael
 */
public class Tiempo  extends JFrame{
    
    public static void main(String []m){
            new Tiempo();
            
    }
    
    
    private Timer timer ;
    private Timer timer2 ;
    
    private class ControladorT1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            for(int i=0; i<5;i++){
                try {
                    sleep(400);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
                }
               System.out.println("Reloj uno = " + i);
           }
           timer2.start();
        }
        
    }
    
    private class ControladorT2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("\n\nTiempo 2 activado\n\n");
            timer2.stop();
            timer.start();
        }
        
    }
    
    public Tiempo(){
        this.setBounds(100, 100, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Objeto Timer");
        this.setVisible(true);
         timer = new Timer(500, new ControladorT1());
         timer2 = new Timer(1000, new ControladorT2());
//                timer.setRepeats(true);
//                timer.setCoalesce(true);
                timer.start();
    }
    
}
