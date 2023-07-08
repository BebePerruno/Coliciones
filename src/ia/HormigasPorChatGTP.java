/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jugador
 */
public class HormigasPorChatGTP {

    public static void main(String[] args) {
        int numHormigasLocal = 10;
        int numCiudadesLocal = 5;
        int maxIteracionesLocal = 100;
        double alphaLocal = 1.0;
        double betaLocal = 2.0;
        double evaporacionLocal = 0.5;
        double QLocal = 100.0;
        double[][] distanciasLocal = {
                {0, 2, 4, 1, 5},
                {2, 0, 3, 2, 1},
                {4, 3, 0, 1, 2},
                {1, 2, 1, 0, 4},
                {5, 1, 2, 4, 0}
        };

        AlgoritmoHormigas1 hormigueroChat =new AlgoritmoHormigas1(numHormigasLocal, numCiudadesLocal, maxIteracionesLocal, alphaLocal, betaLocal, evaporacionLocal, QLocal, distanciasLocal);
        
        int[] mejorCamino = hormigueroChat.ejecutar();

        System.out.println("Mejor camino encontrado:");
        for (int i = 0; i < numCiudadesLocal; i++) {
            System.out.print(mejorCamino[i] + " ");
        }
        System.out.println();
        System.out.println("Longitud del mejor camino: " + hormigueroChat.obtenerLongitudCamino(mejorCamino));
    }
}


class AlgoritmoHormigas1 {
    private int numHormigas; // Número de hormigas
    private int numCiudades; // Número de ciudades
    private int maxIteraciones; // Número máximo de iteraciones
    private double alpha; // Parámetro alpha
    private double beta; // Parámetro beta
    private double evaporacion; // Factor de evaporación
    private double Q; // Factor de calidad de feromona
    private double[][] distancias; // Matriz de distancias entre ciudades
    private double[][] feromonas; // Matriz de feromonas entre ciudades
    private List<Hormiga> hormigas; // Lista de hormigas
    private int[] mejorCamino; // Mejor camino global encontrado
    
    public AlgoritmoHormigas1(){
        this.numHormigas = 0;
        this.numCiudades = 0;
        this.maxIteraciones = 0;
        this.alpha = 0;
        this.beta = 0;
        this.evaporacion = 0;
        this.Q = 0;
        this.distancias =new double[0][0];
        this.feromonas = new double[0][0];
        this.hormigas = new ArrayList<>();
        this.mejorCamino = new int[0];
    }

    public AlgoritmoHormigas1(int numHormigas, int nuevo_numCiudades, int maxIteraciones, double alpha, double beta, double evaporacion, double Q, double[][] distancias) {
        this.numHormigas = numHormigas;
        this.numCiudades = nuevo_numCiudades;
        this.maxIteraciones = maxIteraciones;
        this.alpha = alpha;
        this.beta = beta;
        this.evaporacion = evaporacion;
        this.Q = Q;
        this.distancias = distancias;
        this.feromonas = new double[numCiudades][numCiudades];
        this.hormigas = new ArrayList<>();
        this.mejorCamino = new int[numCiudades + 1];
    }

    public int[] ejecutar() {
        // Inicializar feromonas
        for (int i = 0; i < numCiudades; i++) {
            for (int j = 0; j < numCiudades; j++) {
                feromonas[i][j] = 1.0;
            }
        }

        // Ciclo principal
        for (int iteracion = 0; iteracion < maxIteraciones; iteracion++) {
            // Construir soluciones para cada hormiga
            for (int i = 0; i < numHormigas; i++) {
                Hormiga hormiga = new Hormiga(numCiudades);
                hormiga.construirSolucion(distancias, feromonas, alpha, beta);
                hormigas.add(hormiga);
            }

            // Actualizar feromonas
            for (int i = 0; i < numCiudades; i++) {
                for (int j = 0; j < numCiudades; j++) {
                    feromonas[i][j] *= evaporacion;
                }
            }

            // Actualizar feromonas en el mejor camino
            for (Hormiga hormiga : hormigas) {
                if (hormiga.getLongitudCamino() < obtenerLongitudCamino(mejorCamino)) {
                    mejorCamino = hormiga.getCamino();
                }

                double deltaFeromona = Q / hormiga.getLongitudCamino();
                for (int i = 0; i < numCiudades; i++) {
                    int ciudadActual = hormiga.getCamino()[i];
                    int ciudadSiguiente = hormiga.getCamino()[i + 1];
                    feromonas[ciudadActual][ciudadSiguiente] += deltaFeromona;
                }
            }

            // Limpiar la lista de hormigas
            hormigas.clear();
        }

        return mejorCamino;
    }

