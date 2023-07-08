/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmoDeHormigas;

/**
 *
 * @author Jugador
 */
public class Hormiga extends HormigaPrimigenia {
    
    private boolean[] ciudadVisitada={};
    
    public Hormiga(){
        
    }
    
    public Hormiga(double [][]mDistancias){
        this.setDistanciasEntreCiudades(mDistancias);
        this.camino = new int[getNumeroDeCiudades() + 1];
        this.ciudadVisitada = new boolean[this.getNumeroDeCiudades()];
        for (int i = 0; i < getNumeroDeCiudades(); i++) {
            ciudadVisitada[i] = false;
        }
    }
    
    public Hormiga(double [][]mDistancias,  double[][] nuevas_feromonas, double nuevo_alpha, double nuevo_beta){
        this.setDistanciasEntreCiudades(mDistancias);
        this.camino = new int[getNumeroDeCiudades() + 1];
        this.ciudadVisitada = new boolean[this.getNumeroDeCiudades()];
        for (int i = 0; i < getNumeroDeCiudades(); i++) {
            ciudadVisitada[i] = false;
        }
        
        this.alpha=nuevo_alpha;
        this.beta=nuevo_beta;
        this.mFeromonas=nuevas_feromonas;
    }
    
    public double getLongitudDelCamino() {
        double longitud = 0;
        for (int i = 0; i < this.getNumeroDeCiudades(); i++) {
//            try{
                longitud += this.mDistanciasEntreCiudades[camino[i]][camino[i + 1]];
//            }catch(Exception e){
//                
//            }
        }
        return longitud;
    }
    
    
    /**
     * La ciudad actual vale cero.
     */
    private int ciudadActual=0;
    
    /**
     * Se usa en seleccionarCiudadSiguiente()
     * @param nueva_ciudad_actual Un numero que indica la ciudad actual.
     */
    public void setCiudadActual(int nueva_ciudad_actual){
        ciudadActual=nueva_ciudad_actual;
    }
    
    private int seleccionarCiudadSiguiente()//(double[][] distancias, double[][] feromonas, int ciudadActual,double alpha, double beta) 
    {
        double sumatoria = 0;
        for (int i = 0; i < this.getNumeroDeCiudades(); i++) {
            if (!this.ciudadVisitada[i]) {
                //Si no ha sido visitada.
                sumatoria += Math.pow(this.mFeromonas[ciudadActual][i], alpha+ Math.pow(1.0 / this.mDistanciasEntreCiudades[ciudadActual][i], beta));
            }
        }

        double[] probabilidades = new double[this.getNumeroDeCiudades()];
        for (int i = 0; i < this.getNumeroDeCiudades(); i++) {
            if (ciudadVisitada[i]==true) {
                probabilidades[i] = 0.0;
            } else if (ciudadVisitada[i]==false){
                /**
                 * Formula.
                 * 
                 * La sumatoria es feromonas de la ciudad actual elevado al resultado de
                 * alpha mas 1.0 dividido entre la distancia de la ciudad actual elevado a beta.
                 * 
                 * probabilidad=Feromonas del camino de la ciudad actual elevado al valor de alpha; el resultado se multiplica por 1.0 dividido entre
                 * la distancia de la ciudad actual; el resultado de la operacion anterior se divide entre la sumatoria.
                 * 
                 */
                probabilidades[i] = (Math.pow(mFeromonas[ciudadActual][i], alpha) *
                        Math.pow(1.0 / this.mDistanciasEntreCiudades[ciudadActual][i], beta)) / sumatoria;
            }
        }

        double valorAleatorio = Math.random();
        double sumatoriaProbabilidades = 0;
        for (int i = 0; i < this.getNumeroDeCiudades(); i++) {
            sumatoriaProbabilidades += probabilidades[i];
            if (valorAleatorio <= sumatoriaProbabilidades) {
                return i;
            }
        }

        // Si no se selecciona ninguna ciudad, se selecciona una no visitada al azar
        for (int i = 0; i < getNumeroDeCiudades(); i++) {
            if (this.ciudadVisitada[i]==false) {
                return i;
            }
        }

        // En caso de que todas las ciudades estén visitadas
        return -1;
    }
    
    public void construirSolucion() {
        int ciudadInicial = 0;
        ciudadActual = ciudadInicial;
        this.ciudadVisitada[ciudadActual] = true;
        camino[0] = ciudadActual;

        for (int i = 0; i < getNumeroDeCiudades() - 1; i++) {
            int ciudadSiguiente = seleccionarCiudadSiguiente();//(this.mDistanciasEntreCiudades, feromonas, ciudadActual, alpha, beta);
            ciudadVisitada[ciudadSiguiente] = true;
            camino[i + 1] = ciudadSiguiente;
            ciudadActual = ciudadSiguiente;
        }

        camino[getNumeroDeCiudades()] = ciudadInicial;
    }
    
}
