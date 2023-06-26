/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoConJLabels;

import ia.Habitante;
import ia.iAlgoritmoGenetico;
import javax.swing.JOptionPane;

/**
 * Agregar a los genes una propiedad más.
 * Yo deberia implementarlo con una matriz de n filas por 2 columnas.
 * @author Jugador
 */
public class Cerrebro extends Habitante {
    
    public Cerrebro(String []mNuevosGenes){
        super(mNuevosGenes);
        
    }

    private static String datosCodificados="";
    
    public static void addDatosCodificados(String nuevos_datos){
        datosCodificados+=nuevos_datos+"_";
    }
    
    private static Gene []mDatosCodificados={};
    
    
    public void setDatosCodificados(){
        if(datosCodificados.equals("")!=true){
            String []m=datosCodificados.split("_");
            mDatosCodificados=new Gene[Habitante.cantidadDeGenes];
            for(int i=0; i<Habitante.cantidadDeGenes;i++){
                mDatosCodificados[i].setGen(Habitante.mGenesDeseados[i]);
                mDatosCodificados[i].setDatos(m[i]);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existen datos codificados.");
        }
    }
    public void setDatosCodificados(Gene []mNuevosDatosCodificados){
        mDatosCodificados=mNuevosDatosCodificados;
    }
    
    public void setDatosCodificados(String []mNuevosDatosCodificados, String []mGenes_deseados){
        for(int i=0; i<Habitante.cantidadDeGenes;i++){
            mDatosCodificados[i]=new Gene(mNuevosDatosCodificados[i], mGenes_deseados[i]);
        }
    }
    public Gene []getObjetivoCodificado(){
        return mDatosCodificados;
    }
    
    private Gene []mEvolucionadoCodificado={};
    
    public void setEvolucionadoCodificado(){
        mEvolucionadoCodificado=new Gene[Habitante.cantidadDeGenes];
        for(int i=0; i<Habitante.cantidadDeGenes;i++){
            if(this.getmGenes()[i].equalsIgnoreCase(mDatosCodificados[i].getGen())==true){
                mEvolucionadoCodificado[i]=new Gene(getmGenes()[i], mDatosCodificados[i].getDatos());
            }
        }
    }
    
    public Gene []getEvolucionadoCodificado(){
        return mEvolucionadoCodificado;
    }
    
}

class Gene {
    public Gene(){}
    
    public Gene(String nuevo_gene, String nuevos_datos){
        gen=nuevo_gene;
        datosCoificados=nuevos_datos;
    }
    
    private String gen="";
    
    public void setGen(String nuevo_gene){
        gen=nuevo_gene;
    }
    public String getGen(){
        return gen;
    }
    
    private String datosCoificados="";
    
    public void setDatos(String nuevos_datos){
        datosCoificados=nuevos_datos;
    }
    public String getDatos(){
        return datosCoificados;
    }
    
    @Override
    public String toString(){
        return "Gen = " + getGen() + "; datos = " + getDatos();
    }
    
}
