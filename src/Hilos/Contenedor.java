/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Contenedor para usarse en 2 hilos diferentes.
 * @author Rafael
 */
public class Contenedor {
    private boolean esta_lleno=false;
    
    private int producto=0;
    
    public synchronized int getProducto(){
        
        while(esta_lleno==false){
            try {
                wait();
            } catch (InterruptedException ex) { }
        }
        esta_lleno=false;
        notifyAll();
        return producto;
    }
    
    public synchronized void setProducto(int nuevo_producto){
        while(esta_lleno==true){
            try {
                wait();
            } catch (InterruptedException ex) { }
        }
        producto=nuevo_producto;
        esta_lleno=true;
        notifyAll();
    }
}
