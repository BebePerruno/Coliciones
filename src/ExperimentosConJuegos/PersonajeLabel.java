/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import Experimentos.Juego.Movimientos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jugador
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
    
    
    private int puntosDeVida=1;
    
    
    public void setPuntosDeVida(int nuevos_puntos_de_vida){
        puntosDeVida=nuevos_puntos_de_vida;
    }
    
    public int getPuntosDeVida(){
        return puntosDeVida;
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
    
//    private boolean coliciono=false;
//    
//    public boolean getColiciono(){
//        return coliciono;
//    }
//    
    public boolean colision(JLabel unidad_contra_la_cual_colisiona){
        if(unidad_contra_la_cual_colisiona==null){
//            coliciono=false;
            return false;
        }
//        coliciono=this.getBounds().intersects(unidad_contra_la_cual_colisiona.getBounds());
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
     
    
}
