/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Risk;

import java.util.Objects;

/**
 *
 * @author Rafael
 */
public class JugadorUnidad {
    
    public JugadorUnidad(){}
    
    public JugadorUnidad(Nombres nuevo_nombre, Facciones nueva_faccion){
        this.setFaccion(nueva_faccion);
        this.setNombre(nuevo_nombre);
    }
    
    @Override
    public boolean equals(Object dr){
        JugadorUnidad j=(JugadorUnidad) dr;
        return this.faccion==j.faccion && this.nombre==j.nombre && this.puntosDeVida==j.puntosDeVida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 45 * hash + Objects.hashCode(this.nombre);
        hash = 45 * hash + this.puntosDeVida;
        hash = 45 * hash + Objects.hashCode(this.faccion);
        return hash;
    }
    
    private Nombres nombre;
    
    public void setNombre(Nombres nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public Nombres getNombre(){
        return nombre;
    }
    
    
    private int puntosDeVida=0;
    public void setPuntosDeVida(int nuevos_puntos_de_vida){
        puntosDeVida=nuevos_puntos_de_vida;
    }
    public int getPuntosDeVida(){
        return puntosDeVida;
    }
    
    private Facciones faccion;
    
    public void setFaccion(Facciones nueva_faccion){
        faccion=nueva_faccion;
    }
    public Facciones getFaccion(){
        return faccion;
    }
    
    public enum Facciones{
        Aliados, Enemigos
    }
    
    public enum Nombres{
        JugadorHumano, Jugador_ia
    }
    
    @Override
    public String toString(){
        return this.getNombre() + ", " + this.getFaccion() + ", " + this.getPuntosDeVida();
    }
    
}
