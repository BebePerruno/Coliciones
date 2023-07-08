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
     * Se usa en el cruzamiento.
     * @param mGenes Un texto con los genes.
     * @return Retorna la mitad de la cadena genetica.
     */
    String []ObtenerFitnessMitadDeGenes(String []mGenes);
    
    /**
     * Se elimina el genoma anterior indicando que es un nuevo individuo.
     * @param un_habitante
     * @param otro_habitante
     */
    void cruzamiento(plantilla un_habitante, plantilla otro_habitante);

    /**
     * Cruza un habitante.
     * @param un_habitante Cruza al al habitante con el que se pase por este parametro.
     */
    void cruzamiento(plantilla un_habitante);

    /**
     * 
     * @param un_habitante  Cruza al al habitante con el que se pase por este parametro.
     */
    void cruzarmiento(plantilla un_habitante);

    /**
     * 
     * @return Retorna el valor fitness, que tan cerca esta del objetivo.
     */
    int getFitness();

    /**
     * 
     * @return Retorna el valor fitness, que tan cerca esta del objetivo.
     */
    plantilla2 getGenes();

    /**
     * 
     * @return Retorna el numero de esta instancia.
     */
    int getNumeroDeInstancia();

    /**
     * 
     * @return Retorna el genoma o vector de genes de la instancia actual.
     */
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
