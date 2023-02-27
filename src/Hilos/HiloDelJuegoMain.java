/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *Exito.
 * En un juego la propiedad setProducir se pondrá en true o false de acuerdoa  los eventos del juego, sin necesidad de un for.
 * Solo por medio de un condicional.
 * Ya que los hilos tienen bucles en su interior.
 * @author Rafael
 */
public class HiloDelJuegoMain extends HiloDelJuego{
 

        public HiloDelJuegoMain(boolean seguir_produciendo) {
            super(seguir_produciendo);
        }

        @Override
        public void produciendo() {
            for(int i=1; i<=3; i++){
                System.out.println("Produciendo " + i);
            }
            this.setProducir(false);
        }

        @Override
        public void consumiendo() {
            for(int i=1; i<=7; i++){
                System.out.println("consumiendo " + i);
            }
            setProducir(true);
        }
        
    
    
    public static void main(String []m){
        HiloDelJuegoMain c=new HiloDelJuegoMain(true);
        
        c.start();
    }
}

abstract class X
{
    public abstract String v();
}
class A extends X
{

    @Override
    public String v() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}