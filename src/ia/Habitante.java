/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

import java.util.ArrayList;
import java.util.Random;

/**
 * Los genes puede ser un vector cargado con diferentes rutas.
 * Como cuando se crea un juego con una unidad que tenga diferentes movimientos.
 * @author Rafael
 */
public class Habitante implements iAlgoritmoGenetico<Habitante, String>{
    
    public static String []mGenomaAleatorio(){
        String []mGenoma=new String[Habitante.cantidadDeGenes];
        for(int id=0; id<Habitante.cantidadDeGenes; id++){
            int numero=Habitante.numeroAleatorio(0, Habitante.cantidadDeGenes);
            if(numero<0){
                numero=0;
            }
            if(numero>Habitante.mGenesDeseados.length-1){
                numero=Habitante.mGenesDeseados.length-1;
            }
            mGenoma[id]=""+Habitante.mGenesDeseados[numero] ;
        }
        return mGenoma;
    }
    
    public static int cantidadDeHabitantes=0;
    public static int cantidadDegeneraciones=0;
    public static int cantidadDeGenes=0;
    
    @Override
    public String toString(){
        return this.getGenes() + ", fitness " + this.getFitness() ;
    }
    
    public static int instancias=-1;
    private int numero_de_instancia=-1;
    @Override
    public void setNumeroDeInstancia(int nuevo_numero_de_instancia){
        numero_de_instancia=nuevo_numero_de_instancia;
    }
    @Override
    public int getNumeroDeInstancia(){
        return numero_de_instancia;
    }
    
    public static ArrayList<Habitante> rsPoblacion=new ArrayList();
    
    public Habitante(){
        instancias++;
        numero_de_instancia=instancias;
        Habitante.add(this);
    }
    
    public Habitante(String []mNuevosGenes){
        instancias++;
        numero_de_instancia=instancias;
        this.mGenes=mNuevosGenes;
        Habitante.add(this);
    }
    
    /**
     * Si el habitante ya existe entonces solo se actualizan sus datos.
     * @param nuevo_habitante Un objeto del class Habitante.
     * @return Un texto indicando que se ha agregado un habitante.
     */
    public static String add(Habitante nuevo_habitante){
        rsPoblacion.add(nuevo_habitante);
//        System.out.println("Numero de instancia "+instancias);
        return "Nuevo habitante agregado id="+instancias;
    }
    
    public void clonar(Habitante nuevo_habitante_a_clonar){
        this.fitnessValor=nuevo_habitante_a_clonar.fitnessValor;
        this.mGenes=nuevo_habitante_a_clonar.mGenes;
        this.numero_de_instancia=nuevo_habitante_a_clonar.numero_de_instancia;
    }
    
    public static String modificar(Habitante nuevo_habitante){
        try{
            for(int i=0; i< rsPoblacion.size(); i++){
                if(rsPoblacion.get(i).getNumeroDeInstancia()==nuevo_habitante.getNumeroDeInstancia()){
                    rsPoblacion.get(i).clonar(nuevo_habitante);
                    return "Habitante modificado en modificar";
                }
            }
        }catch(Exception e){
        
        }
        return "Modificado ";
    }
    
    public String []mGenes={};
    
    @Override
    public String []getmGenes(){
        return mGenes;
    }
    
    
    @Override
    public String getGenes(){
        String respuesta="";
        for(String s: mGenes){
            respuesta+=s;
        }
        return respuesta;
    }
    
    @Override
    public void cruzarmiento(Habitante un_habitante){
        this.fitnessEnCero();
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
        Habitante.modificar(this); //No porque ya se usa en Fitness.
    }
    
    /**
     * Se elimina el genoma anterior indicando que es un nuevo individuo.
     * @param un_habitante
     * @param otro_habitante 
     */
    @Override
    public void cruzamiento(Habitante un_habitante, Habitante otro_habitante){
        try{
            String []mGenes_local=ObtenerFitnessMitadDeGenes(un_habitante.getmGenes());
            String []mGenes_local2=ObtenerFitnessMitadDeGenes(otro_habitante.getmGenes());
            String nuevo_genoma="";
//            this.fitnessEnCero(); //Verificar despues
            for(int i=0; i<Habitante.cantidadDeGenes/2;++i){
                nuevo_genoma+=mGenes_local[i]+"_";
                nuevo_genoma+=mGenes_local2[i]+"_";
            }
//            mGenes_local=ObtenerFitnessMitadDeGenes(otro_habitante.getmGenes());
//            for(int i=0; i<Habitante.cantidadDeGenes/2;++i){
//                nuevo_genoma+=mGenes_local[i]+"_";
//            }
            mGenes_local=nuevo_genoma.split("_");
            mGenes=mGenes_local;
//            fitnessEnCero();
            Habitante.modificar(this);
        }catch(Exception e){
            System.err.println("error en cruzamiento");
        }
    }
    
    /**
     * Cruza un habitante con este habitante.
     * @param un_habitante 
     */
    @Override
     public void cruzamiento(Habitante un_habitante){
         fitnessEnCero();
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
        Habitante.modificar(this);
    }
    
    private int fitnessValor=0;
    
    @Override
    public int getFitness(){
        return fitnessValor;
    }
    
    @Override
    public void setFitness(Habitante habitante_objetivo){
        mGenesDeseados=habitante_objetivo.getmGenes();
        for(int i=0; i<mGenes.length;++i){
            if(mGenes[i].equalsIgnoreCase(habitante_objetivo.mGenes[i])){
                fitnessValor++;
            }
        }
        Habitante.modificar(this);
    }
    
    public void fitnessEnCero(){
        fitnessValor=0;
    }
    
    public static String []mGenesDeseados={};
    
    @Override
    public String  []ObtenerFitnessMitadDeGenes(String []mGenes){
        String []m1=new String[mGenes.length];
        
        for(int i=0; i<mGenes.length; i++){
            m1[i]=mGenes[Habitante.numeroAleatorio(0,mGenes.length-1)];
        }
        return m1;
    }
    
    @Override
    public void setFitness(String []mGenes_deseados){
        fitnessEnCero();
        for(int i=0; i<mGenes_deseados.length;i++){
                if(mGenes[i].equalsIgnoreCase(mGenes_deseados[i])==true){
                    fitnessValor++;
                }
            Habitante.modificar(this);
        }
        
        //fitnessValor/=mGenes_deseados.length;
        //Esta formula permite que si alguno tiene la solucion se de un uno.
        //pero no permite que se generen soluciones parciales.
        //Pero no sirve.
//        System.out.println("Evaluando fitness "+fitnessValor); 
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
    @Override
    public void mutar(String []mGenes_para_mutar){
        for(int i=0; i<mGenes.length/2;++i){
            mGenes[numeroAleatorio(0,mGenes.length-1)]=mGenes_para_mutar[numeroAleatorio(0,mGenes.length-1)];
        }
        Habitante.modificar(this);
    }
    
    /**
     * Solo recoloca algunos genes del mismo vector en diferentes partes.
     */
    @Override
    public void mutar(){
        for(int i=0; i<mGenes.length/2;++i){
            mGenes[numeroAleatorio(0,mGenes.length-1)]=mGenesDeseados[numeroAleatorio(0,mGenes.length-1)];
        }
        Habitante.modificar(this);
    }
}
