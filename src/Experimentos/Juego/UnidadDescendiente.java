/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.Juego;

import java.awt.event.MouseAdapter;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Madrugada del lunes 23 de mayo del 2022.
 * Se hace abstracto para poder implementar el repaint y que pueda interactuar con el form a usar, ya sea un JPanel o un JFrame.
 * @author Rafael Angel Montero Fernpandez.
 * 
 */
public abstract class UnidadDescendiente extends UnidadEstandar{
    private ArrayList<UnidadDescendiente> enemigos=new ArrayList<UnidadDescendiente>();
    
    /**
     * No es necesario un control de duplicados ya que las imagenes se agregan todas al inicio del juego.
     * @param nueva_unidad_enemiga 
     */
    public void addUnidadesEnemigas(UnidadDescendiente nueva_unidad_enemiga){
        enemigos.add(nueva_unidad_enemiga);
    }
    
    public void borrarUnidadesEnemigas(){
        enemigos=new ArrayList<UnidadDescendiente>();
    }
    
    public abstract void chocando();
    public abstract void noChocando();
    
public void detectarColicionesConEnemigos(){
    try{
        for(int i=0; i<enemigos.size(); i++){
            if(this.intersects(enemigos.get(i))==true){
                System.out.println("Estoy chocando con " + enemigos.get(i).getNombreDeLaImagen());
                chocando();
            }else{
                //No hay choque.
                noChocando();
            }
        }
    }catch(Exception e){ }
}
   
    /**
     * Permite borrar las coordenadas viejas para poder introducirse nuevas.
     */
    public void borrarCoordenadas(){
        if(coordAliado.sizeX()>0){
            coordAliado.borrarTodo();
            coordAliado.setDatosBorrados(true);
        }
    }
    /**
     * Para agregar las coordenadas.
     * @param nuevoX
     * @param nuevoY 
     */
    public void addCoordenadas(int nuevoX, int nuevoY){
        coordAliado.add(nuevoX, nuevoY);
    }
    
    /**
     * Permite recorrer el lienzo de dibujo con la imagen dibujada.
     * @param coordenadas_cargadas_con_datos 
     */
    public abstract void repaint();
    
    public UnidadDescendiente(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JFrame form_para_dibujar,String nuevo_nombre_de_la_imagen){
        super(nuevoX, nuevoY, nuevoWidth, nuevoHeight, form_para_dibujar,nuevo_nombre_de_la_imagen);
    }
    
    public UnidadDescendiente(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JPanel form_para_dibujar,String nuevo_nombre_de_la_imagen){
        super(nuevoX, nuevoY, nuevoWidth, nuevoHeight, form_para_dibujar,nuevo_nombre_de_la_imagen);
    }
    
    private void dormir(){
    //System.out.println("Durmiendo");
       try {
           sleep(10);
       } catch (InterruptedException ex) {

       }
   }
    
    private Coordenadas coordAliado=new Coordenadas();
    
    /**
     * permite obtener las coordenadas.
     * @return 
     */
    public Coordenadas getCoordenadas(){
        return coordAliado;
    }
   
    public void recorriendo(){
       System.out.println("recorriendo");
       try{
           int contador_y=0;
           int contador_x=0;
           System.out.println(coordAliado.getDatosBorrados());
           if(coordAliado.x_es_mayor_que_y()==true){
               for(int i=0;i<coordAliado.sizeX(); i++){

                  dormir();

                   this.setX(coordAliado.getX(i));
                   if(contador_y<coordAliado.sizeY()){
                       this.setY(coordAliado.getY(contador_y));
                       contador_y++;
                   }
                   if(coordAliado.getDatosBorrados()==true){
                       contador_y=0;
                       coordAliado.setDatosBorrados(false);
                   }
                   repaint();
               }
           }else if(coordAliado.x_es_mayor_que_y()==false){
               for(int i=0;i<coordAliado.sizeY(); i++){

                   dormir();

                   this.setY(coordAliado.getY(i));
//                           System.out.println("Recorriendo x=" + coordAliado.getX(i) + "; y=" + coordAliado.getY(contador_y));
                   if(contador_x<coordAliado.sizeX()){
                       this.setX(coordAliado.getX(contador_x));
                       contador_x++;
                   }
                   if(coordAliado.getDatosBorrados()==true){
                       contador_x=0;
                       coordAliado.setDatosBorrados(false);
                   }
                   repaint();
               }
           }
       }catch(Exception ex){

       }
   }
}
