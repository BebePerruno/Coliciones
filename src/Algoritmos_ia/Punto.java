/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

/**
 *Es necesario colocar un nombre en el constructor para hobligar a nombrar cada punto.
 * @author Rafael
 */

public class Punto {
    public double Valor=0;
    
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
    
    public Punto(String nuevo_nombre, boolean fue_activado){
        distancia=0;
        nombre=nuevo_nombre;
        activado=fue_activado;
    }
    
    public Punto(String nuevo_nombre, double nuevo_valor, boolean fue_activado, int nueva_pasada){
        distancia=nuevo_valor;
        nombre=nuevo_nombre;
        activado=fue_activado;
        cantidadDePasadasPorAqui=nueva_pasada;
    }
    
    public Punto(String nuevo_nombre, double nuevo_valor, boolean fue_activado){
        distancia=nuevo_valor;
        nombre=nuevo_nombre;
        activado=fue_activado;
    }
    
    private boolean activado=false;
    
    public void setActivado(boolean fue_activado){
        activado=fue_activado;
    }
    public boolean getActivado(){
        return activado;
    }
    
    
    private double distancia=0;
    
    public void setDistancia(double distanciaInicial, double distanciaFinal){
        if(distanciaFinal>distanciaInicial){
            distancia=distanciaFinal-distanciaInicial;
        }else{
            distancia=distanciaInicial-distanciaFinal;
        }
    }
    
    public double getDistancia(){
        return distancia;
    }
    
    private String nombre="";
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public Punto(String nuevo_nombre){
        distancia=0;
        nombre=nuevo_nombre;
    }
    
    public Punto(String nuevo_nombre, double nuevo_valor){
        distancia=nuevo_valor;
        nombre=nuevo_nombre;
    }
    
    @Override
    public String toString(){
        return "Nombre " + nombre + ", valor " + distancia;
    }
}
