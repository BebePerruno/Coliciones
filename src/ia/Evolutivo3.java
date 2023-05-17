/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

import ExperimentosConJuegos.HiloProductorConsumidor;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
//import Hilos.HiloDelJuego;

/**
 *Pasos del algoritmo evolutivo.
 * 1) Poblacion inicial.
 * 2) Funcion aptitud.
 * 3) Seleccion.
 * 4) Cruzamiento.
 * 5) Mutacion.
 * 
 * @author Angel
 */
public class Evolutivo3 {
    
    public static void main(String []m){
        new Hilo();
    }
    
}

class Hilo extends HiloProductorConsumidor{

    
    public class Formulario extends FrmAlgoritmoGenetico{
        
        public Formulario(){
            super(Habitante.cantidadDeHabitantes, Habitante.cantidadDegeneraciones,Habitante.cantidadDeGenes);
        }

        @Override
        public void eveAgregarGenomaModelo(int numero_elegido) {
            //
        }

        @Override
        public void eveIniciarEvolucion() {
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
            mGenomaModelo=getmGenomaObjetivo();
            Habitante.mGenesDeseados=getmGenomaObjetivo();
            System.out.println("Agregando gen modelo "+getGenomaObjetivo());
        }
        
    }
    
    private String []mGenomaModelo={"2","3","4","5","6","7"};
    
    private String []mGenomaAleatorio(){
        String []mGenoma=new String[6];
            for(int id=0; id<=5; id++){
                mGenoma[id]=""+Habitante.numeroAleatorio(2, 7);
            }
            return mGenoma;
    }
    
    private Formulario frm1=null;
    
    
    public Hilo() {
        super(false, false);
        Habitante.cantidadDeHabitantes=100;
        frm1=new Formulario();
        frm1.setVisible(true);
        
        
        for(int i=1; i<=Habitante.cantidadDeHabitantes; i++){
            Habitante.add(new   Habitante(mGenomaAleatorio()));
            frm1.addPoblacionActual(Habitante.poblacion.get(Habitante.poblacion.size()-1).getGenes());
            frm1.addTodasLasPoblaciones(Habitante.poblacion.get(Habitante.poblacion.size()-1).getGenes());
        }
        
        
        System.out.println("Cantidad de habitantes ="+Habitante.poblacion.size());
//        this.activar();
    }
    
    private int contador=0;
    
    public Habitante []mOrdenarDeMenor_a_mayor(Habitante []dame_una_matriz){
        Habitante aux=null;
        Habitante []m=dame_una_matriz;
//        System.out.println("m="+dame_una_matriz.length);
        for(int idSuperior=0; idSuperior<dame_una_matriz.length; idSuperior++){
            for(int idInterno=0; idInterno<dame_una_matriz.length; idInterno++){
                if(m[idSuperior].getFitness()<m[idInterno].getFitness()){
                    aux=m[idInterno];
                    m[idInterno]=m[idSuperior];
                    m[idSuperior]=aux;
                }
            }
        }
//        System.out.println("m="+m.length);
        Habitante []mDosElegidos=new Habitante[2];
        mDosElegidos[0]=m[0];
        mDosElegidos[1]=m[1];
        return mDosElegidos;
    }
    
    private Habitante []seleccion(){
        Habitante []m=new Habitante[Habitante.poblacion.size()] ;
        for(int i=0; i<Habitante.poblacion.size(); i++){
            m[i]=Habitante.poblacion.get(i);
        }
        
        return mOrdenarDeMenor_a_mayor(m);
    }
    
