/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usar_imagenes;
 import java.util.Random;

/**
 *
 * @author Jugador
 */
public class HormigasConChatGTP {
   

public class AntColonyOptimization {
    private int numAnts;
    private int numIterations;
    private int numCities;
    private double[][] distanceMatrix;
    private double[][] pheromoneMatrix;
    private double alpha;
    private double beta;
    private double evaporationRate;

    public AntColonyOptimization(int numAnts, int numIterations, int numCities, double[][] distanceMatrix, double alpha, double beta, double evaporationRate) {
        this.numAnts = numAnts;
        this.numIterations = numIterations;
        this.numCities = numCities;
        this.distanceMatrix = distanceMatrix;
        this.alpha = alpha;
        this.beta = beta;
        this.evaporationRate = evaporationRate;

        initializePheromoneMatrix();
    }

    private void initializePheromoneMatrix() {
        pheromoneMatrix = new double[numCities][numCities];
        double initialValue = 1.0 / (numCities * numCities);

        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                pheromoneMatrix[i][j] = initialValue;
            }
        }
    }

    public int[] findOptimalPath() {
        int[] optimalPath = null;
        double shortestDistance = Double.MAX_VALUE;

        for (int iteration = 0; iteration < numIterations; iteration++) {
            int[][] antPaths = new int[numAnts][numCities];

            for (int ant = 0; ant < numAnts; ant++) {
                int[] path = constructAntPath();
                antPaths[ant] = path;

                double pathDistance = calculatePathDistance(path);

                if (pathDistance < shortestDistance) {
                    shortestDistance = pathDistance;
                    optimalPath = path;
                }
            }

            updatePheromoneMatrix(antPaths);
        }

        return optimalPath;
    }

    private int[] constructAntPath() {
        int[] path = new int[numCities];
        boolean[] visited = new boolean[numCities];
        Random random = new Random();

        int startCity = random.nextInt(numCities);
        path[0] = startCity;
        visited[startCity] = true;

        for (int i = 1; i < numCities; i++) {
            int currentCity = path[i - 1];
            int nextCity = selectNextCity(currentCity, visited);
            path[i] = nextCity;
            visited[nextCity] = true;
        }

        return path;
    }

    private int selectNextCity(int currentCity, boolean[] visited) {
        double[] probabilities = new double[numCities];
        double probabilitiesSum = 0.0;

        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                double pheromoneLevel = Math.pow(pheromoneMatrix[currentCity][i], alpha);
                double distance = Math.pow(1.0 / distanceMatrix[currentCity][i], beta);
                probabilities[i] = pheromoneLevel * distance;
                probabilitiesSum += probabilities[i];
            }
        }

        double randomValue = Math.random() * probabilitiesSum;
        double cumulative = 0.0;

        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                cumulative += probabilities[i];
                if (cumulative >= randomValue) {
                    return i;
                }
            }
        }

        return -1;
    }

    private double calculatePathDistance(int[] path) {
        double distance = 0.0;

        for (int i = 1; i < numCities; i++) {
            int cityA = path[i - 1];
            int cityB = path[i];
            distance += distanceMatrix[cityA][cityB];
        }

        int lastCity = path[numCities - 1];
        int firstCity = path[0];
        distance += distanceMatrix[lastCity][firstCity];

        return distance;
    }

    private void updatePheromoneMatrix(int[][] antPaths) {
            for (int i = 0; i < numCities; i++) {
                for (int j = 0; j < numCities; j++) {
                    pheromoneMatrix[i][j] *= (1 - evaporationRate);
                }
            }

            for (int ant = 0; ant < numAnts; ant++) {
                int[] path = antPaths[ant];
                double pathLength = calculatePathDistance(path);

                for (int i = 1; i < numCities; i++) {
                    int cityA = path[i - 1];
                    int cityB = path[i];
                    pheromoneMatrix[cityA][cityB] += 1.0 / pathLength;
                    pheromoneMatrix[cityB][cityA] = pheromoneMatrix[cityA][cityB]; // Symmetric matrix
                }

                int lastCity = path[numCities - 1];
                int firstCity = path[0];
                pheromoneMatrix[lastCity][firstCity] += 1.0 / pathLength;
                pheromoneMatrix[firstCity][lastCity] = pheromoneMatrix[lastCity][firstCity]; // Symmetric matrix
            }
        }
    }
}
