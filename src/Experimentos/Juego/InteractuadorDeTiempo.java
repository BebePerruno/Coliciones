/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Rafael
 * No sirve para juegos porque no usa hilos.
 */
public abstract class InteractuadorDeTiempo {
    
    public InteractuadorDeTiempo(int nuevo_intervalo_de_tiempo){
        intervalo=nuevo_intervalo_de_tiempo;
        timer = new Timer(intervalo, new ControladorT1());
        timer2 = new Timer(10, new ControladorT2());
//                timer.setRepeats(true);
//                timer.setCoalesce(true);
            timer.start();
    }
    
    public InteractuadorDeTiempo(){
        intervalo=getIntervaloDeTiempo();
        timer = new Timer(intervalo, new ControladorT1());
        timer2 = new Timer(10, new ControladorT2());
//                timer.setRepeats(true);
//                timer.setCoalesce(true);
            timer.start();
    }
    private int intervalo=0;

    public abstract int getIntervaloDeTiempo();
    
    public void setIntervalo(int nuevo_intervalo_de_tiempo){
        intervalo=nuevo_intervalo_de_tiempo;
    }
    
    public int getIntervalo(){
        return intervalo;
    }
    
    public void stop(){
        timer.stop();
        timer2.stop();
    }
    public void start(){
        timer.start();
    }
    
    private Timer timer ;
    private Timer timer2 ;
     public abstract void eventoAcciones();
    
    private class ControladorT1 implements ActionListener{
        public ControladorT1(){
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            for(int i=0; i<5;i++){
                eventoAcciones();
                try {
                    sleep(400);
                } catch (InterruptedException ex) {
                    Logger.getLogger(InteractuadorDeTiempo.class.getName()).log(Level.SEVERE, null, ex);
                }
//               System.out.println("Reloj uno = " + i);
           }
           timer2.start();
        }
        
    }
    
    private class ControladorT2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("\n\nTiempo 2 activado\n\n");
            timer2.stop();
            timer.start();
        }
        
    }
}
