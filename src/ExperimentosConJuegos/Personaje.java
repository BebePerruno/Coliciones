/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import Experimentos.Juego.Coordenadas;
import Experimentos.Juego.Movimientos;

/**
 * Investigar como detectar instancias de un class en Java.
 * @author Jugador
 */
public class Personaje  implements Movimientos {
  /**
   * Para guardar puntos claves xy.
   */  
    public MemoriaRuta memoriaRuta=new MemoriaRuta();
    public MemoriaDelCamino memoriaDelCamino=new MemoriaDelCamino();
    
    public boolean recorridoFinalizado=false;
    public void ejecutarRutasGuardadas(){
        recorridoFinalizado=false;
//        int w=DibujoDelPersonaje.getWidth(), h=DibujoDelPersonaje.getHeight();
//        this.quitarLabel();
//        this.ponerLabel(memoriaRuta.getMemoria(0).XY_final.getX(), memoriaRuta.getMemoria(0).XY_final.getY(), imagentTemp);
        for(int i=0; i<memoriaRuta.size(); i++){
            int xInterna=0;
            int yInterna=0;
            yInterna=memoriaRuta.getMemoria(i).XY_final.getY();
            xInterna=memoriaRuta.getMemoria(i).XY_final.getX();
            DibujoDelPersonaje.setBounds(xInterna, yInterna, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
            //Se necesita saber la posicion inicial o se debe realizar en forma exterior.
            //Mejor realizo esto en el exterior de este class.
        }
        recorridoFinalizado=true;
    }
    
    /**
     * Permite ir monitoreando los movimientos.
     */
    private void documentarMovimientos(){
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
        DibujoDelPersonaje.setVisible(true);
        soloTexto();
        System.out.println("Undad colocada con ponerLabel() ="+imagen_para_el_personaje);
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
       System.out.println(imagen_para_el_personaje);
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
    public static int LimiteDerecho=200;
    
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
//        if(DibujoDelPersonaje.getColiciono()==false){
//            System.out.println(DibujoDelPersonaje.getColiciono());
            x -= velocidad;
            if (x <= LimiteIzquierdo) {
                x = LimiteIzquierdo;
            }
            DibujoDelPersonaje.setBounds(x, y, DibujoDelPersonaje.getWidth(), DibujoDelPersonaje.getHeight());
//        }
    }

    private int velocidad=5;
    
    @Override
    public void setVelocidad(int nuevaVelocidad) {
        velocidad=nuevaVelocidad;
    }
}
