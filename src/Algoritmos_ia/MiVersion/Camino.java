/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia.MiVersion;

/**
 *
 * @author Rafael
 */
public class Camino {
    
    /**
     * Se usa 1.1 en lugar de 1 porque se trabaja con el tipo de datos Double.
     * Ademas Java me dio problemas matematicos al usar solo el valor 1.
     * @return 
     */
    public double getVisibilidad(){
        return 1/distancia;
    }
    
    public double getFeromonas(){
        if(cantidadDePasadasPorAqui!=0){
            return 0.1*cantidadDePasadasPorAqui/distancia;
        }
        return 0;
    }
    
    public Camino(double nueva_distancia, int nueva_pasada){
        distancia=nueva_distancia;
        cantidadDePasadasPorAqui=nueva_pasada;
        nombre="";
    }
    
    private int cantidadDePasadasPorAqui=0;
    
    /**
     * Permite saber cuantas veces pasó la hormiga por aqui.
     * @param nueva_pasada 
     */
    public void setCantidadDePasadasPorAqui(int nueva_pasada){
        cantidadDePasadasPorAqui=nueva_pasada;
    }
    /**
     * Permite saber cuantas veces pasó la hormiga por aqui.
     * @return 
     */
    public int getCantidadDePasadasPorAqui(){
        return cantidadDePasadasPorAqui;
    }
    
    private boolean activado=false;
    
    public void setActivado(boolean fue_activado){
        activado=fue_activado;
    }
    public boolean getActivado(){
        return activado;
    }
    
    
    private double distancia;
    
    public double getDistancia(){
        return distancia;
    }
    
    public void setDistancia(double nueva_distancia){
        distancia=nueva_distancia;
    }
    
    private String nombre="";
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String toString(){
        return "Nombre " + nombre + ", valor " + distancia;
    }
}
