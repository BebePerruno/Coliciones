/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import Experimentos.Juego.Coordenadas;
import Experimentos.Juego.Movimientos;

/**
 *
 * @author Jugador
 */
public class Personaje  implements Movimientos {
    
    private Faccion faccion=null;
    
    public void setFaccion(Faccion nueva_faccion){
        faccion=nueva_faccion;
        this.soloTexto();
    }
    
    public Faccion getFaccion(){
        return faccion;
    }
    
    
    private PersonajeLabel DibujoDelPersonaje=null;
    
    public PersonajeLabel getLabel(){
        return DibujoDelPersonaje;
    }
    
    public int getX(){
        return DibujoDelPersonaje.getX();
    }
    
    public int getY(){
        return DibujoDelPersonaje.getY();
    }
    
    public int getAltura(){
        return DibujoDelPersonaje.getHeight();
    }
    
    public Coordenadas coordenadas=new Coordenadas();
    private TipoDeImagen imagenDelPersonaje=null;
    
    private int idX=0, idY=0;
    
    /**
     * Se llama antes de llamar a recorrerUnaCoordenada().
     */
    public void limpiarRecorrido(){
        idX=0; idY=0;
    }
    
    /**
     * Se usa en unbucle o en un hilo.
     * @return Si retorna true indica que ya recorrieron todas las coordenadas.
     */
    public boolean recorrerUnaCoordenada(){
        if(DibujoDelPersonaje!=null){
            this.ponerLabel(coordenadas.getX(idX), coordenadas.getY(idY), imagenDelPersonaje);
        }
        idX++; idY++;
        return (idX>=coordenadas.sizeX()) && (idY>=coordenadas.sizeY());
    }
    
    private void soloTexto(){
        if(DibujoDelPersonaje!=null){
            if(DibujoDelPersonaje.getIcon()==null){
                DibujoDelPersonaje.setText(""+ this.getFaccion());
            }
        }
    }
    
    public void ponerLabel(int x,int y,TipoDeImagen imagen_para_el_personaje){
        quitarLabel();
        DibujoDelPersonaje=new PersonajeLabel(x,y,imagen_para_el_personaje);
        soloTexto();
        System.out.println(imagen_para_el_personaje);
    }
    
    public void quitarLabel(){
        try{
            DibujoDelPersonaje.setVisible(false);
            DibujoDelPersonaje=null;
        }catch(Exception e){
            
        }
    }
    
   public Personaje(int x,int y,TipoDeImagen imagen_para_el_personaje){
//       DibujoDelPersonaje=new PersonajeLabel(x,y,imagen_para_el_personaje);
//       imagenDelPersonaje=imagen_para_el_personaje;
//       soloTexto();
        this.ponerLabel(x, y, imagen_para_el_personaje);
   }
    
   public Personaje(int x, int y, int ancho, int altura, TipoDeImagen imagen_para_el_personaje){
       DibujoDelPersonaje=new PersonajeLabel(x,y,ancho, altura, imagen_para_el_personaje);
       imagenDelPersonaje=imagen_para_el_personaje;
       System.out.println(imagen_para_el_personaje);
       soloTexto();
   }
   
   @Override
    public int getVelocidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static int LimiteInferior=200;
    public static int LimiteSuperior=0;
    public static int LimiteIzquierdo=0;
    public static int LimiteDerecho=200;
    
    private int x=0;
    private int y=0;
    
    @Override
    public void moverAbajo() {
        y += 10;
        if (y >= LimiteInferior) {
            y = LimiteInferior;
        }
    }

    @Override
    public void moverArriba() {
        y -= velocidad;
        if (y <= LimiteSuperior) {
            y = LimiteSuperior;
        }
    }

    @Override
    public void moverDrecha() {
        x += velocidad;
        if (x >= LimiteDerecho) {
            x = LimiteDerecho;
        }
    }

    
    @Override
    public void moverIzquierda() {
        x -= velocidad;
        if (x <= LimiteIzquierdo) {
            x = LimiteIzquierdo;
        }
    }

    private int velocidad=10;
    
    @Override
    public void setVelocidad(int nuevaVelocidad) {
        velocidad=nuevaVelocidad;
    }
    
    
}
