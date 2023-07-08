/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmoDeHormigas;

//import jdk.internal.vm.annotation.IntrinsicCandidate;

/**
 *
 * @author Jugador
 */
public class HormigaPrimigenia {
    
    /**
     * Ya esta inicializada en cero.
     */
    protected int numeroDeCiudades = 0;
    /**
     * Corresponde a los indices de la matriz de las ciudades.
     */
    protected int[] camino = {};
    
    public int []getCamino(){
        return camino;
    }
    
    protected double[][] mDistanciasEntreCiudades = {}; // Matriz de distancias entre ciudades
    protected double alpha;
    protected double beta;
    private double feromonas;
    /**
     * Se usa en seleccionar siguiente ciudad.
     * Las feromonas se inicializan con un valor 0.1
     */
    protected double[][] mFeromonas = {};

//    @IntrinsicCandidate
    public HormigaPrimigenia() {
    }

    public void setFeromonas(double nuevas_feromonas) {
        feromonas = nuevas_feromonas;
    }

    public double getFeromonas() {
        return feromonas;
    }

    public void setAlpha(double nuevo_valor_alpha) {
        alpha = nuevo_valor_alpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setBeta(double nuevo_valor_beta) {
        beta = nuevo_valor_beta;
    }

    public double getBeta() {
        return beta;
    }

    public void setDistanciasEntreCiudades(double[][] mDistancias) {
        mDistanciasEntreCiudades = mDistancias;
        camino = new int[mDistanciasEntreCiudades.length + 1];
        
        /**
         * Se inicializan las feromonas.
         */
        this.mFeromonas = new double[this.getNumeroDeCiudades()][getNumeroDeCiudades()];
        
        /**
         * Se puede omitir esta inicializacion.
         */
        for(int f=0; f<mFeromonas.length; f++){
            for(int c=0; c<mFeromonas.length; c++){
                mFeromonas[f][c]=0.1;
            }
        }
    }

    public double[][] getDistanciasEntreCiudades() {
        return mDistanciasEntreCiudades;
    }

    public int getNumeroDeCiudades() {
        numeroDeCiudades = mDistanciasEntreCiudades.length;
        return numeroDeCiudades;
    }
    
}
