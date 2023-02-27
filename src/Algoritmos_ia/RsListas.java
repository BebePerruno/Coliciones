/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

import java.util.ArrayList;

/**
 *Class para usarse en las diferentes listas numericas del Algoritmo de hormigas.
 * @author Rafael
 */
public class RsListas {
    
    
    
    public int size(){
        return Lista.size();
    }
    /**
     * Muchas partes del algoritmo de hormigas tienen sumatorias.
     * @return 
     */
    public double sumatoria(){
        double resultado=0;
        try{
            for(int i=0; i<Lista.size(); i++){
                resultado=Lista.get(i).Valor;
            }
        }catch(Exception e){}
        return resultado;
    }
    
    public RsListas(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    
    private String nombre="";
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    private ArrayList<Punto> Lista=new ArrayList<Punto>();
    
    public Punto get(int id){
        try{
            return Lista.get(id);
        }catch(Exception e){}
        return new Punto("");
    }
    
    public Punto buscar(String nombre_del_punto){
        try{
            for(int i=0; i<Lista.size(); i++){
                if(Lista.get(i).getNombre().equalsIgnoreCase(nombre_del_punto)==true){
                    si_existe_id=i;
                    return Lista.get(i);
                }
            }
        }catch(Exception e){
            
        }
        return new Punto("");
    }
    
    public Punto buscar(Punto nuevo_punto_de_valor){
        try{
            for(int i=0; i<Lista.size(); i++){
                if(Lista.get(i).getNombre().equalsIgnoreCase(nuevo_punto_de_valor.getNombre())==true){
                    si_existe_id=i;
                    return Lista.get(i);
                }
            }
        }catch(Exception e){
            
        }
        return new Punto("");
    }
    
    public void borrar(Punto nuevo_punto_de_valor){
        if(this.SiExiste(nuevo_punto_de_valor)==true){
            Lista.remove(si_existe_id);
        }
    }
    
    public void modificar(Punto nuevo_punto_de_valor){
        if(this.SiExiste(nuevo_punto_de_valor)==true){
            Lista.remove(si_existe_id);
            Lista.add(nuevo_punto_de_valor);
        }
    }
    
    public void add(Punto nuevo_punto_de_valor){
        if(this.SiExiste(nuevo_punto_de_valor)==false){
            Lista.add(nuevo_punto_de_valor);
        }
    }
    
    private int si_existe_id=-1;
    /**
     * No se utilizará puesto que puede lerdear la agregacion de datos.
     * Ademas los valores numericos se pueden repetir.
     * Pero mejor si.
     * @param nuevo_punto_de_valor
     * @return 
     */
    private boolean SiExiste(Punto nuevo_punto_de_valor){
        try{
            for(int i=0; i<Lista.size(); i++){
                if(Lista.get(i).getNombre().equalsIgnoreCase(nuevo_punto_de_valor.getNombre())==true){
                    si_existe_id=i;
                    return true;
                }
            }
        }catch(Exception e){
            
        }
        return false;
    }
    
    @Override
    public String toString(){
        String informe="Nombre " + nombre + "\n";
        try{
            for(int i=0; i<Lista.size(); i++){
                informe=Lista.get(i).toString() + "\n\n";
            }
        }catch(Exception e){}
        return informe;
    }
}
