/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import ia.AGPoblacion;
import ia.Habitante;
import ia.OrdenamientoDeLaPoblacion;

/**
 *
 * @author Jugador
 */
public abstract class PoblacionDeUnidades  extends OrdenamientoDeLaPoblacion<Cerrebro> implements AGPoblacion{

    

    @Override
    public void cruzamiento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void evolucionar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double fitness() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mutacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void poblacionInicial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void seleccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setGenomaObjetivo(String[] mGenomaObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Cerrebro[] mOrdenarDeMenor_a_mayor(Habitante[] dame_una_matriz) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Cerrebro[] ordenarPoblacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String []matrizGenomaAleatorio(){
        String []mGenoma={};//new String[Habitante.cantidadDeGenes];
//        for(int id=0; id<Habitante.cantidadDeGenes; id++){
//            int numero=Habitante.numeroAleatorio(0, Habitante.cantidadDeGenes);
//            if(numero<0){
//                numero=0;
//            }
//            if(numero>Habitante.mGenesDeseados.length-1){
//                numero=Habitante.mGenesDeseados.length-1;
//            }
//            mGenoma[id]=""+Habitante.mGenesDeseados[numero] ;
//        }
//        return mGenoma;
        return mGenoma;
    }
    
}
