/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoConJLabels;

import Experimentos.Juego.Coordenadas;
import Experimentos.Juego.Movimientos;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Investigar como detectar instancias de un class en Java.
 * @author Jugador
 */
public class Personaje  implements Movimientos {
    
    
    private String nombre="";
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    private int puntosDeVida=1;
    
    
    public void setPuntosDeVida(int nuevos_puntos_de_vida){
        puntosDeVida=nuevos_puntos_de_vida;
    }
    
    public int getPuntosDeVida(){
        return puntosDeVida;
    }
  /**
   * Para guardar puntos claves xy.
   */  
    public MemoriaRuta memoriaRuta=new MemoriaRuta();
    public MemoriaDelCamino memoriaDelCamino=new MemoriaDelCamino();
    
    private boolean ejecutando_rutas_guardadas=false;
    public boolean getEjecutandoRutasGuardadas(){
        return ejecutando_rutas_guardadas;
    }
    
    public boolean recorridoFinalizado=false;
    
    public void ejecutarRutaGuardada(int id_contador){
        int xInterna=0;
            int yInterna=0;
            yInterna=memoriaRuta.getMemoria(id_contador).XY_final.getY();
            xInterna=memoriaRuta.getMemoria(id_contador).XY_final.getX();
            DibujoDelPersonaje.setBounds(xInterna, yInterna, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
            System.out.println("Ejecutando rutas guardadas");
    }
    
    public void ejecutarRutasGuardadas(){
        ejecutando_rutas_guardadas=true;
        recorridoFinalizado=false;
        for(int i=0; i<memoriaRuta.size(); i++){
            try {
                sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
            }
            int xInterna=0;
            int yInterna=0;
            yInterna=memoriaRuta.getMemoria(i).XY_final.getY();
            xInterna=memoriaRuta.getMemoria(i).XY_final.getX();
            DibujoDelPersonaje.setBounds(xInterna, yInterna, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
            System.out.println("Ejecutando rutas guardadas");
            //Se necesita saber la posicion inicial o se debe realizar en forma exterior.
            //Mejor realizo esto en el exterior de este class.
        }
        recorridoFinalizado=true;
        ejecutando_rutas_guardadas=false;
    }
    
    /**
     * Permite ir monitoreando los movimientos.
     */
    public void documentarMovimientos(){
        memoriaDelCamino.XY_inicial.setX(memoriaDelCamino.XY_final.getX());
        memoriaDelCamino.XY_inicial.setY(memoriaDelCamino.XY_final.getY());
        memoriaDelCamino.XY_final.setX(x);
        memoriaDelCamino.XY_final.setX(y);
        
        
    }
    
    
    private double mejorSitio=0;
    
    public void setMejorSitio(double nuevo_mejor_sitio){
        mejorSitio=nuevo_mejor_sitio;
    }
    
    public double getMejorSitio(){
        return mejorSitio;
    }
    
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
     * Se usa en un bucle o en un hilo.
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
        DibujoDelPersonaje.setVisible(true);
        soloTexto();
//        System.out.println("ponerLabel() ="+imagen_para_el_personaje);
    }
    
    public void quitarLabel(){
        try{
            DibujoDelPersonaje.setVisible(false);
            DibujoDelPersonaje=null;
        }catch(Exception e){
            
        }
    }
    
    private TipoDeImagen imagentTemp;
    
   public Personaje(int nuevo_x,int nuevo_y,TipoDeImagen imagen_para_el_personaje){
//       DibujoDelPersonaje=new PersonajeLabel(x,y,imagen_para_el_personaje);
//       imagenDelPersonaje=imagen_para_el_personaje;
//       soloTexto();
        imagentTemp=imagen_para_el_personaje;
        this.ponerLabel(nuevo_x, nuevo_y, imagen_para_el_personaje);
        this.setX_UltimaPosicion(nuevo_x);
        this.setY_UltimaPosicion(nuevo_y);
        soloTexto();
   }
    
   public Personaje(int nuevo_x, int nuevo_y, int ancho, int altura, TipoDeImagen imagen_para_el_personaje){
       DibujoDelPersonaje=new PersonajeLabel(nuevo_x,nuevo_y,ancho, altura, imagen_para_el_personaje);
       imagenDelPersonaje=imagen_para_el_personaje;
//       System.out.println(imagen_para_el_personaje);
       soloTexto();
       this.setX_UltimaPosicion(nuevo_x);
       this.setY_UltimaPosicion(nuevo_y);
   }
   
   @Override
    public int getVelocidad() {
        return this.velocidad;
    }
    
    public static int LimiteInferior=200;
    public static int LimiteSuperior=0;
    public static int LimiteIzquierdo=0;
    public static int LimiteDerecho=1000;
    
    public void setX_UltimaPosicion(int nueva_ultima_posicion){
        x=nueva_ultima_posicion;
    }
    /**
     * Antes de moverse permite saber donde esta la imagen.
     * @return 
     */
    public int getX_UltimaPosicion(){
        return x;
    }
    
    public void setY_UltimaPosicion(int nueva_ultima_posicion){
        y=nueva_ultima_posicion;
    }
    /**
     * Antes de moverse permite saber donde esta la imagen.
     * @return 
     */
    public int getY_UltimaPosicion(){
        return y;
    }
    
    private int x=0;
    private int y=0;
    
    @Override
    public void moverAbajo() {
        y += velocidad;
        if (y >= LimiteInferior) {
            y = LimiteInferior;
        }
        documentarMovimientos();
        DibujoDelPersonaje.setBounds(x, y, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
        documentarMovimientos();
    }

    @Override
    public void moverArriba() {
        y -= velocidad;
        if (y <= LimiteSuperior) {
            y = LimiteSuperior;
        }
        DibujoDelPersonaje.setBounds(x, y, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
        documentarMovimientos();
    }

    @Override
    public void moverDrecha() {
        x += velocidad;
        if (x >= LimiteDerecho) {
            x = LimiteDerecho;
        }
        DibujoDelPersonaje.setBounds(x, y, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
        documentarMovimientos();
    }

    
    @Override
    public void moverIzquierda() {
        x -= velocidad;
        if (x <= LimiteIzquierdo) {
            x = LimiteIzquierdo;
        }
        DibujoDelPersonaje.setBounds(x, y, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
    }
    
    /**
     * Mueve el personaje sobre un mapa y ademas guarda los movimientos.
     * Este procedimiento solo se usa si se quiere preprogramar los movimientos.
     * @param x_nuevo Un numero
     * @param y_nuevo Un numero
     */
    public void moverse(int x_nuevo, int y_nuevo){
        x=x_nuevo;
        y=y_nuevo;
        documentarMovimientos();
        this.memoriaRuta.agregarAlFinal(memoriaDelCamino);
        DibujoDelPersonaje.setBounds(x, y, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
    }

    private int velocidad=5;
    
    @Override
    public void setVelocidad(int nuevaVelocidad) {
        velocidad=nuevaVelocidad;
    }
}
