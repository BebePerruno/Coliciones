/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investigacionSprites;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 * Interface para trabajar con hilos y con numeros aleatorios a la vez.
 */
public abstract class HiloAleatorio extends Thread{
    
    public abstract void moverse();
    public abstract void crear(int numero);
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(numeroAleatorio(100,500));
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloAleatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
            moverse();
            crear(numeroAleatorio(-1,6));
        }
    }
    /**
     * El default se usa en las interfaces, nuevo truco.
     * @param Min
     * @param Max
     * @return 
     */
    public int numeroAleatorio(int Min, int Max){
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
}
