/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;


/**
 *
 * @author Jugador
 * @param <plantilla>
 */
public abstract class OrdenamientoDeLaPoblacion<plantilla> {
    
    
    public OrdenamientoDeLaPoblacion() {
    }

    /**
     * Ordena un vector de mayor a menor.
     * @param dame_una_matriz
     * @return
     */
    protected abstract plantilla[] mOrdenarDeMenor_a_mayor(plantilla[] dame_una_matriz); 

    /**
     * Ordena la poblacion.
     * @return Retorna una poblacion ordenada de mayor a menor.
     */
    protected abstract plantilla[] ordenarPoblacion() ;
    
}
