/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmoDeHormigas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jugador
 */
public class Hormiguero extends HormigaPrimigenia {
    /**
     * Número de hormigas
     */
    private int numeroDeHormigas;
//    /**
//     * Número de ciudades
//     */
//    private int numeroDeCiudades; 
    /**
     * Número máximo de iteraciones
     */
    private int maxIteraciones;
//    /**
//     * Parámetro alpha
//     */
//    private double alpha; 
//    /**
//     * Parámetro beta
//     */
//    private double beta; 
    /**
     * Factor de evaporación
     */
    private double evaporacion;
    /**
     * Factor de calidad de feromona
     */
    private double Q;
//    /**
//     * Matriz de distancias entre ciudades
//     */
//    private double[][] distancias;
//    /**
//     * Matriz de feromonas entre ciudades
//     */
//    private double[][] feromonas; 
    /**
     * Lista de hormigas
     */
    private List<Hormiga> hormigas; 
    /**
     * Mejor camino global encontrado
     */
    private int[] mejorCamino={};
    
    public Hormiguero(){
        this.numeroDeHormigas = 0;
        
        this.maxIteraciones = 0;
        this.alpha = 0;
        this.beta = 0;
        this.evaporacion = 0;
        this.Q = 0;
        this.setDistanciasEntreCiudades(new double[0][0]);
        this.mFeromonas=new double[0][0];
        this.hormigas = new ArrayList<>();
        this.mejorCamino = new int[0];
    }
    
    public Hormiguero(int nuevo_numero_de_hormigas, int nuevo_numCiudades, int maxIteraciones, double alpha, double beta, double evaporacion, double nuevo_valor_Q_de_calidad_de_la_feromona, double[][] mDistancias) {
        this.numeroDeHormigas = nuevo_numero_de_hormigas;
        this.maxIteraciones = maxIteraciones;
        this.alpha = alpha;
        this.beta = beta;
        this.evaporacion = evaporacion;
        this.Q = nuevo_valor_Q_de_calidad_de_la_feromona;
        setDistanciasEntreCiudades(mDistancias);
        
        this.hormigas = new ArrayList<>();
        this.mejorCamino = new int[getNumeroDeCiudades() + 1];
    }
    
    public double obtenerLongitudCamino(int[] camino) {
        double longitud = 0;
        System.out.println("\n\nInicio logitid del camino.");
        for (int i = 0; i < this.getNumeroDeCiudades(); i++) {
//            try{
                int ciudadActual = camino[i];
                int ciudadSiguiente = camino[i + 1];
                
                longitud += this.mDistanciasEntreCiudades[ciudadActual][ciudadSiguiente];
                System.out.println("Distancia de la ciudad " + i + "="+ mDistanciasEntreCiudades[ciudadActual][ciudadSiguiente]);
//            }catch(Exception e){
//                
//            }
        }
        System.out.println("Fin longitud del camino. \n\n");
        return longitud;
    }
    
    public int[] ejecutar() {
        // Inicializar feromonas
        for (int i = 0; i < getNumeroDeCiudades(); i++) {
            for (int j = 0; j < getNumeroDeCiudades(); j++) {
                this.mFeromonas[i][j] = 1.0;
            }
        }

        // Ciclo principal
        for (int iteracion = 0; iteracion < maxIteraciones; iteracion++) {
            // Construir soluciones para cada hormiga
            for (int i = 0; i < this.numeroDeHormigas; i++) {
                
                Hormiga hormiga = new Hormiga(this.getDistanciasEntreCiudades(), this.mFeromonas, alpha,beta);
                
                hormiga.construirSolucion();
                hormigas.add(hormiga);
            }

            // Actualizar feromonas
            for (int i = 0; i < this.getNumeroDeCiudades(); i++) {
                for (int j = 0; j < getNumeroDeCiudades(); j++) {
                    this.mFeromonas[i][j] *= evaporacion;
                }
            }

            // Actualizar feromonas en el mejor camino
            for (Hormiga hormiga : hormigas) {
                if (hormiga.getLongitudDelCamino() < obtenerLongitudCamino(mejorCamino)) {
                    mejorCamino = hormiga.camino;
                }

                /**
                 * El delta de las feromonas se saca con   Q (Factor de calidad de las feromonas) dibidido entre la longitud del camino.
                 */
                double deltaFeromona = Q / hormiga.getLongitudDelCamino();
                for (int i = 0; i < getNumeroDeCiudades(); i++) {
                    int ciudadActual = hormiga.camino[i];
                    int ciudadSiguiente = hormiga.camino[i + 1];
                    this.mFeromonas[ciudadActual][ciudadSiguiente] += deltaFeromona;
                }
            }
            // Limpiar la lista de hormigas
            hormigas.clear();
        }
        return mejorCamino;
    }
}
