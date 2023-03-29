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
    /**
     * El punto donde esta la unidad antes de recivir la orden de moverse.
     */
    public PosicionesXY XY_inicial=new PosicionesXY();
    /**
     * El punto donde esta la unidad al finalizar la orden de moverse.
     */
    public PosicionesXY XY_final=new PosicionesXY();
    
    private DecisionesDeMovimientos decision=DecisionesDeMovimientos.izquierda;
    
   /**
    * Permite guardar la decision de movimeinto.
    * Y asi no es necesario guardar una gigantesca cantidad de coordenadas xy.
    * Una buena solucion para el antiguo class gestor de coordenadas.
    * @param nueva_decision Un numero entre 1 y 4, los cuales son movimientos basicos.
    */ 
    public void setDecision(DecisionesDeMovimientos nueva_decision){
        decision=nueva_decision;
    }
    
    /**
     * 
     * @return Retorna el numero entre 1 y 4 que corresponde a una decision de movimiento.
     */ 
    public DecisionesDeMovimientos getDecision(){
        return decision;
    }
    
    
    @Override
    public String toString(){
        return "Desicion " + this.getDecision() + ", XY_final= " + XY_final.toString() + "; XY_inicial= "+XY_inicial.toString();
    }
}
