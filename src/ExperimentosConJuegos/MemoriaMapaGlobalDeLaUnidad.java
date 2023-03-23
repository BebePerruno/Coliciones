/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import java.util.ArrayList;

/**
 *Permite agregar muchas rutas.
 * Opciones de creacion: Usar un ArrayLis del class rsMemoriasDeTodosLosCaminos o usar un ArrayList para guardar solo los indices de cada camino.
 * 
 * @author Jugador
 */
public class MemoriaMapaGlobalDeLaUnidad {
    private ArrayList<IndicesDeRutas> rsIndicesDeRutas=new ArrayList();
    
    private MemoriaRuta ruta=new MemoriaRuta();
    
    
    
    public class IndicesDeRutas{
        private int idInicio=0;
        public void getIdInicio(int nuevo_id_de_inicio){
            idInicio=nuevo_id_de_inicio;
        }
        
        public int getIdInicio(){
            return idInicio;
        }
        
        private int idFinal=0;
        public void getIdFinal(int nuevo_id_de_inicio){
            idFinal=nuevo_id_de_inicio;
        }
        
        public int getIdFinal(){
            return idFinal;
        }
    }
    
}
