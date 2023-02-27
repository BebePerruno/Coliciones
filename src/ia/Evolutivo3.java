/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 *
 * @author Rafael
 */
public class Evolutivo3 {
    
}

/**
 * Los genes puede ser un vector cargado con diferentes rutas.
 * Como cuando se crea un juego con una unidad que tenga diferentes movimientos.
 * @author Rafael
 */
class Habitante{
    public String []mGenes={};
    
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
    }
    
    public void aparear(Habitante un_habitante, Habitante otro_habitante){
        String []mgenes_local={};
        String nuevo_genoma="";
        for(int i=0; i<mGenes.length/2;++i){
            nuevo_genoma+=un_habitante.mGenes[i]+"_";
        }
        for(int i=0; i<mGenes.length/2;++i){
            nuevo_genoma+=otro_habitante.mGenes[i]+"_";
        }
        mgenes_local=nuevo_genoma.split("_");
        mGenes=mgenes_local;
    }
    
    private int fitnessValor=0;
    
    public int getFintness(){
        return fitnessValor;
    }
    
    public void setFitness(Habitante habitante_objetivo){
        for(int i=0; i<mGenes.length;++i){
            if(mGenes[i].equalsIgnoreCase(habitante_objetivo.mGenes[i])){
                fitnessValor++;
            }
        }
    }
    
    /**
     * El default se usa en las interfaces, nuevo truco.
     * @param Min
     * @param Max
     * @return 
     */
    public int numeroAleatorio(int Min, int Max){
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
    
    public void mutar(Habitante habitante_que_proporcionara_los_genes){
        for(int i=0; i<mGenes.length/2;++i){
            mGenes[numeroAleatorio(0,mGenes.length-1)]=habitante_que_proporcionara_los_genes.mGenes[numeroAleatorio(0,mGenes.length-1)];
        }
    }
    
}