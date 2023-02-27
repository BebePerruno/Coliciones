/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.Juego;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 * Recomendado usar Canvas para los dibujos.
 * Sabado 19 de febrero del 2022.
 * Finalmente despues de investigar los sprites, he decidido que la mejor manera de crear un juego en java
 * por el momento es usando estas bibliotecas.
 * 
 */
public class UnidadEstandar extends Orientador {
    
    public UnidadEstandar(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight){
        super(nuevoX,nuevoY,nuevoWidth,nuevoHeight);
    }
    
    private int nivelDeSatisfaccion=0;
    
    public UnidadEstandar(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JFrame form_para_dibujar, String nuevo_nombre_de_la_imagen) {
        super(nuevoX, nuevoY, nuevoWidth, nuevoHeight, form_para_dibujar, nuevo_nombre_de_la_imagen);
    }

    public UnidadEstandar(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JPanel form_para_dibujar, String nuevo_nombre_de_la_imagen) {
        super(nuevoX, nuevoY, nuevoWidth, nuevoHeight, form_para_dibujar, nuevo_nombre_de_la_imagen);
    }
    
    /**
     * Permite que la unidad realice mejores acciones cuanto más alto sea su nivel de satisfaccion.
     * @param nuevo_nivel_de_satisfaccion 
     */
    public void setNivelDeSatisfaccion(int nuevo_nivel_de_satisfaccion){
        nivelDeSatisfaccion=nuevo_nivel_de_satisfaccion;
    }
    /**
     * Permite que la unidad realice mejores acciones cuanto más alto sea su nivel de satisfaccion.
     * @return 
     */
    public int getNivelDeSatisfaccion(){
        return nivelDeSatisfaccion;
    }
    
    private int puntosDeVida=1;
    
    /**
     * Por ejemplo un edificio debe tener como minimo 2 puntos de vida.
     * @param nuevos_puntos_de_vida 
     */
    public void setPuntosDeVida(int nuevos_puntos_de_vida){
        puntosDeVida=nuevos_puntos_de_vida;
    }
    
    /**
     * Por ejemplo un edificio debe tener como minimo 2 puntos de vida.
     */
    public int getPuntosDeVida(){
        return puntosDeVida;
    }
    
    
    private int numeroDeEdificio;
    
    public void setNumeroDeEdficio(int nuevoNumeroDeEdificio){
        numeroDeEdificio=nuevoNumeroDeEdificio;
    }
    
    public int getNumeroDeEdficio(){
        return numeroDeEdificio;
    }
    
    
    private boolean creado=false;
    
    public void setCreado(boolean ya_fue_creado){
        creado=ya_fue_creado;
//        crear=false;
    }
    public boolean getCreado(){
        return creado;
    }
    
    
    private boolean crear=false;
    
    /**
     * Para implementar la creacion de edificios.
     * @param nueva_creacion 
     */
    public void setCrear(boolean nueva_creacion){
        crear=nueva_creacion;
    }
    public boolean getCrear(){
        return crear;
    }
    
    
    
    public void keyPressed(java.awt.event.InputMethodEvent evt){
        System.out.println("Tecla " + evt.paramString());
    }
    /**
     * Mueve la unidad de acuerdo a las teclas de direccion.
     * Para crear edificios se usa el teclado numerico y luego la tecla c.
     * @param key 
     */
    public void keyPressed(KeyEvent key){
//        System.out.println((char)(key.getKeyCode())+"= " + key.getKeyCode());
        if(key.getKeyCode()==KeyEvent.VK_UP){
            this.moverArriba();
            crear=false;
        }
        if(key.getKeyCode()==KeyEvent.VK_DOWN){
            this.moverAbajo();
            crear=false;
        }
        if(key.getKeyCode()==KeyEvent.VK_LEFT){
            this.moverIzquierda();
            crear=false;
        }
        if(key.getKeyCode()==KeyEvent.VK_RIGHT){
            this.moverDrecha();
            crear=false;
        }
        if(key.getKeyCode()==67){
            crear=true;
//            this.numeroDeEdificio=this.numeroAleatorio(1, 4);
        }
        if(key.getKeyCode()==49){//Tecla 1
            this.numeroDeEdificio=1;
        }
        if(key.getKeyCode()==50){//Tecla 2
            this.numeroDeEdificio=2;
        }
        if(key.getKeyCode()==51){//Tecla 3
            this.numeroDeEdificio=3;
        }
        if(key.getKeyCode()==52){//Tecla 4
            this.numeroDeEdificio=4;
        }
        if(key.getKeyCode()==53){//Tecla 5
            this.numeroDeEdificio=5;
//            System.out.println("Edificio enemigo 5");
        }
        
        if(Superficie_para_dibujar!=null){
            Superficie_para_dibujar.repaint();
        }else{
            this.panel.repaint();
        }
    }
    
    private boolean con_foto = false;  
    
    
    
    public UnidadEstandar []mUnidadesEnemigas=new UnidadEstandar[5];
    public UnidadEstandar []mUnidadesAliadas=new UnidadEstandar[5];

    @Override
    public void moverme() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
}