    @Override
    public void produciendo() {
//        try{


        for(int i=0; i<Habitante.poblacion.size(); i++){
            Habitante.poblacion.get(i).setFitness(mGenomaModelo);
        }
            contador++;
            for(int i=0; i<Habitante.poblacion.size(); i++){
                for(int id=0; id<Habitante.poblacion.size(); id++){
                    Habitante.poblacion.get(i).setFitness(mGenomaModelo);
                }
            }
            

            Habitante []m=seleccion();
            frm1.setMejorHabitante(m[0].getGenes(), m[0].getFitness());
//            String datos="";
//            datos=""+mGenomaModelo[0]+mGenomaModelo[1]+mGenomaModelo[2]+mGenomaModelo[3]+mGenomaModelo[4]+mGenomaModelo[5];
//            System.out.println("Genoma modelo= + "  + datos + "\nMejor habitante " + m[0] + "; su fitness " + m[0].getFitness() + "\n\n");

            
            for(int i=0; i<Habitante.poblacion.size(); i++){
                if(m[0].getFitness()==0){
                    Habitante.poblacion.get(i).cruzamiento(Habitante.poblacion.get(Habitante.numeroAleatorio(0, Habitante.poblacion.size()-1)),Habitante.poblacion.get(Habitante.numeroAleatorio(0, Habitante.poblacion.size()-1)));
                }else{
                    Habitante.poblacion.get(i).cruzamiento(Habitante.poblacion.get(i),m[0]);
                }
                frm1.addPoblacionActual(Habitante.poblacion.get(i).getGenes() + " fitness " + Habitante.poblacion.get(i).getFitness());
                frm1.addTodasLasPoblaciones(Habitante.poblacion.get(i).getGenes()+ " fitness " + Habitante.poblacion.get(i).getFitness());
            }

            for(int i=0; i<Habitante.poblacion.size()/4; i++){
                Habitante.poblacion.get(Habitante.numeroAleatorio(0, Habitante.poblacion.size()-1)).mutar(mGenomaAleatorio());
            }

            
            
//        }catch(Exception e){}
        this.esperar(1000);
        this.setRecipienteLleno(true);
        if(contador==Habitante.cantidadDegeneraciones){
            this.desactivar();
        }
    }

    
    @Override
    public void gastado(boolean llenar_recipiente) {
        esperar(1100);
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

/**
 * Los genes puede ser un vector cargado con diferentes rutas.
 * Como cuando se crea un juego con una unidad que tenga diferentes movimientos.
 * @author Rafael
 */
class Habitante{
    public static int cantidadDeHabitantes=20;
    public static int cantidadDegeneraciones=100;
    public static int cantidadDeGenes=6;
    
    @Override
    public String toString(){
        return this.getGenes();
    }
    
    public static int instancias=-1;
    private int numero_de_instancia=-1;
    public void setNumeroDeInstancia(int nuevo_numero_de_instancia){
        numero_de_instancia=nuevo_numero_de_instancia;
    }
    public int getNumeroDeInstancia(){
        return numero_de_instancia;
    }
    
    public static ArrayList<Habitante> poblacion=new ArrayList();
    
    public Habitante(){
        instancias++;
        numero_de_instancia=instancias;
        Habitante.add(this);
    }
    
    public Habitante(String []mNuevosgenes){
        instancias++;
        numero_de_instancia=instancias;
        this.mGenes=mNuevosgenes;
        Habitante.add(this);
        
    }
    
    public static String add(Habitante nuevo_habitante){
        try{
            for(int i=0; i< poblacion.size(); i++){
                if(poblacion.get(i).getNumeroDeInstancia()==nuevo_habitante.getNumeroDeInstancia()){
                    poblacion.remove(i);
                    poblacion.add(nuevo_habitante);
                    return "Habitante modificado ";
                }
            }
        }catch(Exception e){}
        poblacion.add(nuevo_habitante);
        System.out.println(""+instancias);
        return "Agregando nuevo habitante.";
    }
    
    public String []mGenes={};
    
    public String []getmGenes(){
        return mGenes;
    }
    
    
    public String getGenes(){
        String respuesta="";
        for(String s: mGenes){
            respuesta+=s;
        }
        return respuesta;
    }
    
    public void cruzarmiento(Habitante un_habitante){
        String []mgenes_local={};
        String nuevo_genoma="";
        for(int i=0; i<mGenes.length/2;++i){
            nuevo_genoma+=mGenes[i]+"_";
        }
        for(int i=0; i<mGenes.length/2;++i){
            nuevo_genoma+=un_habitante.mGenes[i]+"_";
        }
        mgenes_local=nuevo_genoma.split("_");
        mGenes=mgenes_local;
        Habitante.add(this);
    }
    
    /**
     * Se elimina el genoma anterior indicando que es un nuevo individuo.
     * @param un_habitante
     * @param otro_habitante 
     */
    public void cruzamiento(Habitante un_habitante, Habitante otro_habitante){
        String []mGenes_local=ObtenerFitnessMitadDeGenes(un_habitante.getmGenes());
        String nuevo_genoma="";
        for(int i=0; i<mGenes_local.length/2;++i){
            nuevo_genoma+=mGenes_local[i]+"_";
        }
        mGenes_local=ObtenerFitnessMitadDeGenes(otro_habitante.getmGenes());
        for(int i=0; i<mGenes_local.length/2;++i){
            nuevo_genoma+=mGenes_local[i]+"_";
        }
        mGenes_local=nuevo_genoma.split("_");
        mGenes=mGenes_local;
    }
    
    /**
     * Cruza un habitante con este habitante.
     * @param un_habitante 
     */
     public void cruzamiento(Habitante un_habitante){
        String []mgenes_local={};
        String nuevo_genoma="";
        for(int i=0; i<mGenes.length/2;++i){
            nuevo_genoma+=un_habitante.mGenes[i]+"_";
        }
        for(int i=0; i<mGenes.length/2;++i){
            nuevo_genoma+=mGenes[i]+"_";
        }
        mgenes_local=nuevo_genoma.split("_");
        mGenes=mgenes_local;
        Habitante.add(this);
    }
    
    private int fitnessValor=0;
    
    public int getFitness(){
        return fitnessValor;
    }
    
    public void setFitness(Habitante habitante_objetivo){
        mGenesDeseados=habitante_objetivo.getmGenes();
        for(int i=0; i<mGenes.length;++i){
            if(mGenes[i].equalsIgnoreCase(habitante_objetivo.mGenes[i])){
                fitnessValor++;
            }
        }
        Habitante.add(this);
    }
    
    private void fitnessEnCero(){
        fitnessValor=0;
    }
    
    public static String []mGenesDeseados={};
    
    private String  []ObtenerFitnessMitadDeGenes(String []mGenes){
        String []m1=new String[mGenes.length];
        
        for(int i=0; i<mGenes.length; i++){
            m1[i]=mGenes[Habitante.numeroAleatorio(0,mGenes.length-1)];
        }
        return m1;
    }
    
    public void setFitness(String []mGenes_deseados){
        fitnessEnCero();
        for(int i=0; i<mGenes.length;++i){
            if(mGenes[i].equalsIgnoreCase(mGenes_deseados[i])==true){
                fitnessValor++;
            }
        }
        Habitante.add(this);
    }
    
    /**
     * El default se usa en las interfaces, nuevo truco.
     * @param Min
     * @param Max
     * @return 
     */
    public static int numeroAleatorio(int Min, int Max){
        if(Min==0){
            Min=-1;
            int rnd=0;
            for(int i=0;i<Max;i++){
                rnd= (int)(Math.random()*(Max-Min+1)+Min);
                if(rnd!=-1){
                    return rnd;
                }
            }
        }
        
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
    
    /**
     * Toma los genes de otro habitante para mutar o de algun individuo modelo que esta fuera de la poblacion.
     * @param habitante_que_proporcionara_los_genes Una instancia de Habitante.
     */
    public void mutar(String []mGenes_para_mutar){
        for(int i=0; i<mGenes.length/2;++i){
            mGenes[numeroAleatorio(0,mGenes.length-1)]=mGenes_para_mutar[numeroAleatorio(0,mGenes.length-1)];
        }
        Habitante.add(this);
    }
    
    /**
     * Solo recoloca algunos genes del mismo vector en diferentes partes.
     */
    public void mutar(){
        for(int i=0; i<mGenes.length/2;++i){
            mGenes[numeroAleatorio(0,mGenes.length-1)]=mGenes[numeroAleatorio(0,mGenes.length-1)];
        }
        Habitante.add(this);
    }
}

class Genes{
    
}