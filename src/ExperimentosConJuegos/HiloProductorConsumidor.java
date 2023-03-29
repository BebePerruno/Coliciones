/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Hecho para usarse en juegos.
 * @author Jugador
 */
public abstract class HiloProductorConsumidor {
    public abstract void produciendo();
    public abstract void consumiendo(PosicionesXY cantidad_restante);
    
    private HiloProductor hProductor=new HiloProductor();
    private HiloConsumidor hConsumidor=new HiloConsumidor();
    
   public HiloProductorConsumidor(){
       hProductor.start();
       hConsumidor.start();
   }
   
   public HiloProductorConsumidor(int nuevo_nivel_de_consumo){
       nivelDeConsumo=nuevo_nivel_de_consumo;
       hProductor.start();
       hConsumidor.start();
   }
   
   public HiloProductorConsumidor(int nuevo_nivel_de_consumo, PosicionesXY nueva_cantidad){
       nivelDeConsumo=nuevo_nivel_de_consumo;
       cantidad=nueva_cantidad;
       hProductor.start();
       hConsumidor.start();
   }
   
   /**
    * Cantidad que se le va restando al recorrido.
    * Ya sea un ArrayList o una cantidad numerica.
    */
    private int nivelDeConsumo=1;
    
    public void setNivelDeConsumo(int nuevo_nivel_de_consumo){
        nivelDeConsumo=nuevo_nivel_de_consumo;
    }
    public int getNivelDeConsumo(){
        return nivelDeConsumo;
    }
se debe usar una propiedad booleana.
    private boolean esta_lleno=false;

    private PosicionesXY cantidad;

    public synchronized PosicionesXY getCantidad(){

        while(esta_lleno==false){
            try {
                wait();
            } catch (InterruptedException ex) { }
        }
        esta_lleno=false;
        notifyAll();
        return cantidad;
    }

    public synchronized void setCantidad(PosicionesXY nueva_cantidad){
        while(esta_lleno==true){
            try {
                wait();
            } catch (InterruptedException ex) { }
        }
        cantidad=nueva_cantidad;
        esta_lleno=true;
        notifyAll();
    }
    
   /**
    * Permite recorrer aleatoriamente los caminos he irlos guardando.
    */
    public class HiloProductor  extends Thread{

        /**
         * Permite ir explorando aleatoriamente.
         */
        @Override
        public void run(){
            while(true){
//              setProducto(1);
//                System.out.println("\n\nProduciendo " + cantidad + " productos.\n\n");
                produciendo();
                try {
    //                System.out.println((numeroAleatorio(1, 50)));
                    sleep(10 ); //
                } catch (InterruptedException ex) { }
            }
        } 
    }
    
    /**
     * Permite recorrer los caminos guardados.
     */
    public class HiloConsumidor extends Thread{

            /**
             * Permite recorrer los caminos guardados.
             */
        @Override
        public void run(){
            PosicionesXY consumiendo=getCantidad();
            while(true){
                try {
                    //            System.out.println("Consumiendo " + consumiendo + " productos");
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                consumiendo.setX(consumiendo.getX()-nivelDeConsumo);
                consumiendo(consumiendo);
                if(consumiendo.getX()>=getCantidad().getX()){
    //                System.out.println("Ya se consumió todo. Esperando la produccion.");
                    consumiendo=getCantidad();
                }
            }
        }
    }
    
}
