/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

/**
 *Permite guardar la posicion xy inicial o final con respecto a cada movimeinto.
 * @author Jugador
 */
public class PosicionesXY {
    private int x=0;
    
    public void setX(int nueva_posicion_x){
        x=nueva_posicion_x;
    }
    
    public int getX(){
        return x;
    }
    private int y=0;
    
    public void setY(int nueva_posicion_y){
        y=nueva_posicion_y;
    }
    
    public int getY(){
        return y;
    }
    
}
