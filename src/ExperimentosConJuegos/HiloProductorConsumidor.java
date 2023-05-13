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
    
    public void intervalo(int nuevo_intervalo_para_el_sleep){
        try {
                sleep(nuevo_intervalo_para_el_sleep);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * Sucede cuando se esta produciendo, se recomienda usarlo como principal y dejar los demas como secundarios.
     */
    public abstract void produciendo();
    /**
     * Sucede cuando se han gastado los recursos.
     * En esta situacion se indica con un boolean.
     * @param llenar_recipiente Un boolean true para indicar que se debe llenar el recipiente.
     */
    public abstract void gastado(boolean llenar_recipiente);
    
    /**
     * Sucede en todo momento, es igual que el metoo run de un hilo.
     * En el hilo productor.
     */
    public abstract void eventoProductor();
    /**
     * Sucede en todo momento, es igual que el metoo run de un hilo.
     * En el hilo consumidor.
     */
    public abstract void eventoConsumidor();
    
    private HiloProductor hProductor=new HiloProductor();
    private HiloConsumidor hConsumidor=new HiloConsumidor();
    
   public HiloProductorConsumidor(){
       hProductor.start();
       hConsumidor.start();
   }
   
   public HiloProductorConsumidor(boolean llenar_recipiente){
       recipienteLleno=llenar_recipiente;
       hProductor.start();
       hConsumidor.start();
   }
   
   public HiloProductorConsumidor(boolean llenar_recipiente, boolean estado_del_recipiente){
       recipienteLleno=llenar_recipiente;
       recipiente=estado_del_recipiente;
       hProductor.start();
       hConsumidor.start();
   }
   
   /**
    * Cantidad que se le va restando al recorrido.
    * Ya sea un ArrayList o una cantidad numerica.
    */
    private boolean recipienteLleno=true;
    
    public void setRecipienteLleno(boolean llenar_recipiente){
        recipienteLleno=llenar_recipiente;
    }
    public boolean getRecipienteLleno(){
        return recipienteLleno;
    }
//    private boolean esta_lleno=false;

    private boolean recipiente;

    /**
     * La variable recipienteLleno se basea en el exterior por medio del set get.
     * @return Retorna un false.
     */
    public synchronized boolean getRecipiente(){
        while(recipienteLleno==true){
            try {
                sleep(1000);
//                wait(500);
            } catch (InterruptedException ex) { }
        }
        recipiente=false;
        notifyAll();
        return recipiente;
    }

    /**
     * La variable recipienteLleno se llena en el exterior por medio del set get.
     */
    public synchronized void setRecipiente(){//(boolean nueva_cantidad){
        while(recipienteLleno==false){
            try {
//                wait(150);
                sleep(500);
            } catch (InterruptedException ex) { }
        }
        recipiente=true;
//        recipienteLleno=true; Se realiza en el exterior.
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
                eventoProductor();
//              setProducto(1);
//                System.out.println("\n\nProduciendo " + cantidad + " productos.\n\n");
                produciendo();
                
//                try {
//    //                System.out.println((numeroAleatorio(1, 50)));
//                    sleep(10 ); //
//                } catch (InterruptedException ex) { }
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
//            boolean comiendo=getLlenarlo();
            while(true){
//                try {
//                    //            System.out.println("Consumiendo " + consumiendo + " productos");
//                    sleep(10);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(HiloProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                comiendo=recipienteLleno;
                gastado(recipienteLleno);
                //if(comiendo!=getLlenarlo()){
                if(recipienteLleno==false){
    //                System.out.println("Ya se consumió todo. Esperando la produccion.");
                    recipienteLleno=getRecipiente();
                }
            }
        }
    }
    
}
