/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

import javax.swing.JOptionPane;

/**
 * El orden es:
 * Antes de realizar esto se debe establecer el tamaño del genoma.
 * El genoma objetivo.
 * La cantidad de habitantes.
 * La cantidad de generaciones.
 * 
 * 1)Poblacion inicial.
 * 2)Funcion fitness.
 * 3)Cruzamiento.
 * 4)Mutacion.
 * @author Jugador
 */
public abstract class Poblacion extends OrdenamientoDeLaPoblacion<Habitante> implements AGPoblacion{
    
    /**
     * permite que el resto de metodos y funciones puedan trabajar bien.
     */
    private boolean nacioLaPoblacionInicial=false;
    
    @Override
    public void setGenomaObjetivo(String []mGenomaObjetivo){
        Habitante.mGenesDeseados=mGenomaObjetivo;
    }
    
    public Poblacion(int numero_de_genes,  int numero_de_habitantes ){
        Habitante.cantidadDeGenes=numero_de_genes;
        Habitante.cantidadDeHabitantes=numero_de_habitantes;
    }
    
    public Poblacion(int numero_de_genes, String []mGenomaObjetivo, int numero_de_habitantes ){
        Habitante.cantidadDeGenes=numero_de_genes;
        Habitante.mGenesDeseados=mGenomaObjetivo;
        Habitante.cantidadDeHabitantes=numero_de_habitantes;
    }
    
    public Poblacion(int numero_de_genes, String []mGenomaObjetivo, int numero_de_habitantes, int numero_de_generaciones){
        Habitante.cantidadDeGenes=numero_de_genes;
        Habitante.mGenesDeseados=mGenomaObjetivo;
        Habitante.cantidadDeHabitantes=numero_de_habitantes;
        Habitante.cantidadDegeneraciones=numero_de_generaciones;
    }
    
    
    
    /**
     * Obligatoriamente se tiene que empesar con este metodo.
     */
    @Override
    public void poblacionInicial(){
        for(int i=1; i<=Habitante.cantidadDeHabitantes; i++){
            Habitante.add(new   Habitante(Habitante.mGenomaAleatorio()));
        }
        nacioLaPoblacionInicial=true;
    }
    
    private int generacionNumero=0;
    
    public abstract void eveFitness(String genes_del_habitante_actual);
    /**
     * 
     * @param numero_de_la_generacion
     * @param promedio_de_esta_generacion
     * @param sumatoria_de_fitness_sin_promediar Permite graficar.
     */
    public abstract void eveNuevaGeneracion(int numero_de_la_generacion, double promedio_de_esta_generacion, int sumatoria_de_fitness_sin_promediar);
    /**
     * Evalua el fitnes de cada individio de la generacion actual y retorna un promedio del fitness de toda la poblacion.
     * @return Retorna un priomedio de la poblacion actual.
     */
    @Override
    public double fitness(){
        generacionNumero++;//Mejor realizo la suma de la generacion aqui.
        double promedio=0;
        int sumatoria_de_fitness=0;
        for(int i=0; i<Habitante.rsPoblacion.size(); i++){
                Habitante.rsPoblacion.get(i).setFitness(Habitante.mGenesDeseados);
                eveFitness(Habitante.rsPoblacion.get(i).toString());
                sumatoria_de_fitness+=Habitante.rsPoblacion.get(i).getFitness();
            }
        promedio=sumatoria_de_fitness/Habitante.cantidadDeHabitantes;
        eveNuevaGeneracion(generacionNumero, promedio, sumatoria_de_fitness);
        return promedio;
    }
    private Habitante []mPoblacionSeleccionadA_y_ordenada;
    public abstract void eveSeleccion(String genes_del_mejor_habitante, int fitness_del_mejor_habitante);
    @Override
    public void seleccion(){
        mPoblacionSeleccionadA_y_ordenada=ordenarPoblacion();
        eveSeleccion(mPoblacionSeleccionadA_y_ordenada[0].getGenes(), mPoblacionSeleccionadA_y_ordenada[0].getFitness());
//            frm1.setMejorHabitante(m[0].getGenes(), m[0].getFitness());
    }
    
    @Override
    public void cruzamiento(){
        for(int i=0; i<Habitante.rsPoblacion.size(); i++){
            if(mPoblacionSeleccionadA_y_ordenada[0].getFitness()==0){
                Habitante.rsPoblacion.get(i).cruzamiento(Habitante.rsPoblacion.get(Habitante.numeroAleatorio(0, Habitante.rsPoblacion.size()-1)),Habitante.rsPoblacion.get(Habitante.numeroAleatorio(0, Habitante.rsPoblacion.size()-1)));
            }else{
                Habitante.rsPoblacion.get(i).cruzamiento(mPoblacionSeleccionadA_y_ordenada[0],mPoblacionSeleccionadA_y_ordenada[1]);
            }
        }
    }
    
    @Override
    public void mutacion(){
        for(int i=0; i<Habitante.rsPoblacion.size()/4; i++){
            Habitante.rsPoblacion.get(Habitante.numeroAleatorio(0, Habitante.rsPoblacion.size()-1)).mutar(Habitante.mGenomaAleatorio());
        }
    }
    
    
    /**
     * Se puede usar este metodo para evolucionar la poblacion, 
     * pero se recomienda mejor realizarlo por fuera.
     * 
     */
    @Override
    public void evolucionar(){
        if(nacioLaPoblacionInicial==true){
            this.fitness();
            this.seleccion();
            this.cruzamiento();
            this.mutacion();
        }else{
            JOptionPane.showMessageDialog
        (null, "No has creado una poblacion inicial.");
        }
    }
    
    /**
     * Ordena un vector de mayor a menor.
     * @param dame_una_matriz
     * @return
     */
    @Override
    protected Habitante[] mOrdenarDeMenor_a_mayor(Habitante[] dame_una_matriz) {
        Habitante aux = null;
        Habitante[] m = dame_una_matriz;
        for (int idSuperior = 0; idSuperior < dame_una_matriz.length; idSuperior++) {
            for (int idInterno = 0; idInterno < dame_una_matriz.length; idInterno++) {
                if (m[idSuperior].getFitness() > m[idInterno].getFitness()) {
                    aux = m[idInterno];
                    m[idInterno] = m[idSuperior];
                    m[idSuperior] = aux;
                }
            }
        }
        Habitante[] mDosElegidos = new Habitante[2];
        mDosElegidos[0] = m[0];
        mDosElegidos[1] = m[1];
        return mDosElegidos;
    }

    /**
     * Ordena la poblacion.
     * @return Retorna una poblacion ordenada de mayor a menor.
     */
    @Override
    protected Habitante[] ordenarPoblacion() {
        Habitante[] m = new Habitante[Habitante.rsPoblacion.size()];
        for (int i = 0; i < Habitante.rsPoblacion.size(); i++) {
            m[i] = Habitante.rsPoblacion.get(i);
        }
        return mOrdenarDeMenor_a_mayor(m);
    }
}

///Luego uso esto RuntimeException
