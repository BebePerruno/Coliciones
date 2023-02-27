/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import static java.lang.Thread.sleep;

/**
 *Hilo doble es la sintesis del class contenedor, el class hilo productor y el class hilo consumidor.
 * @author Rafael
 */
public abstract class HiloDoble {
    Caja contenedor=null;
    Productor productor=null;
    Consumidor consumidor=null;

    public HiloDoble(int nueva_cantidad_para_el_contador, int nuevo_tiempo_de_espera_para_producir){
        contador=nueva_cantidad_para_el_contador;
        tiempoProduciendo=nuevo_tiempo_de_espera_para_producir;
        contenedor=new Caja();
        productor=new Productor(contenedor);
        consumidor=new Consumidor(contenedor);
    }
    
    public void start(){
        productor.start();
        consumidor.start();
    }
    
    private int contador=0;
    
    public void setContador(int nueva_cantidad_para_el_contador){
        contador=nueva_cantidad_para_el_contador;
    }
    
   public class Caja {
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
   
   public abstract void produciendo();
   
   private int tiempoProduciendo=0;
   
   public void setTiempoProduciendo(int nuevo_tiempo_de_espera_para_producir){
       tiempoProduciendo=nuevo_tiempo_de_espera_para_producir;
   }
   
   
   public class Productor  extends Thread{
        private Caja contenedor=null;

        public Productor(Caja nuevo_contenedor){
            contenedor=nuevo_contenedor;
        }

        @Override
        public void run(){
            while(true){
                try {
                    /**
                     * Puede ser un valor 3 para simular por ejemplo el crecimiento de una planta en 3 imagenes distintas.
                     */
                    for(int i=1; i<=tiempoProduciendo; i++){
                        sleep(200 );
//                        System.out.println("\n\nTiempo produciendo  productos.= i" + "\n\n");
                        produciendo();
                    }
                } catch (InterruptedException ex) { }
                
                contenedor.setProducto(contador);
            }
        } 

        private int numeroAleatorio(int Min, int Max){
            return (int)(Math.random()*(Max-Min+1)+Min);
        }
    }
   
   public abstract void consumiendo();
   
   public class Consumidor extends Thread{
    private Caja contenedor=null;

    public Consumidor(Caja nuevo_contenedor){
        contenedor=nuevo_contenedor;
    }

        @Override
        public void run(){
            int contando=contenedor.getProducto();
            while(true){
//                System.out.println("Contando " + contando + " productos");
                contando--;
                consumiendo();
                if(contando<=0){
                    contando=contenedor.getProducto();
//                    consumiendo();
                }
            }
        }
    }
}
