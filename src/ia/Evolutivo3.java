/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

import juegoConJLabels.HiloProductorConsumidor;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *Pasos del algoritmo evolutivo.
 * 1) Poblacion inicial.
 * 2) Funcion aptitud.
 * 3) Seleccion.
 * 4) Cruzamiento.
 * 5) Mutacion.
 * 6)Funcion aptitud.
 * 7) Seleccion.
 * 
 * Queda comprobado que este algoritmo evolutivo si funciona.
 * 
 * @author Angel
 */
public class Evolutivo3 {
    
    public static void main(String []m){
        new Hilo();
    }
    
}

class Hilo extends HiloProductorConsumidor{
    
    public class PoblacionEvolutiva extends Poblacion{

        
        public PoblacionEvolutiva(int numero_de_genes, int numero_de_habitantes) {
            super(numero_de_genes,  numero_de_habitantes);
        }

        @Override
        public void eveFitness(String genes_del_habitante_actual) {
//            frm1.addPoblacionActual(genes_del_habitante_actual);
        }

        private int []m=new int[Habitante.cantidadDeHabitantes];
        private int a=0;
        
        @Override
        public void eveSeleccion(String genes_del_mejor_habitante, int fitness_del_mejor_habitante) {
            frm1.addTodasLasPoblaciones(genes_del_mejor_habitante + ", fitness " + fitness_del_mejor_habitante);
            System.out.println(genes_del_mejor_habitante + ", fitness " + fitness_del_mejor_habitante);
            m[a]=fitness_del_mejor_habitante;
            a++;
        }

        
        
        @Override
        public void eveNuevaGeneracion(int numero_de_la_generacion, double promedio_de_esta_generacion, int sumatoria_de_fitness_sin_promediar) {
            System.out.println("Promedio de fintness de la generacion " + numero_de_la_generacion+ " es iagual a " + promedio_de_esta_generacion);
            frm1.setPromedio(m);
            m=new int[Habitante.cantidadDeHabitantes];
            a=0;
        }
        
    }

    private PoblacionEvolutiva poblacion=null;
    
    public class Formulario extends FrmAlgoritmoGenetico{
        
        public Formulario(){
//            super(Habitante.cantidadDeGenes);
        }

        @Override
        public void eveAgregarGenomaModelo(int numero_elegido) {
            //
        }

        @Override
        public void eveIniciarEvolucion(int numero_de_habitantes, int numero_de_generaciones, int numero_de_genes) {
            Habitante.cantidadDeHabitantes=numero_de_habitantes;
            Habitante.cantidadDegeneraciones=numero_de_generaciones;
            Habitante.cantidadDeGenes=numero_de_genes;
            poblacion=new PoblacionEvolutiva(numero_de_genes,numero_de_habitantes);
            poblacion.poblacionInicial();
            activar();
        }

        @Override
        public void eveDetenerEvolucion() {
            desactivar();
        }

        @Override
        public void eveListandoPoblacionActual(String genomaDelIndividuo) {
//            System.out.println("Poblacion actual genoma del individuo actual " + genomaDelIndividuo);
        }

        @Override
        public void eveListandoTodasLasPoblaciones(String genomaDelIndividuo) {
//            System.out.println("Genoma de toda la pobalcion, inividio " + genomaDelIndividuo);
        }

        @Override
        public void eveGenerandoGenomaObjetivo(String[] mGenoma) {
//            mGenomaModelo=getmGenomaObjetivo();
            Habitante.mGenesDeseados=mGenoma;
        }

        @Override
        public void eveNumeroDeGenes(int numero_de_genes) {
            Habitante.cantidadDeGenes=numero_de_genes;
        }
        
    }
    
//    private String []mGenomaModelo={};
    
    
    
    private Formulario frm1=null;
    
    
    public Hilo() {
        super(false, false);
//        Habitante.cantidadDeHabitantes=10;
//        Habitante.cantidadDegeneraciones=10;
        frm1=new Formulario();
        frm1.setVisible(true);
        
        
//        for(int i=1; i<=Habitante.cantidadDeHabitantes; i++){
//            Habitante.add(new   Habitante(mGenomaAleatorio()));
//            frm1.addPoblacionActual(Habitante.rsPoblacion.get(Habitante.rsPoblacion.size()-1).getGenes());
//            frm1.addTodasLasPoblaciones(Habitante.rsPoblacion.get(Habitante.rsPoblacion.size()-1).getGenes());
//        }
        
        
//        this.activar();
    }
    
    private int contador=0;
    
    
    
    @Override
    public void produciendo() {
//        try{
            contador++;
            
            poblacion.evolucionar();
//        }catch(Exception e){}
        this.esperar(100);
        this.setRecipienteLleno(true);
        if(contador==(Habitante.cantidadDegeneraciones*Habitante.cantidadDeHabitantes)){
            this.desactivar();
        }
    }

    
    @Override
    public void gastado(boolean llenar_recipiente) {
        esperar(200);
//        frm1.LimpiarPoblacionActual();
        setRecipienteLleno(false);
    }

    @Override
    public void eventoProductor() {
        
        //
    }

    @Override
    public void eventoConsumidor() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}



