/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RedesNeuronales;

/**
 *
 * @author Jugador
 */
public class MiRedNN {
    
    private Neurona []mCapa1={new Neurona(), new Neurona(), new Neurona()};
    private Neurona []mCapa2={new Neurona(), new Neurona(), new Neurona()};
    
    
    private class Capa1 implements Red{

        @Override
        public void entradas(double[] mEntradas) {
            mCapa1[0].entradas(mEntradas);
        }

        @Override
        public void salidas(double[] mSalidas) {
            class Capa2 implements Red{

                @Override
                public void entradas(double[] mEntradas) {
                    mCapa2[0].entradas(mEntradas);
                }

                @Override
                public void salidas(double[] mSalidas) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
                
            }
            
            Capa2 c2=new Capa2();
            c2.entradas(mCapa1[0].getSalida());
        } //End salidas
    }
    
    
}


interface Red{
    
    void entradas(double []mEntradas);
    
    void salidas(double []mSalidas);
}

 class Neurona implements Red{
    private double e1,e2,e3;
    
    public double w1,w2,w3;
    
    private double ejemploDelobjetivo;
    
    public void setEjemploDelObjetivo(double ejemplo){
        ejemploDelobjetivo=ejemplo;
    }
    
    public double getEjemploDelObjetivo(){
        return ejemploDelobjetivo;
    }
    
    @Override
    public void entradas(double []mEntradas){
        e1=mEntradas[0];
        e2=mEntradas[1];
        e3=mEntradas[2];
        
        double []mSalidas;
        
        
        
    }
    
    private double []mSalidasCargadas;
    @Override
    public void salidas(double []mSalidas){
        double respuesta=e1*w1+e2*w2+e3*w3;
        if(getEjemploDelObjetivo()==respuesta){
            mSalidasCargadas=new double[3];
            mSalidasCargadas[0]=respuesta;
            mSalidasCargadas[1]=respuesta;
            mSalidasCargadas[2]=respuesta;
            
        }
    }
    
    public double []getSalida(){
        return mSalidasCargadas;
    }
}
