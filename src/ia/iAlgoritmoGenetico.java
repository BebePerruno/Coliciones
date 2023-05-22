/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ia;

/**
 *
 * @author Jugador
 */
public interface iAlgoritmoGenetico<plantilla, plantilla2> {

    /**
     * Se elimina el genoma anterior indicando que es un nuevo individuo.
     * @param un_habitante
     * @param otro_habitante
     */
    void cruzamiento(plantilla un_habitante, plantilla otro_habitante);

    /**
     * Cruza un habitante con este habitante.
     * @param un_habitante
     */
    void cruzamiento(plantilla un_habitante);

    void cruzarmiento(plantilla un_habitante);

    int getFitness();

    plantilla2 getGenes();

    int getNumeroDeInstancia();

    plantilla2[] getmGenes();

    /**
     * Toma los genes de otro habitante para mutar o de algun individuo modelo que esta fuera de la poblacion.
     * @param mGenes_para_mutar
     * @param habitante_que_proporcionara_los_genes Una instancia de Habitante.
     */
    void mutar(plantilla2[] mGenes_para_mutar);

    /**
     * Solo recoloca algunos genes del mismo vector en diferentes partes.
     */
    void mutar();

    void setFitness(plantilla habitante_objetivo);

    void setFitness(plantilla2[] mGenes_deseados);

    void setNumeroDeInstancia(int nuevo_numero_de_instancia);
    
}
