/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exagonal;

import java.awt.Rectangle;

/**
 *
 * @author Jugador
 */
class Punto{
    
    private Rectangle r=new Rectangle();
    
    public int xInicial=0;
    public int yInicial=0;
    public int xFinal=0;
    public int yFinal=0;
    public Punto(){}
    public Punto(int nuevo_X_inicial, int nuevo_Y_inicial, int nuevo_X_final, int nuevo_Y_final){
        xInicial=nuevo_X_inicial;
        yInicial=nuevo_Y_inicial;
        xFinal=nuevo_X_final;
        yFinal=nuevo_Y_final;
    }
    
    
    
    @Override
    public String toString(){
        return "[xInicial " + xInicial + ", yInicial " + yInicial+"];  [xFinal "+xFinal+", yFinal "+yFinal+"]";
    }
}
