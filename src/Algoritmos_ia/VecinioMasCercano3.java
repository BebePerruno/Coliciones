/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class VecinioMasCercano3 {
    
    public VecinioMasCercano3()
    {
        double x=Math.sqrt(((44 - 4)/(88-4))^2);
x+=((56 - 49)/(33-26))^2;
System.out.println("Supuesta formula para elegir camino sqrt "+x);

        add(new Entrada(0,"a11",44));
        add(new Entrada(1,"a21",4));
        add(new Entrada(2,"a31",23));
        add(new Entrada(3,"a41",56));
        add(new Entrada(4,"a51",49));
        
        add(new Entrada(5,"b12",56));
        add(new Entrada(6,"ery",33));
        add(new Entrada(7,"c436",26));
        add(new Entrada(8,"dsrg",11));
        
        add(new Entrada(9,"Adf",41));
        add(new Entrada(10,"bdd",2));
        add(new Entrada(11,"cxx",6));
        add(new Entrada(12,"xd",4));
        
        add(new Entrada(13,"Aqw",12));
        add(new Entrada(14,"basz",13));
        add(new Entrada(15,"cz",16));
        add(new Entrada(16,"d56y",19));
        
        this.VecinosCercanos(9);
    }
    
    public ArrayList<Entrada> mEntradas=new ArrayList();
    
    private int f=0, c=0;
    
    public void add(Entrada newEntrada){
        mEntradas.add(newEntrada);
    }
    
    private Entrada []mVectorEntradas={};
    
    /**
     * Ordena todo en un vector.
     * ordena con el metodo de la burbuja.
     */
    private void ordenar(){
        mVectorEntradas=new Entrada[mEntradas.size()];
        int cont=0;
        for (int f=0; f<mEntradas.size(); f++){
            mVectorEntradas[f]=mEntradas.get(f);
        }
        Entrada temp=null;
        for (int f=0; f<this.mVectorEntradas.length; f++){
            for (int f1=0; f1<this.mVectorEntradas.length; f1++)
            {
                if(mVectorEntradas[f].valor<mVectorEntradas[f1].valor)
                {
                    temp=mVectorEntradas[f];
                    mVectorEntradas[f]=mVectorEntradas[f1];
                    mVectorEntradas[f1]=temp;
                }
            }   
        }
        
        System.out.println("Lista ordenada:");
        for (int f1=0; f1<this.mVectorEntradas.length; f1++)
        {
            System.out.println(mVectorEntradas[f1].toString());
        }
    }
    
    /**
     * Se usa en VecinosCercanos.
     * @param id
     * @return 
     */
    private Entrada getUnVecinoOrdenado(int id){
        try{
            return mVectorEntradas[id-1];
        }catch(Exception e){}
        return null;
    }
    
    /**
     * Ordena la lista y luego devuelve un vector con los vecinos más cercanos.
     * @param id
     * @return 
     */
    private Entrada []VecinosCercanos(int id){
        ordenar();
        Entrada []m=new Entrada[4];
        m[0]=getUnVecinoOrdenado(id-2);
        m[1]=getUnVecinoOrdenado(id-1);
        m[2]=getUnVecinoOrdenado(id+1);
        m[3]=getUnVecinoOrdenado(id+2);
        System.out.println("\n\nVecinos cercanos a id =" + id +"\n\n");
        
        for(int i=0; i<4; i++)
        {
            try{
                System.out.println(m[i].toString());
                if(i==1)
                {
                    System.out.println("Punto inicial " + getUnVecinoOrdenado(id));
                }
            }catch(Exception e){
                System.out.println("El id "+i+" es null");
            }
        }
        return m;
    }
    
    public static void main(String []m)
    {
        
        
        new VecinioMasCercano3();
    }
    
}

class Entrada{
    
    public Entrada (int newId, String newNombre, double newValor)
    {
        nombre=newNombre;
        valor=newValor;
        id=newId;
    }
    
    public String nombre="";
    public double valor=0;
    public int id=-1;
    
    @Override
    public String toString(){
        return "id " + id + ", nombre " + nombre + ", valor " + valor;
    }
}