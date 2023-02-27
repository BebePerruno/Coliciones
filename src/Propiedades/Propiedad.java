/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propiedades;

/**
 *
 * @author Rafael Angel Montero Fernández
 * correo: rafaelangelmfx@gmail.com
 * Celular +506 83942235
 * Como crear propiedades.
 */
public class Propiedad <Primitiva>{
    
    private Primitiva valor;
    
    public void set(Primitiva nuevo_valor)
    {
        valor=nuevo_valor;
    }
    
    public Primitiva get()
    {
        return valor;
    }
}

