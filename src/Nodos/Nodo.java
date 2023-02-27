/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

/**
 *
 * @author Rafael
 * rafaelangelmfx@gmail.com
 * 
 * celular 506 83942235
 */
public class Nodo {
    public Nodo anterior=null;
    public Nodo siguiente=null;
    
    public Nodo(){
        
    }
    
    public Nodo(Nodo nuevo_anterio, Nodo nuevo_siguiente){
        anterior=nuevo_anterio;
        siguiente=nuevo_siguiente;
    }
    
    public Nodo(Nodo nuevo_anterio, Nodo nuevo_siguiente, int nuevo_id, String nuevo_nombre){
        anterior=nuevo_anterio;
        siguiente=nuevo_siguiente;
        id=nuevo_id;
        nombre=nuevo_nombre;
    }
    
    public Nodo(String nuevo_nombre, int nuevo_valor){
        nombre=nuevo_nombre;
        valor=nuevo_valor;
    }
    
    private int id=0;
    /**
     * Sirve para saber el numero de nodo en el que me encuentro.
     * @return 
     */
    public int getId(){
        return id;
    }
    //____________________Datos del nodo_____________________________________
    /**
     * Sirve para saber el numero de nodo en el que me encuentro.
     * @param nuevo_id 
     */
    public void setId(int nuevo_id){
        id=nuevo_id;
    }
    
    private int valor=0;
    public void setValor(int nuevo_valor){
        valor=nuevo_valor;
    }
    public int getValor(){
        return valor;
    }
    
    private String nombre="";
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    /**
     * true si es null
     * false no es nulo
     * @return 
     */
    public boolean anterior_es_nulo(){
        return anterior==null;
    }
    
    /**
     * true si es null
     * false no es nulo
     * @return 
     */
    public boolean siguiente_es_nulo(){
        return siguiente==null;
    }
    
    @Override
    public String toString(){
        return "id= " + id + "; nombre= " + nombre + ", valor= " + valor + "; anterior es null= " + 
                this.anterior_es_nulo() + "; siguiente es null= " + this.siguiente_es_nulo();
    }
    
}
