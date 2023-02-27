/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmo_KNN;

/**
 *
 * @author Rafael
 */
public class Categoria {
    
    private String nombre="";
    
    public Categoria(String newNombre, double newValor)
    {
        this.setValor(newValor);
        nombre=newNombre;
    }
    
    @Override
    public String toString()
    {
        return "Valor=" + valor + "; id=" + id + "; nombre " + nombre;
    }
    
    private int id=0;
    public void setId(int newId)
    {
        id=newId;
    }
    public int getId()
    {
        return id;
    }
    
    private double valor=0;
    public void setValor(double newValor)
    {
        valor=newValor;
    }
    public double getValor()
    {
        return valor;
    }
}
