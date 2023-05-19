/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ia;

/**
 * El orden es:
 * Antes de realizar esto se debe establecer el tamaño del genoma.
 * El genoma objetivo.
 * La cantidad de habitantes.
 * La cantidad de generaciones.
 * Una variable para validar la poblacion inicial.
 * 
 * 1)Poblacion inicial.
 * 2)Funcion fitness.
 * 3)Cruzamiento.
 * 4)Mutacion.
 * @author Jugador
 */
public interface AGPoblacion {
    
    
    void cruzamiento();

    /**
     * Se puede usar este metodo para evolucionar la poblacion, pero se recomienda mejor realizarlo por fuera.
     *
     */
    void evolucionar();

    /**
     * Evalua el fitnes de cada individio de la generacion actual y retorna un promedio del fitness de toda la poblacion.
     * @return Retorna un priomedio de la poblacion actual.
     */
    double fitness();

    void mutacion();

    /**
     * Obligatoriamente se tiene que empesar con este metodo.
     */
    void poblacionInicial();

    void seleccion();

    void setGenomaObjetivo(String[] mGenomaObjetivo);
    
}
