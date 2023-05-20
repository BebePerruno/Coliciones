/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import ia.Habitante;
import ia.iAlgoritmoGenetico;

/**
 * Agregar a los genes una propiedad más.
 * Yo deberia implementarlo con una matriz de n filas por 2 columnas.
 * @author Jugador
 */
public class Cerrebro implements iAlgoritmoGenetico<Habitante> {

    @Override
    public void cruzamiento(Habitante un_habitante, Habitante otro_habitante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cruzamiento(Habitante un_habitante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cruzarmiento(Habitante un_habitante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getFitness() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getGenes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getNumeroDeInstancia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getmGenes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mutar(String[] mGenes_para_mutar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setFitness(Habitante habitante_objetivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setFitness(String[] mGenes_deseados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setNumeroDeInstancia(int nuevo_numero_de_instancia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    
    
    
}


class Gen{
    
    public Gen(){}
    
    public Gen(String nuevo_gene, String nueva_codificasion){
        mGene[0]=nuevo_gene;
        mGene[1]=nueva_codificasion;
    }
    /**
     * El id=0 es para el gen.
     * El id=1 es para la codificasion o tarea.
     */
    private String []mGene=new String[2];
    
    public void setGene(String nuevo_gene, String nueva_codificasion){
        mGene[0]=nuevo_gene;
        mGene[1]=nueva_codificasion;
    }
    
    public String []getGene(){
        return mGene;
    }
    
    @Override
    public String toString(){
        return "gen= " + mGene[0] + ", codificasion= " + mGene[1]; 
    }
}