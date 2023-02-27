/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *Prueba exitosa.
 * @author Rafael
 */
public class HiloDobleMain {
    
    public void iniciar(){
        Prueba p=new Prueba(3, 3);
        p.start();
    }
    
    public class Prueba extends HiloDoble{

        public Prueba(int nueva_cantidad_para_el_contador, int nuevo_tiempo_de_espera_para_producir) {
            super(nueva_cantidad_para_el_contador, nuevo_tiempo_de_espera_para_producir);
//            this.setContador(50);
//            this.setTiempoProduciendo(100);
        }

        @Override
        public void produciendo() {
            System.out.println("Los alimentos se estan cultivando.");
        }

        @Override
        public void consumiendo() {
            System.out.println("Cosechando alimentos en el huerto");
        }
        
    }
    
    public static void main(String []m){
        HiloDobleMain d=new HiloDobleMain();
        d.iniciar();
        
    }
    
}
