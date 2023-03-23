/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

/**
 * Guarda las coordenadas xy del camino, ademas, guarda la decision tomada (que ireccion seguir de acuerdo a lo que le indique el algoritmo).
 * Se debe usar con un ArrayList.
 * Este class se puede implementar con extras...
 * @author Jugador
 */
public class MemoriaDelCamino {
    public PosicionesXY XY=new PosicionesXY();
    
    private int decision=0;
    
    public void setDecision(int nueva_decision){
        decision=nueva_decision;
    }
    
    public int getDecision(){
        return decision;
    }
}
