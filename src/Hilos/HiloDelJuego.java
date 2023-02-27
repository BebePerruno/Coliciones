/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import static java.lang.Thread.sleep;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 *
 * @author Rafael
 */
public abstract class HiloDelJuego {
    
    
    
    Caja contenedor=null;
    Productor productor=null;
    Consumidor consumidor=null;

    public HiloDelJuego(boolean seguir_produciendo){
        producir=seguir_produciendo;
        contenedor=new Caja();
        productor=new Productor(contenedor);
        consumidor=new Consumidor(contenedor);
    }
    
    public void start(){
        productor.start();
        consumidor.start();
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
   
   private boolean producir=false;
   
   public void setProducir(boolean seguir_produciendo){
       producir=seguir_produciendo;
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
                    while(producir!=false){
                        sleep(200 );
//                        System.out.println("\n\nTiempo produciendo  productos.= i" + "\n\n");
                        produciendo();
                    }
                } catch (InterruptedException ex) { }
                
                contenedor.setProducto(1);
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
                //El producto se sigue consumiendo hasta que llegue  producir=false;
//                Esto se notifica externamente.

                consumiendo();
                if(producir==false){
                    contando=contenedor.getProducto();
                    //No se hace true a la variable producir porque eso tambien se realiza externamente.
                }
            }
        }
    }
}