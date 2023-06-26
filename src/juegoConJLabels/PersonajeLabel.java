/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoConJLabels;

import Experimentos.Juego.Movimientos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *Correo BebePerrunoCanino@gmail.com
 * @author Rafael Angel Montero Fernández.
 * 
 */
public class PersonajeLabel extends JLabel{
    private final ImagenesParaJuegos imagenes=new ImagenesParaJuegos();
    
    /**
     * Detecta el borde derecho del ambiente.
     * @param width_del_ambiente
     * @return
     */
    public boolean detectarBordeDerecho(int width_del_ambiente) {
        if (width_del_ambiente <= getX() + getWidth()) {
            //            System.out.println("Estoy en el borde derecho ." + (getX()+getWidth()));
            return true;
        }
        return false;
    }

    /**
     * Detecta el borde izquierdo del ambiente.
     * @param height_del_ambiente
     * @return
     */
    public boolean detectarBordeInferior(int height_del_ambiente) {
        if (height_del_ambiente <= getY() + this.getHeight()) {
            //            System.out.println("Estoy en el borde inferior ." + (getY()+getHeight()));
            return true;
        }
        return false;
    }

    public boolean detectarBordeIzquierdo() {
        if (this.getX() <= 0) {
            return true;
        }
        return false;
    }

    public boolean detectarBordeSuperior() {
        if (this.getY() <= 0) {
            return true;
        }
        return false;
    }
    
    
    
    
    public static final int ancho=100;
    public static final int altura=100;
    
    public void DibujarImagen(TipoDeImagen imagen_elegida){
        switch(imagen_elegida){
            case Base:
                setIcon(imagenes.imagenBase());
                this.setToolTipText("Base");
                break;
            case Fabrica:
                 setIcon( imagenes.imagenFabrica());
                 setToolTipText("Fabrica");
                 break;
            case Generador:
                setIcon(imagenes.imagenGenerador());
                setToolTipText("Generador");
                break;
            case Bodega:
                setIcon(imagenes.imagenBodega());
                setToolTipText("Bodega");
                break;
            case Torre:
                setIcon(imagenes.imagenTorre());
                setToolTipText("Torre");
                break;
            case Robot:
                setIcon( imagenes.imagenRobot());
                setToolTipText("Robot");
                break;
            case Tanque:
                setIcon(imagenes.imagenTanque());
                break;
            case Explosion:
                setIcon(imagenes.imagenExplosion());
                setToolTipText("Explosion");
                break;
            default:
                //Valor no existente.
                break;
        }
    }
    
    public PersonajeLabel(int x, int y, int ancho, int altura, TipoDeImagen imagen_elegida){
        this.setBounds(x, y, ancho, altura);
        DibujarImagen(imagen_elegida);
    }
    
    public PersonajeLabel(int x, int y,TipoDeImagen imagen_elegida){
        this.setBounds(x, y, ancho, altura);
        DibujarImagen(imagen_elegida);
    }
    
    public boolean colision(JLabel unidad_contra_la_cual_colisiona){
        if(unidad_contra_la_cual_colisiona==null){
            return false;
        }
        return this.getBounds().intersects(unidad_contra_la_cual_colisiona.getBounds());
    }
    
     public boolean colision(JLabel []mUnidades_contra_las_cuales_colisiona){
         try{
             for(int i=0; i<mUnidades_contra_las_cuales_colisiona.length; i++){
                 if(getBounds().intersects(mUnidades_contra_las_cuales_colisiona[i].getBounds())==true){
                     return true;
                 }
             }
         }catch(Exception e){
             
         }
         return false;
     }
     
     /**
      * Permite detectar objetos cercanos.
      * Es lo mismo que la colision simplemente se crea un label invisible que funciona como rango de vision.
      * Importante esta funcion no es colision es un sensor para indicarle a la unidad que se acerca a un objeto.
      * @param mObjetos_cercanos Un matriz de controles JLabels.
      * @return Retorna true si detecta un objeto.
      */
     public boolean VerObjetos(JLabel []mObjetos_cercanos){
         try{
             final int rangoDeVision=50;
             JLabel ojos=new JLabel();
             ojos.setBounds(this.getX(), this.getY(), this.getWidth()+rangoDeVision, this.getHeight()+rangoDeVision);
             for(int i=0; i<mObjetos_cercanos.length; i++){
                 if(ojos.getBounds().intersects(mObjetos_cercanos[i].getBounds())==true){
                     return true;
                 }
             }
         }catch(Exception e){
             
         }
         return false;
     }
    
}
