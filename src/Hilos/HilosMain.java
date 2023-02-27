/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *
 * @author Rafael
 */
public class HilosMain {
    
    public static void main(String []m){
        Contenedor contenedor=new Contenedor();
        HiloProductor productor=new HiloProductor(contenedor);
        HiloConsumidor consumidor=new HiloConsumidor(contenedor);
        productor.start();
        consumidor.start();
        
    }
    
}
