/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propiedades;

/**
 *
 * @author Rafael
 * Ejemplo del uso de la plantilla propiedad (Class).
 * 
 */
public class Modelo {
    public Propiedad<String> Nombre;
    
    public Propiedad<Integer>Numero;
    
    public Modelo()
    {
        Nombre=new Propiedad<String>();
        Numero=new Propiedad<Integer>();
    }
    
    public Modelo(String nuevo_nombre, int nuevo_numero)
    {
        Nombre=new Propiedad<String>();
        Nombre.set(nuevo_nombre);
        
        Numero=new Propiedad<Integer>();
        Numero.set(nuevo_numero);
        
    }
    
}
