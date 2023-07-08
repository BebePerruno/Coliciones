/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmoDeHormigas;

/**
 * Despues de todo si funcionó.
 * @author Jugador
 */
public class ElMain {
    
    public static void main(String[] args) {
        int numHormigasLocal = 20;
        int numCiudadesLocal = 3;
        int maxIteracionesLocal = 20;
        double alphaLocal = 1.0;
        double betaLocal = 2.0;
        double evaporacionLocal = 0.5;
        double QLocal = 100.0;
        double[][] distanciasLocal = 
        {
                {10, 2, 4, 13, 5},
                {2, 1, 3, 2, 1},
                {4, 3, 7, 12, 2},
                {1, 2, 14, 8, 4},
                {5, 1, 2, 4, 12}
        };

        Hormiguero hormigueroChat =new Hormiguero(numHormigasLocal, numCiudadesLocal, maxIteracionesLocal, alphaLocal, betaLocal, evaporacionLocal, QLocal, distanciasLocal);
        
        int[] mejorCamino = hormigueroChat.ejecutar();

        System.out.println("Mejor camino encontrado:");
        for (int i = 0; i < numCiudadesLocal; i++) {
            System.out.print( mejorCamino[i] + "; ");
        }
        System.out.println();
        System.out.println("Longitud del mejor camino: " + hormigueroChat.obtenerLongitudCamino(mejorCamino));
    }
}
