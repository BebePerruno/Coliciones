/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import ia.AGPoblacion;
import ia.Habitante;
import ia.OrdenamientoDeLaPoblacion;
import javax.swing.JOptionPane;

/**
 *
 * @author Jugador
 */
public abstract class PoblacionDeUnidades  extends OrdenamientoDeLaPoblacion<Cerrebro> implements AGPoblacion{
   
    
    public PoblacionDeUnidades(int numero_de_genes,  int numero_de_habitantes ){
        Cerrebro.cantidadDeGenes=numero_de_genes;
        Cerrebro.cantidadDeHabitantes=numero_de_habitantes;
    }
    
    public PoblacionDeUnidades(int numero_de_genes, String []mGenomaObjetivo, int numero_de_habitantes ){
        Cerrebro.cantidadDeGenes=numero_de_genes;
        Cerrebro.mGenesDeseados=mGenomaObjetivo;
        Cerrebro.cantidadDeHabitantes=numero_de_habitantes;
    }
    
    public PoblacionDeUnidades(int numero_de_genes, String []mGenomaObjetivo, int numero_de_habitantes, int numero_de_generaciones){
        Cerrebro.cantidadDeGenes=numero_de_genes;
        Cerrebro.mGenesDeseados=mGenomaObjetivo;
        Cerrebro.cantidadDeHabitantes=numero_de_habitantes;
        Cerrebro.cantidadDegeneraciones=numero_de_generaciones;
    }

    private int generacionNumero=0;
    
    private Cerrebro []mPoblacionSeleccionada_y_ordenada;
    
    /**
     * permite que el resto de metodos y funciones puedan trabajar bien.
     */
    private boolean nacioLaPoblacionInicial=false;

    @Override
    public void cruzamiento() {
        for(int i=0; i<Habitante.rsPoblacion.size(); i++){
            if(mPoblacionSeleccionada_y_ordenada[0].getFitness()==0){
                Habitante.rsPoblacion.get(i).cruzamiento(Habitante.rsPoblacion.get(Habitante.numeroAleatorio(0, Habitante.rsPoblacion.size()-1)),Habitante.rsPoblacion.get(Habitante.numeroAleatorio(0, Habitante.rsPoblacion.size()-1)));
            }else{
                String valorTxt=""+ ((mPoblacionSeleccionada_y_ordenada.length-1)*0.20);
                int valor=Integer.parseInt(valorTxt);
                Habitante.rsPoblacion.get(i).cruzamiento(mPoblacionSeleccionada_y_ordenada[0],mPoblacionSeleccionada_y_ordenada[Cerrebro.numeroAleatorio(0,valor )]);
            }
        }
    }

    @Override
    public void evolucionar() {
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

    public abstract void eveFitness(String genoma_del_habitante, Cerrebro nuevo );
    
    public abstract void eveNuevaGeneracion(int generacion_numero, double nuevo_promedio_de_la_generacion, int nueva_sumatoria_de_fitness_de_la_generacion);
    
    @Override
    public double fitness() {
        generacionNumero++;//Mejor realizo la suma de la generacion aqui.
        double promedio=0;
        int sumatoria_de_fitness=0;
        for(int i=0; i<Habitante.rsPoblacion.size(); i++){
                Cerrebro.rsPoblacion.get(i).setFitness(Cerrebro.mGenesDeseados);
                eveFitness(Cerrebro.rsPoblacion.get(i).toString(),(Cerrebro)Cerrebro.rsPoblacion.get(i) );
                sumatoria_de_fitness+=Cerrebro.rsPoblacion.get(i).getFitness();
            }
        promedio=sumatoria_de_fitness/Cerrebro.cantidadDeHabitantes;
        eveNuevaGeneracion(generacionNumero, promedio, sumatoria_de_fitness);
        return promedio;
    }

    @Override
    public void mutacion() {
        for(int i=0; i<Habitante.rsPoblacion.size()*0.40; i++){
            Habitante.rsPoblacion.get(Habitante.numeroAleatorio(0, Habitante.rsPoblacion.size()-1)).mutar(Habitante.mGenomaAleatorio());
        }
    }

    @Override
    public void poblacionInicial() {
        for(int i=1; i<=Habitante.cantidadDeHabitantes; i++){
            Habitante.add(new   Habitante(Habitante.mGenomaAleatorio()));
        }
        nacioLaPoblacionInicial=true;
    }

    @Override
    public void seleccion() {
        mPoblacionSeleccionada_y_ordenada=ordenarPoblacion();
//        eveSeleccion(mPoblacionSeleccionada_y_ordenada[0].getGenes(), mPoblacionSeleccionada_y_ordenada[0].getFitness());
    }

    @Override
    public void setGenomaObjetivo(String[] mGenomaObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Cerrebro[] mOrdenarDeMenor_a_mayor(Cerrebro[] dame_una_matriz) {
        Cerrebro aux = null;
        Cerrebro[] m = dame_una_matriz;
        for (int idSuperior = 0; idSuperior < dame_una_matriz.length; idSuperior++) {
            for (int idInterno = 0; idInterno < dame_una_matriz.length; idInterno++) {
                if (m[idSuperior].getFitness() > m[idInterno].getFitness()) {
                    aux = m[idInterno];
                    m[idInterno] = m[idSuperior];
                    m[idSuperior] = aux;
                }
            }
        }
        Cerrebro[] mDosElegidos = new Cerrebro[2];
        mDosElegidos[0] = m[0];
        mDosElegidos[1] = m[1];
        return mDosElegidos;
    }

    @Override
    protected Cerrebro[] ordenarPoblacion() {
        Cerrebro[] m = new Cerrebro[Cerrebro.rsPoblacion.size()];
        for (int i = 0; i < Cerrebro.rsPoblacion.size(); i++) {
            m[i] =(Cerrebro) Cerrebro.rsPoblacion.get(i);
        }
        return mOrdenarDeMenor_a_mayor(m);
    }
    
    public String []matrizGenomaAleatorio(){
        String []mGenoma={};//new String[Habitante.cantidadDeGenes];
        for(int id=0; id<Cerrebro.cantidadDeGenes; id++){
            int numero=Cerrebro.numeroAleatorio(0, Habitante.cantidadDeGenes);
            if(numero<0){
                numero=0;
            }
            if(numero>Cerrebro.mGenesDeseados.length-1){
                numero=Cerrebro.mGenesDeseados.length-1;
            }
            mGenoma[id]=""+Cerrebro.mGenesDeseados[numero] ;
        }
        return mGenoma;
    }
    
}
