/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmo_KNN;

/**
 *
 * @author Rafael
 */
public class AbstractModelo {
    
    public AbstractModelo(String newNombre, double newValoGlobal )
    {
        this.setNombre(newNombre);
        this.setValorGlobal(newValoGlobal);
    }
    
    protected String nombre = "no";
    protected double valoGlobal = 0;

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValorGlobal(double newValoGlobal) {
        valoGlobal = newValoGlobal;
    }

    public double getValorGlobal() {
        return valoGlobal;
    }
    
}
