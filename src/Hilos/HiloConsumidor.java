/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *
 * @author Rafael
 */
public class HiloConsumidor extends Thread{
    private Contenedor contenedor=null;
    
    public HiloConsumidor(Contenedor nuevo_contenedor){
        contenedor=nuevo_contenedor;
    }
    
    @Override
    public void run(){
        int consumiendo=contenedor.getProducto();
        while(true){
            System.out.println("Consumiendo " + consumiendo + " productos");
            consumiendo--;
            if(consumiendo<=0){
                consumiendo=contenedor.getProducto();
            }
        }
    }
}
