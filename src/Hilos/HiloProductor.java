/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class HiloProductor  extends Thread{
    private Contenedor contenedor=null;
    
    public HiloProductor(Contenedor nuevo_contenedor){
        contenedor=nuevo_contenedor;
    }
    
    @Override
    public void run(){
        while(true){
            contenedor.setProducto(3);
            System.out.println("\n\nProduciendo " + 3+ " productos.\n\n");
            
            try {
//                System.out.println((numeroAleatorio(1, 50)));
                sleep(50 );
            } catch (InterruptedException ex) { }
        }
    } 
    
    private int numeroAleatorio(int Min, int Max){
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
}
