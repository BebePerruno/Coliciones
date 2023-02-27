/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 */
public class CasillaConUnidad extends Casilla{
        public CasillaConUnidad(int nueva_fila, int nueva_columna, Ancestro nueva_unidad){
        super(nueva_fila, nueva_columna);
        unidad=nueva_unidad;
    }
    
    private Ancestro unidad=null;
    
    public void setUnidad(Ancestro nueva_unidad){
        unidad=nueva_unidad;
    }
    public Ancestro getUnidad(){
        return unidad;
    }
}
