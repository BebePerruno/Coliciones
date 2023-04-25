/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exagonal;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jugador
 */
public abstract class HiloDelJuego extends Thread {

    public  abstract void generando();
    private int minutoContador=0;
    public abstract void unMinuto();
    public abstract void medioMinuto();
    @Override
    public void run() {
        while(true){
            try{
            generando();
            minutoContador+=1;
            if(minutoContador==5 || minutoContador==10){
                medioMinuto();
                notifyAll();
            }
            if(minutoContador==10){
                unMinuto();
                minutoContador=0;
                notifyAll();
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
//                Logger.getLogger(HiloDelJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            }catch(Exception e){}
        }
    }
    
}