    public double obtenerLongitudCamino(int[] camino) {
        double longitud = 0;
        for (int i = 0; i < numCiudades; i++) {
            try{
                int ciudadActual = camino[i];
                int ciudadSiguiente = camino[i + 1];
                longitud += distancias[ciudadActual][ciudadSiguiente];
            }catch(Exception e){
                
            }
        }
        return longitud;
    }
}

class Hormiga {
    private int numCiudades=0;
    private int[] camino={};
    private boolean[] visitado={};
    private double[][] distancias={}; // Matriz de distancias entre ciudades
    
    public Hormiga(int numCiudades) {
        this.numCiudades = numCiudades;
        this.camino = new int[numCiudades + 1];
        this.visitado = new boolean[numCiudades];
        for (int i = 0; i < numCiudades; i++) {
            visitado[i] = false;
        }
    }

    public void construirSolucion(double[][] distancias, double[][] feromonas, double alpha, double beta) {
        int ciudadInicial = 0;
        int ciudadActual = ciudadInicial;
        visitado[ciudadActual] = true;
        camino[0] = ciudadActual;

        for (int i = 0; i < numCiudades - 1; i++) {
            int ciudadSiguiente = seleccionarCiudadSiguiente(distancias, feromonas, ciudadActual, alpha, beta);
            visitado[ciudadSiguiente] = true;
            camino[i + 1] = ciudadSiguiente;
            ciudadActual = ciudadSiguiente;
        }

        camino[numCiudades] = ciudadInicial;
    }

    private int seleccionarCiudadSiguiente(double[][] distancias, double[][] feromonas, int ciudadActual,
                                          double alpha, double beta) {
        double sumatoria = 0;
        for (int i = 0; i < numCiudades; i++) {
            if (!visitado[i]) {
                sumatoria += Math.pow(feromonas[ciudadActual][i], alpha+ Math.pow(1.0 / distancias[ciudadActual][i], beta));
            }
        }

        double[] probabilidades = new double[numCiudades];
        for (int i = 0; i < numCiudades; i++) {
            if (visitado[i]) {
                probabilidades[i] = 0.0;
            } else {
                probabilidades[i] = (Math.pow(feromonas[ciudadActual][i], alpha) *
                        Math.pow(1.0 / distancias[ciudadActual][i], beta)) / sumatoria;
            }
        }

        double valorAleatorio = Math.random();
        double sumatoriaProbabilidades = 0;
        for (int i = 0; i < numCiudades; i++) {
            sumatoriaProbabilidades += probabilidades[i];
            if (valorAleatorio <= sumatoriaProbabilidades) {
                return i;
            }
        }

        // Si no se selecciona ninguna ciudad, se selecciona una no visitada al azar
        for (int i = 0; i < numCiudades; i++) {
            if (!visitado[i]) {
                return i;
            }
        }

        // En caso de que todas las ciudades estén visitadas
        return -1;
    }

    public int[] getCamino() {
        return camino;
    }

    public double getLongitudCamino() {
        double longitud = 0;
        numCiudades=distancias.length;
        for (int i = 0; i < numCiudades; i++) {
            try{
                longitud += distancias[camino[i]][camino[i + 1]];
            }catch(Exception e){
                
            }
        }
        return longitud;
    }
}